package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import com.example.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;


@Service
public class LibraryService {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;


//    public boolean userTakeBook(int userId, int bookId) {
//        User user = userService.getUserById(userId);
//        Book book = bookService.getBookById(bookId);
//        BookForConclusion bookForConclusion = bookService.getBookByIdForConclusion(bookId);
//
//        if (user == null || book == null || !book.isActive() || user.getUserBookList().size() > 2) {
//            return false;
//        }
//
//        user.addBookToList(bookForConclusion);
//        book.setActive(false);
//
//        return true;
//    }

//    public boolean returnUserBook(int userId, int bookId){
//        User user = userService.getUserById(userId);
//        Book book = bookService.getBookById(bookId);
//
//        if (user == null){
//            return false;
//        }
//
//        for(Map.Entry<LocalDate, BookForConclusion> entry: user.getUserBookList().entrySet()){
//            if(entry.getValue().getId()==bookId){
//                book.setActive(true);
//             user.getUserBookList().remove(entry.getKey());
//            }
//        }
//        return true;
//    }
}
