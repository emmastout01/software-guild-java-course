/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.library.controllers;

import corbos.library.models.Book;
import corbos.library.service.BookService;
import corbos.library.service.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emmastout
 */
@RestController
public class BookController {
    //Spring wants our classes to be as clean and simple as possible. 
    //Would rather we had a pojo that is annotated in particular ways

    //Rest controller needs a book service
    @Autowired
    private BookService bookService;

    //Spring will scan to see if anything will return data
    //Only if we put an annotation on it: If I get something from /api/books it will figure things out for me
    //This mapping is called a route
    //The 'api' here is just a prefix we're using.
    @GetMapping("api/books")
    public List<Book> getallBooks() {
        return bookService.all().getPayload();
    }

    @PostMapping("api/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        //Spring will take json objects and turn them into Java objects. Like magic!
        Result<Book> result = bookService.save(book);
        if (result.isSuccess()) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //{} means that these are the route parameters, it will be coming in on the path
    @PutMapping("api/book/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable int bookId, @RequestBody Book book) {
        if(book.getId() <= 0 || bookId <= 0 || bookId != book.getId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Result<Book> result = bookService.save(book);
        if(result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("api/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
        Result result = bookService.deleteById(bookId);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
