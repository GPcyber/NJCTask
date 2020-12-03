package com.NJC.Task.Service;

import com.NJC.Task.Model.Book;
import com.NJC.Task.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
//Serice class for the functions in the controller to work properly
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    //To get the book by the ID
    public Book getBookById(Integer bookid) {
        Optional<Book> book = bookRepository.findById(bookid);
        if (book.isPresent()) {
            return book.get();
        }
        return new Book();
    }
    //To update the book data of a given ID
    public void updateBook(Book bookData, Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setBookName(bookData.getBookName());
            book.setAuthor(bookData.getAuthor());
            book.setPublisher(bookData.getPublisher());
            book.setPrice(bookData.getPrice());
            bookRepository.save(book);
        }
    }
    //To add the particular book
    public void addBook(Book book) {
        bookRepository.save(book);
    }

}
