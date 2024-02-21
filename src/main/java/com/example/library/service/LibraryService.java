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
        user.addBookToList(bookForConclusion);
        book.setActive(false);

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
                user.getUserBookList().remove(book);
                user.getUserBookList().remove(bookForConclusion);
                book.setActive(true);
            }else {
                return false;
            }
        }
        return true;
    }
}
