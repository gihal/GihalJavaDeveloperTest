package onlineshop.entities;

import java.util.Objects;

/**
 *
 * @author gihal
 */
public class Order {

    private Long id;
    private long ptrProduct;
    private int quantity;

    public Order() {
    }

    public Order(long id, Product product, int quantity) {
        this.id = id;
        if (product == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }
        this.ptrProduct = product.getId();
        this.quantity = quantity;
    }

    /**
     * Get the id of the order
     *
     * @return Returns the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the order
     *
     * @param id The id of the order
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the id of the product type
     *
     * @return Returns the id of the product type
     */
    public long getPtrProduct() {
        return ptrProduct;
    }

    /**
     * Set the product that cannot be null
     *
     * @param product The product
     */
    public void setPtrProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }
        this.ptrProduct = product.getId();
    }

    /**
     * Get the quantity
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity that cannot be less than or equal to zero
     *
     * @param quantity Quantity
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be less than or equal to zero");
        }
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + (int) (this.ptrProduct ^ (this.ptrProduct >>> 32));
        hash = 67 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.ptrProduct != other.ptrProduct) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
