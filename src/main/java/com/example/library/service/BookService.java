package com.example.library.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    private List<Book> library = new ArrayList<>();
    private List<BookForConclusion> libraryForConclusion = new ArrayList<>();


    public List<Book> getLibrary() {
        return library;
    }

    public void setLibrary(List<Book> library) {
        this.library = library;
    }

    public boolean addBookToList(String author, String year, String name) {
        Book b1 = new Book(author, year, name);
        library.add(b1);

        return true;
    }


    public boolean changeBookInfo(int id, String author, String year, String name) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getId() == id) {
                library.get(i).setAuthor(author);
                library.get(i).setYear(year);
                library.get(i).setName(name);
                return true;
            }
        }
        return false;
    }

    public List<Book> booksList() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).isActive()) {
                books.add(library.get(i));
            }
        }
        return books;
    }

    public List<BookForConclusion> bookForConclusionsList() {
        List<BookForConclusion> books = new ArrayList<>();
        conclusion(library, books);
        return books;
    }

    public void conclusion(List<Book> books, List<BookForConclusion> bookForConclusions) {
        for (int i = 0; i < books.size(); i++) {
            BookForConclusion conclusion = new BookForConclusion();
            conclusion.setAuthor(books.get(i).getAuthor());
            conclusion.setYear(books.get(i).getYear());
            conclusion.setName(books.get(i).getName());
            bookForConclusions.add(conclusion);
        }
    }


    public Book getBookById(int id) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getId() == id) {
                return library.get(i);
            }
        }
        return null;
    }

    public BookForConclusion getBookByIdForConclusion(int id) {
        for (int i = 0; i < libraryForConclusion.size(); i++) {
            if (libraryForConclusion.get(i).getId() == id) {
                return libraryForConclusion.get(i);
            }
        }
        return null;
    }


    public boolean deleteBookFromList(int id) {
        for (int i = 0; i < library.size(); i++) {
            for (int j = 0; j < libraryForConclusion.size(); j++) {
                if (library.get(i).getId() == id && libraryForConclusion.get(j).getId() == id) {
                    library.remove(i);
                    libraryForConclusion.remove(j);
                    return true;
                }
            }
        }
        return false;
    }


}


