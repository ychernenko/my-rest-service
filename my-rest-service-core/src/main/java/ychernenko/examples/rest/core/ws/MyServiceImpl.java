package ychernenko.examples.rest.core.ws;

import static java.util.stream.Collectors.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import ychernenko.examples.rest.api.*;
import ychernenko.examples.rest.api.MyService;
import ychernenko.examples.rest.core.db.AuthorsRepository;
import ychernenko.examples.rest.core.db.BooksRepository;
import ychernenko.examples.rest.core.db.enities.AuthorEntity;
import ychernenko.examples.rest.core.db.enities.BookEntity;
import ychernenko.examples.rest.core.ws.transform.AuthorFromEntityTransformer;
import ychernenko.examples.rest.core.ws.transform.BookFromEntityTransformer;
import ychernenko.examples.rest.core.ws.transform.BookToEntityTransformer;

@Component
public class MyServiceImpl implements MyService {

    @Inject private BooksRepository booksRepo;
    @Inject private AuthorsRepository authorsRepo;
    @Inject private BookFromEntityTransformer bookFromEntityTransformer;
    @Inject private AuthorFromEntityTransformer authorFromEntityTransformer;
    @Inject private BookToEntityTransformer bookToEntityTransformer;

    @Override
    public Books getBooksByTitle(String title) {
        return asBooks(booksRepo.findByTitle(title));
    }

    @Override
    public Books getBooksByAuthorName(String author) {
        return asBooks(booksRepo.findByAuthors_Name(author));
    }

    @Override
    public Response putBook(Book book) {
        booksRepo.save(bookToEntityTransformer.apply(book));
        return Response.accepted().build();
    }

    @Override
    public Authors getAuthorByName(String name) {
        return asAuthors(authorsRepo.findByName(name));
    }

    @Override
    public Authors getAuthorByBookTitle(String book) {
        return asAuthors(authorsRepo.findByBooks_Title(book));
    }

    private Authors asAuthors(Collection<AuthorEntity> entities) {
        return new Authors(entities.stream().map(authorFromEntityTransformer).collect(toList()));
    }

    private Books asBooks(Collection<BookEntity> entities) {
        return new Books(entities.stream().map(bookFromEntityTransformer).collect(toList()));
    }
}
