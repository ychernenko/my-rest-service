package ychernenko.examples.rest.core.ws.transform;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ychernenko.examples.rest.api.Book;
import ychernenko.examples.rest.core.db.enities.AuthorEntity;
import ychernenko.examples.rest.core.db.enities.BookEntity;

@Component
public class BookToEntityTransformer implements Function<Book, BookEntity> {

    @Inject private AuthorToEntityTransformer authorTransformer;

    @Override
    public BookEntity apply(Book book) {
        List<AuthorEntity> authors = authorTransformer == null
                || book.getAuthors() == null
                || book.getAuthors().getAuthor() == null
                ? null
                : book.getAuthors().getAuthor().stream().map(authorTransformer).collect(toList());
        return new BookEntity(
                book.getIsbn(),
                book.getTitle(),
                book.getYear(),
                authors
        );
    }
}
