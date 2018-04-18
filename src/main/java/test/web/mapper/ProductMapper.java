package test.web.mapper;

import org.apache.ibatis.annotations.*;
import test.web.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM products")
    List<Product> findAll();

    @Insert("INSERT INTO products(name, cost) VALUES(#{name}, #{cost})")
    @Options(useGeneratedKeys = true)
    void create(Product product);

    @Update("UPDATE products SET name = #{name}, cost = #{cost} WHERE id = #{id}")
    void update(Product product);
}
