package ru.netology.repository;

import ru.netology.productManager.Product;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] getItems() {
        Product[] all = repo.getItems();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getItems()) {
            if (matches(product, text)) {

            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
