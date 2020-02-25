package blackout.shop.repository;

import Blackout.shared.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long>
{

}
