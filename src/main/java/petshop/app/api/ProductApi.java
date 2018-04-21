package petshop.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import petshop.app.api.data.Products;
import petshop.app.model.Product;
import petshop.app.service.ProductService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/api/products")
public class ProductApi {

    private ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public Products products() {
        List<Product> products = productService.products();

        Products result = new Products();
        result.setProducts(products);
        result.setTotal(products.size());

        return result;
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }



}
