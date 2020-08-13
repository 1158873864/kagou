package jinjiang.blservice.shop;

import jinjiang.entity.shop.Type;
import jinjiang.exception.NotExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeBlService {

    void addType(Type type);

    void deleteType(String id) throws NotExistException;

    void updateType(Type type) throws NotExistException;

    Type findById(String id) throws NotExistException;

    Page<Type> findAll(Pageable pageable);
}
