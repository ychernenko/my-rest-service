package ychernenko.examples.rest.core.ws.transform;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ychernenko.examples.rest.api.Author;
import ychernenko.examples.rest.core.db.enities.AuthorEntity;
import ychernenko.examples.rest.core.db.enities.BookEntity;

@Component
public class AuthorToEntityTransformer implements Function<Author, AuthorEntity> {

    @Inject private BookToEntityTransformer bookTransformer;

    @Override
    public AuthorEntity apply(Author author) {
        List<BookEntity> books = bookTransformer == null
                || author.getBooks() == null
                || author.getBooks().getBook() == null
                ? null
                : author.getBooks().getBook().stream().map(bookTransformer).collect(Collectors.toList());
        return new AuthorEntity(
                author.getName(),
                author.getBirth(),
                books
        );
    }
}
