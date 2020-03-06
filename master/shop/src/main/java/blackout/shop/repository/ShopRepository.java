package blackout.shop.repository;

import Blackout.shared.model.shop.Shop;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ShopRepository extends ReactiveCrudRepository<Shop, Long>
{
    @Query("Select * From shop where owner = :id")
    public Flux<Shop> getByOwner(String id);
}
