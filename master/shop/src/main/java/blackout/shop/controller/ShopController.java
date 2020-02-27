package blackout.shop.controller;

import Blackout.shared.model.shop.Shop;
import blackout.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ShopController
{
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/shop")
    public List<Shop> getAll()
    {
        return shopRepository.findAll();
    }

    @GetMapping("/shop/{id}")
    public Shop getById(@PathVariable("id")long id)
    {
        return shopRepository.getOne(id);
    }

    @PostMapping("/shop/admin")
    public Shop createNew(@RequestBody Shop shop)
    {
        shop.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        return shopRepository.save(shop);
    }

    @PutMapping("/shop/admin/{id}")
    public Shop updateShop(@RequestBody Shop shop)
    {
        if(shopRepository.existsById(shop.getS_id()))
        {
            Shop toUpdate = shopRepository.getOne(shop.getS_id());
            toUpdate.setName(shop.getName());
            toUpdate.setOwner(shop.getOwner());
            toUpdate.setCity(shop.getCity());
            toUpdate.setDistrict(shop.getDistrict());
            toUpdate.setStreet(shop.getStreet());
            toUpdate.setClosing(shop.getClosing());
            toUpdate.setOpening(shop.getOpening());

            return shopRepository.save(toUpdate);
        }
        return null;
    }
}
