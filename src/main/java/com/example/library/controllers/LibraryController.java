package com.example.library.controllers;

import com.example.library.service.BookService;
import com.example.library.service.LibraryService;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class LibraryController {

    @Autowired
    LibraryService libraryService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @PostMapping
    private boolean userGetBook(@RequestParam Integer id, @RequestBody Map<String, Integer> map){
        int idBook= map.get("book");
        return  libraryService.userTakeBook(id,idBook);
    }

    @PutMapping
    private boolean userReturnBook( @RequestBody Map<String, Integer> map){
        int idBook = map.get("book");
        return libraryService.returnUserBook(idBook);
    }
}
