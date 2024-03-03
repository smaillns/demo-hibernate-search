package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryExt {



//    @Query("SELECT b FROM Book b WHERE lower(b.title) like (concat('%', :query, '%'))")
//    List<Book> findBooksByQuery(@Param("query") String query);


}
