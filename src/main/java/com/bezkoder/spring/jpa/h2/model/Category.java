package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
//@ToString(exclude = "tutorials")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}