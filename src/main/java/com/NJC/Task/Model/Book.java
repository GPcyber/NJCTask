package com.NJC.Task.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bookid")
    int id;

    @Column(name = "Bookname")
    String bookName;

    @Column(name = "Publisher")
    String publisher;

    @Column(name = "Author")
    String author;

    @Column(name = "Price")
    Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Book() {
    }

    public Book(int id, String bookName, String publisher, String author, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

}

