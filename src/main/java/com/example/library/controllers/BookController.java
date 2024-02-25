package com.example.library.controllers;

import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public boolean createBook(@RequestBody Map<String, String> map) {
        System.out.println(map);
        String author = map.get("author");
        String year = map.get("year");
        String name = map.get("name");
        bookService.addBookToList(author, year, name);
        return true;
    }

    @PostMapping("/book/{id}")
    public boolean changeBookInfo(@PathVariable int id,@RequestBody Map<String,String> map){
        String author = map.get("author");
        String year = map.get("year");
        String name = map.get("name");
        bookService.changeBookInfo(id,author,year,name);
        return true;
    }

    @GetMapping("/book")
    public List<BookForConclusion> showLibrary(){
        return bookService.bookForConclusionsList();
    }


    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable int id) {
        return bookService.deleteBookFromList(id);
    }

    @GetMapping("/book/{id}")
    public BookForConclusion showBookById(@PathVariable int id){
       return bookService.getBookByIdForConclusion(id);
    }
}
