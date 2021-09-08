package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductManagement {
    public static Scanner sc = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void readProductListToFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] productLine = line.split(",");
            String productId = productLine[0];
            String productName = productLine[1];
            Double productPrice = Double.valueOf(productLine[2]);
            Integer productQuantity = Integer.valueOf(productLine[3]);
            String productDescription = productLine[4];
            Product product = new Product(productId, productName, productPrice, productQuantity, productDescription);
           products.add(product);

        }
        br.close();
        fileReader.close();
    }

    public void writeProductListToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bw= new BufferedWriter(fileWriter);
        for (int i = 0; i < products.size(); i++) {
            bw.write(products.get(i).toString());
            if (i != products.size() - 1) {
                bw.write("\n");
            }
        }
        bw.close();
        fileWriter.close();
    }

    public int findProductPriceMax() {
        int index = -1;
        double max = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            if (products.get(i).getPrice() > max) {
                max = products.get(i).getPrice();
                index = i;
            }
        }
        return index;
    }

    public void sortByPrice() {
        products.sort(Product::compareTo);
    }

    public void removeById(String id) {
        int index = findById(id);
        products.remove(index);
    }

    public void updateById(String id, Product product) {
        int index = findById(id);
        products.set(index, product);
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public void showAll() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
        }
        int count = 0;
        for (Product product : products) {
            System.out.println(product);
            count++;
            if (count == 5) {
                count = 0;
                sc.nextLine();
            }
        }
    }

    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
