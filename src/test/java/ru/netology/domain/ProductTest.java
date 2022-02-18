package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product first = new Book(1, "Война и мир", 540, "Толстой");
    Product second = new Book(2, "Братья Карамазовы", 480, "Достоевский");
    Product third = new Book(3, "Мцыри", 130, "Лермонтов");
    Product fourth = new Book(4, "Бесы", 256, "Достоевский");
    Product fifth = new Book(5, "Преступление и наказание", 615, "Достоевский");
    Product sixth = new Smartphone(6, "Galaxy M12", 14000, "Samsung");
    Product seventh = new Smartphone(7, "Galaxy A22", 21000, "Samsung");
    Product eighth = new Smartphone(8, "iPhone 13", 70000, "Apple");
    Product ninth = new Product(9, "Teddy bear", 1700);

    @ParameterizedTest
    @CsvFileSource(resources = "/dataProduct.csv")
    void shouldByNameAtMatches(String search, boolean expected) {
        Product[] repo = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};

        boolean actual = first.matches(search);
//        boolean expected = true;
        assertEquals(expected, actual);
    }
}

