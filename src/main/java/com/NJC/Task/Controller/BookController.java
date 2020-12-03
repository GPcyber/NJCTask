package com.NJC.Task.Controller;

import com.NJC.Task.Model.Book;
import com.NJC.Task.Repository.BookRepository;
import com.NJC.Task.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @GetMapping("/book/{bookID}")
    public Book getBook(@PathVariable("bookID") Integer bookid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Book entity = bookService.getBookById(bookid);
        return entity;
    }

    @DeleteMapping("/book/{bookID}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookID") Integer bookid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        bookRepository.deleteById(bookid);
        return new ResponseEntity<String>(
                "Book Deleted Successfully", headers, HttpStatus.OK);
    }

    @PutMapping("/book/{bookID}")
    public ResponseEntity<String> updateBook(@PathVariable("bookID") Integer id, @RequestBody Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        bookService.updateBook(book, id);
        return new ResponseEntity<String>(
                "Catalogue Updated Successfully", headers, HttpStatus.OK);
    }

    @PostMapping("/addbook")
    //When using postman please use [ {object} ]
    public ResponseEntity<String> createBook(@RequestBody List<Book> book) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        book.forEach(b1 -> {
            bookService.addBook(b1);
        });
        return new ResponseEntity<String>(
                "New Book Added Successfully", headers, HttpStatus.OK);
    }

    @GetMapping("/allbooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        List<Book> bookList = bookRepository.findAll();
        return new ResponseEntity<List<Book>>(
                bookList, headers, HttpStatus.OK);
    }

 }

