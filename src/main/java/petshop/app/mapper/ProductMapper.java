package petshop.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import petshop.app.model.Product;

import java.util.List;

public interface ProductMapper {

    @Select("SELECT * FROM products")
    List<Product> findAll();

    @Insert("INSERT INTO products(name,cost) VALUES(#{name},#{cost})")
    @Options(useGeneratedKeys = true)
    void create(Product product);

    @Update("UPDATE products SET name = #{name}, cost = #{cost} WHERE id = #{id}")
    void update(Product product);
}
