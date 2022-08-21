package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productManager.Book;
import ru.netology.productManager.Product;
import ru.netology.productManager.Smartphone;

public class ProductRepositoryTest {

    Product item1 = new Book(1, "Ёлка", "Елена Ким", 880);
    Product item2 = new Smartphone(2, "Xiaomi Poco M3", "Китай", 15990);

    @Test
    public void shouldSaveProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveItem1() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.removeById(item1.getId());

        Product[] expected = {item2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


}

