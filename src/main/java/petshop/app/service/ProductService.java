package petshop.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petshop.app.mapper.ProductMapper;
import petshop.app.model.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductMapper productMapper;

    public List<Product> products() {
        return productMapper.findAll();
    }

    @PostConstruct
    @Transactional
    public void init() {
        LOGGER.debug("init");
        if (productMapper.findAll().isEmpty()) {
            Product product = new Product("test1", 100);
            productMapper.create(product);
            product = new Product("test2", 200);
            productMapper.create(product);
        }
    }

    @Transactional
    public Product save(Product product) {
        if (product.getId() == 0) {
            productMapper.create(product);
        } else {
            productMapper.update(product);
        }
        return product;
    }
}
