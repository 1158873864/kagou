package jinjiang.dao.shop;

import jinjiang.entity.shop.ShopApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopApplyDao extends JpaRepository<ShopApply,String> {
    Page<ShopApply> findByStatus(String status, Pageable pageable);
    ShopApply findByUserId(String userId);

}
