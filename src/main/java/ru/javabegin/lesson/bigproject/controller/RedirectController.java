package ru.javabegin.lesson.bigproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.lesson.bigproject.dao.implementation.AuthorService;
import ru.javabegin.lesson.bigproject.domain.Author;
import ru.javabegin.lesson.bigproject.repository.AuthorRepository;
import ru.javabegin.lesson.bigproject.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Page<Author> baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {

        //List<Author> authorList = authorRepository.findAll();
        //Page<Book> bookList = bookRepository.findByGenre(15, PageRequest.of(0, 10, JpaSort.unsafe(Sort.Direction.ASC, "data->>'name'")));

        Page<Author> authors = authorService.getAllWithoutBooks(0, 10, "fio", Sort.Direction.DESC);

        Author a = new Author();
        a.setFio("тестовый автор");
        a.setBirthday(new Date(1454284800000L));


        Author newAuthor = authorService.save(a);
        return authors;



        //List<Author> authors = authorRepository.findByFioContainingIgnoreCaseOrderByFio("Пауло Коэльо");





        //List<AuthorDTO> authorList = authorRepository.findAllWithoutContent();
      //  return authorList;
    }


}
