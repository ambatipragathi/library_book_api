
package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private long nextId = 1;

    // Add book
    public Book addBook(Book book) {
        book.setBookId(nextId++);
        books.add(book);
        return book;
    }

    // Search book by ID
    public Book getBookById(Long bookId) {
        return books.stream()
                .filter(book -> book.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    // Update availability
    public Book updateAvailability(Long bookId, boolean available) {
        Book book = getBookById(bookId);

        if (book != null) {
            book.setAvailable(available);
        }

        return book;
    }

    // Delete book
    public boolean deleteBook(Long bookId) {
        return books.removeIf(
                book -> book.getBookId().equals(bookId)
        );
    }
}
