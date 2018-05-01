package pl.coderslab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping
    public List<Book> getAllBooks() throws JsonProcessingException {
        return memoryBookService.getList();
    }

    @PostMapping
    public List<Book> postNewBook(@RequestParam("id") long id, @RequestParam("isbn") String isbn,
                                  @RequestParam("title") String title, @RequestParam("author") String author,
                                  @RequestParam("publisher") String publisher, @RequestParam("type") String type) {
        memoryBookService.addNewBook(id,isbn,title,author,publisher,type);
        List<Book> list = memoryBookService.getList();
        return list;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return memoryBookService.selectBookById(id);
    }

    @PutMapping("/{id}")
    public List<Book> editBook(@RequestParam("id") long id, @RequestParam("isbn") String isbn,
                               @RequestParam("title") String title, @RequestParam("author") String author,
                               @RequestParam("publisher") String publisher, @RequestParam("type") String type) {
        memoryBookService.editBook(id,isbn,title,author,publisher,type);
        return memoryBookService.getList();
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(long id) {
        memoryBookService.deleteBook(id);
        return memoryBookService.getList();
    }

}