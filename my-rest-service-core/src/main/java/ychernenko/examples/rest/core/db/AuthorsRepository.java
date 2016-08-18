package ychernenko.examples.rest.core.db;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import ychernenko.examples.rest.core.db.enities.AuthorEntity;

public interface AuthorsRepository extends Repository<AuthorEntity, String> {

    Collection<AuthorEntity> findByName(String name);
    Collection<AuthorEntity> findByBooks_Title(String title);
}
