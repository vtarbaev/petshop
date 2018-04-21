package petshop.app.api.data;

import petshop.app.model.Product;

import java.util.List;

public class Products {

    private int total;
    private List<Product> products;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
