package jinjiang.blservice.shop;


import jinjiang.entity.shop.GoodsSize;
import jinjiang.exception.NotExistException;

public interface GoodsSizeBlService {
    GoodsSize addGoodsSize(GoodsSize goodsSize);

    void deleteGoodsSize(String id) throws NotExistException;

    GoodsSize findById(String id) throws NotExistException;
}
