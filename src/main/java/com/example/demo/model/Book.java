package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Indexed
public class Book {

    @Id
    private Integer id;


    @FullTextField(analyzer = "nameAnalyzer")
    private String title;

    private String author;
}
