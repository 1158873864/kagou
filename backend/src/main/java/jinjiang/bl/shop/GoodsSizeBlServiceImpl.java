package jinjiang.bl.shop;

import jinjiang.blservice.shop.GoodsSizeBlService;
import jinjiang.dao.shop.GoodsSizeDao;
import jinjiang.entity.shop.GoodsSize;
import jinjiang.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsSizeBlServiceImpl implements GoodsSizeBlService {

    private final GoodsSizeDao goodsColorDao;


    @Autowired
    public GoodsSizeBlServiceImpl(GoodsSizeDao goodsColorDao){
        this.goodsColorDao = goodsColorDao;
    }

    @Override
    public GoodsSize addGoodsSize(GoodsSize goodsSize) {
        return  goodsColorDao.save(goodsSize);
    }

    @Override
    public void deleteGoodsSize(String id) throws NotExistException {
       Optional<GoodsSize> optionalFreight=goodsColorDao.findById(id);
       if (optionalFreight.isPresent()){
           goodsColorDao.deleteById(id);
       }
    }

    @Override
    public GoodsSize findById(String id) throws NotExistException {
        Optional<GoodsSize> optionalFreight=goodsColorDao.findById(id);
        if (optionalFreight.isPresent()){
            return optionalFreight.get();
        }else {
            throw new NotExistException("Fit ID", id);
        }

    }


}
