package com.example.library.controllers;

import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class BookController {

    @Autowired
    BookService bookService;

//    @PostMapping("/book")
//    public boolean createBook(@RequestBody Map<String, String> map) {
//
//        String author = map.get("author");
//        String year = map.get("year");
//        String name = map.get("name");
//
//        if (author.isEmpty() || year.isEmpty() || name.isEmpty()){
//            return false;
//        }
//        bookService.addBookToList(author, year, name);
//        return true;
//    }
@PostMapping("/book")
    public boolean createBook(@RequestBody Map<String, String> map) throws SQLException {

        String author = map.get("author");
        String year = map.get("year");
        String nameBook = map.get("name");

        if (author.isEmpty() || year.isEmpty() || nameBook.isEmpty()){
            return false;
        }
        bookService.addBookToDataBase(author, year, nameBook);
        return true;
    }



//    @PostMapping("/book/{id}")
//    public boolean changeBookInfo(@PathVariable int id,@RequestBody Map<String,String> map){
//        String author = map.get("author");
//        String year = map.get("year");
//        String name = map.get("name");
//
//        if (author.isEmpty() || year.isEmpty() || name.isEmpty()){
//            return false;
//        }
////        if (!bookService.bookExists(id)) {
////            return false;
////        }
//        bookService.changeBookInfo(id,author,year,name);
//        return true;
//    }


    @GetMapping("/book")
    public List<Book> showLibrary() throws SQLException {
        return bookService.viewBook();
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) throws SQLException {
        Book book = bookService.findBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable int id) throws SQLException {
        boolean deleted = bookService.deleteBookById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable int id, @RequestBody Map<String, String> bookData) throws SQLException {
        String author = bookData.get("author");
        String year = bookData.get("year");
        String name = bookData.get("name");

        boolean updated = bookService.updateBook(id, author, year, name);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





//    @DeleteMapping("/book/{id}")
//    public boolean deleteBook(@PathVariable int id) {
//        return bookService.deleteBookFromList(id);
//    }
//
//    @GetMapping("/book/{id}")
//    public BookForConclusion showBookById(@PathVariable int id){
//       return bookService.getBookByIdForConclusion(id);
//    }
}
