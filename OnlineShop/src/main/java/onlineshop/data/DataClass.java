package onlineshop.data;

import java.util.HashMap;
import java.util.Map;
import onlineshop.entities.Order;
import onlineshop.entities.Product;

/**
 *
 * @author gihal
 */
public class DataClass {

    private static final Map<Long, Product> PRODUCTS_MAP = new HashMap<Long, Product>();
    private static final Map<Long, Order> ORDERS_MAP = new HashMap<Long, Order>();

    static {
        //Product A
        Product typeA = new Product(1, "Product A", "Product A description", 20);
        PRODUCTS_MAP.put(typeA.getId(), typeA);

        //Product B
        Product typeB = new Product(2, "Product B", "Product B description", 10);
        PRODUCTS_MAP.put(typeB.getId(), typeB);
    }

    public static Map<Long, Product> getProducts() {
        return PRODUCTS_MAP;
    }

    public static Map<Long, Order> getOrders() {
        return ORDERS_MAP;
    }
}
