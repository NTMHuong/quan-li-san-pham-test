package com.codegym;

public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(String id, String name, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if(!id.equals("")) {
            this.id = id;
            return true;
        } else {
            System.err.println("Nhập lại mã sản phẩm: ");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(!name.equals("")) {
            this.name = name;
            return true;
        } else {
            System.err.println("Nhập lại tên sản phẩm: ");
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if(price >= 0) {
            this.price = price;
            return true;
        } else {
            System.err.println("Nhập lại giá của sản phẩm: ");
            return false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean setQuantity(int quantity) {
        if(quantity >= 0 ) {
            this.quantity = quantity;
            return true;
        } else {
            System.err.println("Nhập lại số lượng sản phẩm: ");
            return false;
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if(!description.equals("")) {
            this.description = description;
            return true;
        } else {
            System.err.println("Nhập lại mô tả sản phẩm: ");
            return false;
        }

    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(this.price, product.getPrice());
    }
}
