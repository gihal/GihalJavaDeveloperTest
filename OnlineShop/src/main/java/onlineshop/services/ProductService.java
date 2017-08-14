package onlineshop.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import onlineshop.data.DataClass;
import onlineshop.entities.Product;

/**
 *
 * @author gihal
 */
public class ProductService {

    private Map<Long, Product> productsMap = DataClass.getProducts();

    /**
     * Get all products
     *
     * @return Returns the list of products
     */
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(productsMap.values());
    }

    /**
     * Get the product that match with the given id
     *
     * @param productId The id of the product
     * @return Returns the product
     */
    public Product getProduct(long productId) {
        return productsMap.get(productId);
    }

    /**
     * Update the given product
     *
     * @param product The product which is going to be updated
     */
    public void updateProduct(Product product) {
        productsMap.put(product.getId(), product);
    }

}
