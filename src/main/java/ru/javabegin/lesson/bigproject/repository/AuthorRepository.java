package ru.javabegin.lesson.bigproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.javabegin.lesson.bigproject.domain.Author;
import ru.javabegin.lesson.bigproject.dto.AuthorDTO;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFioContainingIgnoreCaseOrderByFio(String fio);

    Page<Author> findByFioContainingIgnoreCaseOrderByFio(String fio, Pageable pageable);


    @Query("select new ru.javabegin.lesson.bigproject.domain.Author(a.id, a.fio, a.birthday) from Author a")
    Page<Author> findAllWithoutContent(Pageable pageable);
    //Page<Author> findAllWithoutContent(Pageable pageable);

}
