package jinjiang.bl.shop;

import jinjiang.blservice.shop.GoodsColorBlService;
import jinjiang.dao.shop.GoodsColorDao;
import jinjiang.entity.shop.GoodsColor;
import jinjiang.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsColorBlServiceImpl implements GoodsColorBlService {

    private final GoodsColorDao goodsColorDao;


    @Autowired
    public GoodsColorBlServiceImpl(GoodsColorDao goodsColorDao){

        this.goodsColorDao = goodsColorDao;
    }

    @Override
    public GoodsColor addGoodsColor(GoodsColor goodsColor) {
        return  goodsColorDao.save(goodsColor);
    }

    @Override
    public void deleteGoodsColor(String id) throws NotExistException {
       Optional<GoodsColor> optionalFreight=goodsColorDao.findById(id);
       if (optionalFreight.isPresent()){
           goodsColorDao.deleteById(id);
       }
    }

    @Override
    public GoodsColor findById(String id) throws NotExistException {
        Optional<GoodsColor> optionalFreight=goodsColorDao.findById(id);
        if (optionalFreight.isPresent()){
            return optionalFreight.get();
        }else {
            throw new NotExistException("Fit ID", id);
        }

    }


}
