package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ProductManagerTest {

    @Mock
    private ProductRepository repository = Mockito.mock(ProductRepository.class);
    @InjectMocks
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Война и мир", 540, "Толстой");
    Product second = new Book(2, "Братья Карамазовы", 480, "Достоевский");
    Product third = new Book(3, "Мцыри", 130, "Лермонтов");
    Product fourth = new Book(4, "Бесы", 256, "Достоевский");
    Product fifth = new Book(5, "Преступление и наказание", 615, "Достоевский");
    Product sixth = new Smartphone(6, "Galaxy M12", 14000, "Samsung");
    Product seventh = new Smartphone(7, "Galaxy A22", 21000, "Samsung");
    Product eighth = new Smartphone(8, "iPhone 13", 70000, "Apple");
    Product ninth = new Product(9, "Teddy bear", 1700);

    @Test
    void shouldSearchByNameOfBook() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Мцыри");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameOfSmartphone() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Galaxy M12");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Достоевский");
        Product[] expected = new Product[]{second, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByFirm() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameNegativeForBook() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Евгений Онегин");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameNegativeForSmartphone() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameNegativeForOther() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth, ninth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Teddy bear");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}