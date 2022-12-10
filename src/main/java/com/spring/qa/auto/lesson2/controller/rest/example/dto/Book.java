package com.spring.qa.auto.lesson2.controller.rest.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String nameBook;
    private String author;
    private int publicationDate;
}
