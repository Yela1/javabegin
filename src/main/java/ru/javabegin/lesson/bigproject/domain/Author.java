package ru.javabegin.lesson.bigproject.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String fio;

    private Date birthday;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Book> books;

    @Override
    public String toString() {
        return fio;
    }

    public Author(Long id, String fio, Date birthday){
        this.id = id;
        this.fio = fio;
        this.birthday = birthday;
    }
    public Author(){}


}
