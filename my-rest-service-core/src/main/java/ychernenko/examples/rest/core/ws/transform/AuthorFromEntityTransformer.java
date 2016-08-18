package ychernenko.examples.rest.core.ws.transform;

import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ychernenko.examples.rest.api.Author;
import ychernenko.examples.rest.api.Books;
import ychernenko.examples.rest.core.db.enities.AuthorEntity;

@Component
public class AuthorFromEntityTransformer implements Function<AuthorEntity, Author> {

    @Inject private BookFromEntityTransformer bookTransformer;

    @Override
    public Author apply(AuthorEntity entity) {
        Books books = bookTransformer == null || entity.getBooks() == null
                ? null
                : new Books(entity.getBooks().stream().map(bookTransformer).collect(Collectors.toList()));
        return new Author(
                entity.getName(),
                entity.getBirth(),
                books
        );
    }
}
