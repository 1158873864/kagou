package jinjiang.dao.shop;

import jinjiang.entity.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopDao extends JpaRepository<Shop,String> {
    Optional<Shop> findByName(String name);
}
