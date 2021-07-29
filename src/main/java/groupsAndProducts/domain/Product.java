package groupsAndProducts.domain;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String productName;
    private long groupId;
    private BigDecimal price;

    public Product(long id, String productName, long groupId, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.groupId = groupId;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
