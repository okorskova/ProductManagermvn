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
    Product item3 = new Smartphone(3, "Xiaomi redmi note 11", "Китай", 19900);

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }

    @Test
    public void shouldShowAllItems() {

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindItem1() {

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Ёлка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindItem2() {

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Xiaomi Poco M3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNull() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("кот");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindFewItems() {

        Product[] expected = {item2, item3};
        Product[] actual = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(expected, actual);
    }
}
