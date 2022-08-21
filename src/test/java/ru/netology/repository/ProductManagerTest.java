package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.productManager.Book;
import ru.netology.productManager.Product;
import ru.netology.productManager.Smartphone;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Ёлка", "Елена Ким", 880);
    Product item2 = new Smartphone(2, "Xiaomi Poco M3", "Китай", 15990);

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
    }

    @Test
    public void shouldShowAllItems() {

        Product[] expected = {item1, item2};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    // @Test
    //  public void shouldShowItem1() {

    //     manager.searchBy("Ёлка");

    //      Product[] expected = {item1};
    //     Product[] actual = manager.getItems();

    //      Assertions.assertArrayEquals(expected, actual);
    //   }
}
