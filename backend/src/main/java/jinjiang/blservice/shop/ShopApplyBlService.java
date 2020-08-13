package jinjiang.blservice.shop;

import jinjiang.entity.shop.Shop;
import jinjiang.entity.shop.ShopApply;
import jinjiang.exception.NotExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface ShopApplyBlService {

    void addShopApply(ShopApply shopApply);

    void deleteShopApply(String id) throws NotExistException;

    void updateShopApply(ShopApply shopApply) throws NotExistException;

    ShopApply findById(String id) throws NotExistException;

    Page<ShopApply> findAll(Pageable pageable);

    Page<ShopApply> findByStatus(String status,Pageable pageable);

    ShopApply findByUserId(String userId);

    void pass(String id);

    void dispass(String id);
}
