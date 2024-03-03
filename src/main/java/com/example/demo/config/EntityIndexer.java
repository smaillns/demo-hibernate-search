package com.example.demo.config;

import com.example.demo.model.Book;
import jakarta.persistence.EntityManager;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EntityIndexer  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private final EntityManager entityManager;

    public EntityIndexer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    @Async
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SearchSession searchSession = Search.session(entityManager);

        MassIndexer indexer = searchSession.massIndexer(Book.class).threadsToLoadObjects(7);
        try {
            indexer.startAndWait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

