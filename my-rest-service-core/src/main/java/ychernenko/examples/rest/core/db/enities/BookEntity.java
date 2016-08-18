package ychernenko.examples.rest.core.db.enities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Books")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name= "isbn")
    private Long isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "pubYear")
    private Integer year;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthorEntity> authors;

    public BookEntity() {
    }

    public BookEntity(Long isbn, String title, Integer year, List<AuthorEntity> authors) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }
}
