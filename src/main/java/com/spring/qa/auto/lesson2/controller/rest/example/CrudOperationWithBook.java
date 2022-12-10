package com.spring.qa.auto.lesson2.controller.rest.example;

import org.springframework.web.bind.annotation.*;
import com.spring.qa.auto.lesson2.controller.rest.example.dto.Book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class CrudOperationWithBook {
Map<Integer, Book> data = new HashMap<>();

@PostConstruct
    void init() {
            data.put(1, new Book(1, "Унесенные ветром","Маргарет Митчелл", 1936));
            data.put(2, new Book(2, "Спектр","Сергей Лукьяненко", 2002));
            data.put(3, new Book(3, "Ведьмак","Анджей Сапковский", 1986));
            }

@GetMapping("/{id}")
public Book get(@PathVariable int id) {
        return data.get(id);
        }

@GetMapping("/all")
public List<Book> get() {
        return new ArrayList<>(data.values());
        }

@PostMapping()
public void save(@RequestBody Book book) {
        int id = data.size() + 1;
        book.setId(id);
        data.put(id, book);
        }

@PutMapping("/{id}")
public void change(@PathVariable int id, @RequestBody Book bookChanging) {
        Book book = data.get(id);
        book.setPublicationDate(bookChanging.getPublicationDate());
        book.setNameBook(bookChanging.getNameBook());
        book.setAuthor(bookChanging.getAuthor());
        data.put(id, book);
        }

@DeleteMapping("/{id}")
public void delete(@PathVariable int id) {
        data.remove(id);
        }
}
