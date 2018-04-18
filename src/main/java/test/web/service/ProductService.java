package test.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.web.mapper.ProductMapper;
import test.web.model.Product;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private ProductMapper productMapper;

    @Inject
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Transactional(readOnly = true)
    public List<Product> products() {
        return productMapper.findAll();
    }

    @Transactional
    public Product create(Product product) {
        productMapper.create(product);
        return product;
    }

    @Transactional
    public void updateProduct(Product product) {
        productMapper.update(product);
    }
}
