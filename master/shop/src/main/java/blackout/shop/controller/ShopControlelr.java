package blackout.shop.controller;

import Blackout.shared.model.shop.Shop;
import blackout.shop.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@CrossOrigin("*")
public class ShopControlelr
{
    @Autowired
    private ShopRepo shopRepo;


    @GetMapping("")
    public List<Shop> getAllShops()
    {
        return shopRepo.findAll();
    }
}
