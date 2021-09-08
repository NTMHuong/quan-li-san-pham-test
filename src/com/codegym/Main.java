package com.codegym;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ProductManagement productManagement = new ProductManagement();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.println("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    displayProduct();
                    break;
                }
                case 2: {
                    addNewProduct();
                    break;
                }
                case 3: {
                    updateProduct();
                    break;
                }
                case 4: {
                    removeProduct();
                    break;
                }
                case 5: {
                    sortProduct();
                    break;
                }
                case 6: {
                    findProductPriceMax();
                    break;
                }
                case 7: {
                    readFile();
                    break;
                }
                case 8: {
                    writeFile();
                    break;
                }
                case 0: {
                    System.out.println("GoodBye!");
                    break;
                }
                default: {
                    System.out.println("Nhập sai rồi! Chạy lại nhé");
                    break;
                }
            }
        }
        while (choice != 0);
    }
    private static void writeFile() {
        try {
            productManagement.writeProductListToFile("data/products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try {
            productManagement.readProductListToFile("data/products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findProductPriceMax() {
        System.out.println("-----------------------------------------");
        int index = productManagement.findProductPriceMax();
        System.out.println("Sản phẩm đắt nhất trong danh sách:");
        System.out.println(productManagement.getProducts().get(index));
    }

    private static void sortProduct() {
        int choose;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Chọn các chức năng sau: ");
            System.out.println("1. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("2. Hiển thị danh sách sản phẩm khi đã sắp xếp xong");
            System.out.println("3. Thoát");
            choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    System.out.println("-----------------------------------------");
                    productManagement.sortByPrice();
                    break;
                }
                case 2: {
                    System.out.println("-----------------------------------------");
                    System.out.println("Danh sách sau khi sắp xếp theo giá sản phẩm tăng dần");
                    productManagement.showAll();
                    break;
                }
                case 3: {
                    break;
                }
            }

        } while (choose != 3);
    }

    private static void removeProduct() {
        System.out.println("-----------------------------------------");
        System.out.println("Nhập mã sản phẩm cần xóa: ");
        String id = sc.nextLine();
        int index = productManagement.findById(id);
        if (index != -1) {
            System.out.println(productManagement.getProducts().get(index));
            System.out.println("Bạn có muốn xóa sản phẩm này không?");
            System.out.println("Nhập Y để xóa, nhập kí tự bất kỳ để thoát");
            String input = sc.nextLine();
            if (input.equals("Y")) {
                productManagement.removeById(id);
            }
            return;
        } else {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
            removeProduct();
        }
    }


    private static void updateProduct() {
        System.out.println("-----------------------------------------");
        System.out.println("Nhập mã số cần sửa: ");
        String id = sc.nextLine();
        int index = productManagement.findById(id);
        if (index != -1) {
            Product product = inputProductFromKeyBoard();
            productManagement.updateById(id, product);
        } else {
            System.out.println("Không tìm được sản phẩm với ãm sản phẩm trên");
            System.out.println("Vui lòng nhập lại: ");
            updateProduct();
            if (id.equals("")) {
                return;
            }
        }

    }

    private static void displayProduct() {
        productManagement.showAll();
    }

    private static void addNewProduct() {
        int n;
        System.out.println("Nhập số sản phẩm bạn muốn thêm: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Product product = inputProductFromKeyBoard();
            productManagement.addNewProduct(product);
        }
    }

    private static Product inputProductFromKeyBoard() {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        System.out.println("-------------------------");
        System.out.println("Nhập mã sản phẩm:");
        while (!product.setId(sc.nextLine())) ;

        System.out.println("Nhập tên sản phẩm:");
        while (!product.setName(sc.nextLine())) ;

        System.out.println("Nhập giá:");
        while (!product.setPrice(sc.nextDouble())) ;

        System.out.println("Nhập số lượng: ");
        while (!product.setQuantity(sc.nextInt())) ;

        System.out.println("Nhập mô tả: ");
        while (!product.setDescription(sc.nextLine())) ;

        return product;
    }

    private static void menu() {
        System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--------");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhât");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi từ file");
        System.out.println("0. Thoát");
    }
}
