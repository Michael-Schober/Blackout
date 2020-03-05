package blackout.shop.repository;

import Blackout.shared.model.shop.Shop;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ShopRepository extends ReactiveCrudRepository<Shop, Long>
{

}
