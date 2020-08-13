package jinjiang.dao.shop;

import jinjiang.entity.shop.Goods;
import jinjiang.exception.NotExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GoodsDao extends JpaRepository<Goods, String> {

    Page<Goods> findAllByShopId(String ShopId, Pageable pageable) throws NotExistException;
    Page<Goods> findByTypeId(String typeId,Pageable pageable);
    Page<Goods> findByTypeIdAndShopId(String typeId,String shopId,Pageable pageable);
    Page<Goods> findByModule(String module,Pageable pageable);
    Page<Goods> findByModuleAndShopId(String module,String shopId,Pageable pageable);
    Page<Goods> findByModuleAndTypeId(String module,String typeId,Pageable pageable);
    Page<Goods> findByModuleAndTypeIdAndShopId(String module,String typeId,String shopId,Pageable pageable);
}
