package blackout.shop.controller;

import Blackout.shared.model.shop.Shop;
import blackout.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RestController
@CrossOrigin("*")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping(value = "/shop", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Shop> getAllShops(
            @RequestParam(value = "page", defaultValue = "0") long page,
            @RequestParam(value = "size", defaultValue = "10") long size) {
        return shopRepository.findAll().skip(page * size).take(size);
    }

    @GetMapping(value = "/shop/owned", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Shop> getOwnedShops()
    {
        return  getTokenOwner()
                    .flatMapMany(s -> shopRepository.getByOwner(s));
    }

    @PostMapping(value = "/shop/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Shop> createNewShop(@RequestBody Shop shop) {
        return getTokenOwner()
                     .flatMap(s -> { shop.setOwner(s); return shopRepository.save(shop); });
    }

    private Mono<String> getTokenOwner()
    {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName);
    }
}
