package ychernenko.examples.rest.it.ws;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.BadRequestException;

import org.junit.Test;

import ychernenko.examples.rest.api.Book;
import ychernenko.examples.rest.api.Books;

public class IntegrationTest extends AbstractIntegrationTest {

    @Test
    public void tests_books_without_parameters() {
        Book expected = new Book(1, "test", 2016, null);
        getService().putBook(expected);
        Books books = getService().getBooksByTitle("test");
        assertEquals(1, books.getBook().size());
        assertEquals(expected.getIsbn(), books.getBook().get(0).getIsbn());
    }

}