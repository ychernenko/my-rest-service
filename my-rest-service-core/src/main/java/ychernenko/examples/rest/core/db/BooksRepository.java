package ychernenko.examples.rest.core.db;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import ychernenko.examples.rest.core.db.enities.BookEntity;

public interface BooksRepository extends Repository<BookEntity, String> {

    Collection<BookEntity> findByTitle(String title);
    Collection<BookEntity> findByAuthors_Name(String name);
    void save(BookEntity book);
}
