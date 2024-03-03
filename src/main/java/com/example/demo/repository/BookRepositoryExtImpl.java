package com.example.demo.repository;

import com.example.demo.model.Book;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;

import java.util.List;

@RequiredArgsConstructor
public class BookRepositoryExtImpl implements BookRepositoryExt{

    private final EntityManager entityManager;

    @Override
    public List<Book> findBooksByQuery(String query) {
        SearchSession searchSession = Search.session( entityManager );

        SearchResult<Book> result = searchSession.search( Book.class )
                .where( f -> f.match()
                        .fields( "title" )
                        .matching( query )
                        .fuzzy())
                .fetch( 20 );
        List<Book> hits = result.hits();
        return hits;
    }
}
