package ychernenko.examples.rest.core.ws.transform;

import static java.util.stream.Collectors.*;

import java.util.function.Function;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ychernenko.examples.rest.api.Authors;
import ychernenko.examples.rest.api.Book;
import ychernenko.examples.rest.core.db.enities.BookEntity;

@Component
public class BookFromEntityTransformer implements Function<BookEntity, Book> {

    @Inject private AuthorFromEntityTransformer authorTransformer;

    @Override
    public Book apply(BookEntity bookEntity) {
        Authors authors = authorTransformer == null || bookEntity.getAuthors() == null
                ? null
                : new Authors(bookEntity.getAuthors().stream().map(authorTransformer).collect(toList()));
        return new Book(
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getYear(),
                authors
        );
    }
}
