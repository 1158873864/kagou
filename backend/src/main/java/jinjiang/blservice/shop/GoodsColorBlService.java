package jinjiang.blservice.shop;


import jinjiang.entity.shop.GoodsColor;
import jinjiang.exception.NotExistException;

public interface GoodsColorBlService {
    GoodsColor addGoodsColor(GoodsColor goodsColor);

    void deleteGoodsColor(String id) throws NotExistException;

    GoodsColor findById(String id) throws NotExistException;
}
