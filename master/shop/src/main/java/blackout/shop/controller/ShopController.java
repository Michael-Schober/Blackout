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
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName)
                .flatMap(shopRepository::getByOwner);
    }



    // Does not Return the right id, it`s always 0. Returns Obeject before it`s inserted, but only if it is successful
    @PostMapping(value = "/shop/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Shop> createNewShop(@RequestBody Shop shop) {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName)
                .map(s -> { shop.setOwner(s); return shop; })
                .flatMap(this::saveShop);
    }

    private Mono<Shop> saveShop(Shop s)
    {
        return shopRepository.save(s);
    }
}
