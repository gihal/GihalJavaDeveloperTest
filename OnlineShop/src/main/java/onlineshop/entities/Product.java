package onlineshop.entities;

import onlineshop.general.GeneralUtils;

/**
 *
 * @author gihal
 */
public class Product {

    private long id;
    private String name;
    private String description;
    private int availableItems;

    public Product() {
    }

    public Product(long id, String name, String description, int availableItems) {
        this.id = id;
        if (GeneralUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
        if (GeneralUtils.isNullOrBlank(description)) {
            throw new IllegalArgumentException("Descriotion cannot be null or blank");
        }
        this.description = description;
        if (availableItems < 0) {
            throw new IllegalArgumentException("Available items cannot be less than zero");
        }
        this.availableItems = availableItems;

    }

    /**
     * Get the id of the product name
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Set the id of the product name
     *
     * @param id The id of the product name
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the name of the product name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product name that cannot be null or blank
     *
     * @param name The name of product name
     */
    public void setName(String name) {
        if (GeneralUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }
        this.name = name;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        if (availableItems < 0) {
            throw new IllegalArgumentException("Available items cannot be less than zero");
        }
        this.availableItems = availableItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (GeneralUtils.isNullOrBlank(description)) {
            throw new IllegalArgumentException("Descroption cannot be null or blank");
        }
        this.description = description;
    }

        
}
