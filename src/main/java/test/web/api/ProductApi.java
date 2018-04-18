package test.web.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import test.web.model.Product;
import test.web.service.ProductService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApi.class);

    private ProductService productService;

    @Inject
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> product() {
        return productService.products();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.updateProduct(product);
        return product;
    }

}
