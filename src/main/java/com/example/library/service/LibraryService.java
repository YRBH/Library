package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import com.example.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibraryService {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;


    public boolean userTakeBook(int userId, int bookId) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        BookForConclusion bookForConclusion = bookService.getBookByIdForConclusion(bookId);

        if (user == null || book == null || !book.isActive() || user.getUserBookList().size() > 2) {
            return false;
        }
        if (true) {
            user.addBookToList(bookForConclusion);
            bookService.getLibrary().remove(book);
        } else {
            return false;
        }
        return true;
    }

    public boolean returnUserBook(int userId, int bookId){
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        BookForConclusion bookForConclusion = bookService.getBookByIdForConclusion(bookId);

        if (user == null){
            return false;
        }

        for (int i = 0; i < user.getUserBookList().size(); i++) {
            if (user.getUserBookList().get(i).getId() == bookId){
                bookService.addBookToList(user.getUserBookList().get(i).getAuthor(),user.getUserBookList().get(i).getYear(),user.getUserBookList().get(i).getName());
                user.getUserBookList().remove(bookForConclusion);
//                book.setActive(true);
            }else {
                return false;
            }
        }
        return true;
    }
}
