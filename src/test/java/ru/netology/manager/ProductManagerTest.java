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

    Book first = new Book(1, "Война и мир", 540, "Толстой");
    Book second = new Book(2, "Братья Карамазовы", 480, "Достоевский");
    Book third = new Book(3, "Мцыри", 130, "Лермонтов");
    Book fourth = new Book(2, "Бесы", 256, "Достоевский");
    Book fifth = new Book(2, "Преступление и наказание", 615, "Достоевский");
    Smartphone sixth = new Smartphone(4, "Galaxy M12", 14000, "Samsung");
    Smartphone seventh = new Smartphone(4, "Galaxy A22", 21000, "Samsung");
    Smartphone eighth = new Smartphone(5, "iPhone 13", 70000, "Apple");

    @Test
    void shouldSearchBy() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Мцыри");
                assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByAu() {
        Product[] returned = {first,second,third,fourth,fifth,sixth,seventh,eighth};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{second, fourth, fifth};
        Product[] actual = manager.searchBy("Достоевский");
        assertArrayEquals(expected, actual);

    }
}