package jinjiang.bl.shop;

import jinjiang.blservice.shop.ShopApplyBlService;
import jinjiang.dao.admin.AdminDao;
import jinjiang.dao.admin.DeductDao;
import jinjiang.dao.shop.ShopApplyDao;
import jinjiang.dao.shop.ShopDao;
import jinjiang.entity.admin.Deduct;
import jinjiang.entity.shop.Shop;
import jinjiang.entity.shop.ShopApply;
import jinjiang.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopApplyBlServiceImpl implements ShopApplyBlService {
    private final ShopDao shopdao;
    private final ShopApplyDao shopApplyDao;
    private final AdminDao adminDao;
    private final DeductDao deductDao;

    @Autowired
    public ShopApplyBlServiceImpl(ShopDao shopdao, ShopApplyDao shopApplyDao, AdminDao adminDao, DeductDao deductDao){
        this.shopdao=shopdao;
        this.shopApplyDao=shopApplyDao;
        this.adminDao = adminDao;
        this.deductDao = deductDao;
    }

    @Override
    public void addShopApply(ShopApply shopApply) {
        shopApplyDao.save(shopApply);
    }

    @Override
    public void deleteShopApply(String id) throws NotExistException {
        Optional<ShopApply> optionalShopApply=shopApplyDao.findById(id);
        if (optionalShopApply.isPresent()){
           shopApplyDao.deleteById(id);
        }else {
            throw new NotExistException("ShopApply ID", id);
        }
    }

    @Override
    public void updateShopApply(ShopApply shopApply) throws NotExistException {
        Optional<ShopApply> optionalShopApply=shopApplyDao.findById(shopApply.getId());
        if (optionalShopApply.isPresent()){
            ShopApply shopinfo=optionalShopApply.get();
            shopinfo.setBalance(shopApply.getBalance());
            shopinfo.setCity(shopApply.getCity());
            shopinfo.setDetail(shopApply.getDetail());
            shopinfo.setDistrict(shopApply.getDistrict());
            shopinfo.setFaceUrl(shopApply.getFaceUrl());
            shopinfo.setMobilePhone(shopApply.getMobilePhone());
            shopinfo.setName(shopApply.getName());
            shopinfo.setProvince(shopApply.getProvince());
            shopinfo.setShowUrl(shopApply.getShowUrl());
            shopinfo.setWorkTime(shopApply.getWorkTime());
            shopinfo.setStatus(shopApply.getStatus());
            shopinfo.setUserId(shopApply.getUserId());
            shopinfo.setLicense(shopApply.getLicense());
            shopinfo.setCardFront(shopApply.getCardFront());
            shopinfo.setCardBack(shopApply.getCardBack());
            shopinfo.setOther(shopApply.getOther());
            shopApplyDao.save(shopinfo);
        }else {
            throw new NotExistException("ShopApply ID", shopApply.getId());
        }


    }

    @Override
    public ShopApply findById(String id) throws NotExistException {
       Optional<ShopApply> shop=shopApplyDao.findById(id);
       if (shop.isPresent()){
           return shop.get();
       }else {
           throw new NotExistException("ShopApply ID", id);
       }

    }

    @Override
    public Page<ShopApply> findAll(Pageable pageable) {
        Page<ShopApply> shops=shopApplyDao.findAll(pageable);
        return shops;
    }

    @Override
    public Page<ShopApply> findByStatus(String status, Pageable pageable) {
        return shopApplyDao.findByStatus(status,pageable);
    }


    @Override
    public ShopApply findByUserId(String userId) {
        return shopApplyDao.findByUserId(userId);
    }

    @Override
    public void pass(String id) {
        Optional<ShopApply> optionalShopApply=shopApplyDao.findById(id);
        if(optionalShopApply.isPresent()){
            ShopApply shopApply=optionalShopApply.get();
            shopApply.setStatus("通过");
            Shop shop=new Shop(shopApply.getName(),shopApply.getMobilePhone(),shopApply.getPassword(),shopApply.getWorkTime(),shopApply.getProvince(),shopApply.getCity(),shopApply.getDistrict(),shopApply.getDetail(),shopApply.getBalance(),shopApply.getFaceUrl(),shopApply.getShowUrl(),shopApply.getUserId());
            String shopId=shopdao.save(shop).getId();
            Deduct deduct=new Deduct(0.9,0,0,0,shopId);
            deductDao.save(deduct);
            shopApplyDao.save(shopApply);
        }
    }

    @Override
    public void dispass(String id) {
        Optional<ShopApply> optionalShopApply=shopApplyDao.findById(id);
        if(optionalShopApply.isPresent()){
            ShopApply shopApply=optionalShopApply.get();
            shopApply.setStatus("未通过");
            shopApplyDao.save(shopApply);
        }
    }


}
