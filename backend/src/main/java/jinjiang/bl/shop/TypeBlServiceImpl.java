package jinjiang.bl.shop;

import jinjiang.blservice.shop.TypeBlService;
import jinjiang.dao.shop.TypeDao;
import jinjiang.entity.shop.Type;
import jinjiang.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TypeBlServiceImpl implements TypeBlService {
    private final TypeDao typeDao;

    @Autowired
    public TypeBlServiceImpl(TypeDao typeDao){
        this.typeDao=typeDao;
    }

    @Override
    public void addType(Type type) {
        typeDao.save(type);
    }

    @Override
    public void deleteType(String id) throws NotExistException {
        Optional<Type> optionalType=typeDao.findById(id);
        if (optionalType.isPresent()){
           typeDao.deleteById(id);
        }else {
            throw new NotExistException("Type ID", id);
        }
    }

    @Override
    public void updateType(Type type) throws NotExistException {
        Optional<Type> optionalType=typeDao.findById(type.getId());
        if (optionalType .isPresent()){
           Type newType=new Type();
           newType.setName(type.getName());
        }else {
            throw new NotExistException("type ID", type.getId());
        }
    }

    @Override
    public Type findById(String id) throws NotExistException {
       Optional<Type> shop=typeDao.findById(id);
       if (shop.isPresent()){
           return shop.get();
       }else {
           throw new NotExistException("shop ID", id);
       }
    }

    @Override
    public Page<Type> findAll(Pageable pageable) {
        Page<Type> shops=typeDao.findAll(pageable);
        return shops ;
    }
}
