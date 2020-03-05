package blackout.shop.controller;

import Blackout.shared.model.shop.Shop;
import blackout.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class ShopController
{
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping(value = "/shop", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Shop> getAllShops(
            @RequestParam(value = "page", defaultValue = "0") long page,
            @RequestParam(value = "size", defaultValue = "10") long size)
    {
        return shopRepository.findAll().skip(page*size).take(size);
    }

    @PostMapping(value = "/shop/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Shop> createNewShop(@RequestBody Shop shop)
    {
        return shopRepository.save(shop);
    }
}
