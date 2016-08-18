package ychernenko.examples.rest.core.db.enities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Authors")
public class AuthorEntity {

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "AuthorBook",
            joinColumns = @JoinColumn(name="authorId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="bookIsbn", referencedColumnName = "isbn")
    )
    private List<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(String name, Date birth, List<BookEntity> books) {
        this.name = name;
        this.birth = birth;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
