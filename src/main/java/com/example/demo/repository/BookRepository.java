package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryExt {



//    @Query("SELECT b FROM Book b WHERE lower(b.title) like (concat('%', :query, '%'))")
//    List<Book> findBooksByQuery(@Param("query") String query);


}
