package pl.coderslab.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MemoryBookService  implements BookService{
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public MemoryBookService(List<Book> list) {
        this.list = list;
    }

    public List<Book> getList() {
        return list;
    }
    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public void addNewBook(long id, String isbn, String title, String author, String publisher, String type) {
        list.add(new Book(id, isbn, title, author, publisher, type));
    }

    @Override
    public Book selectBookById(long id) {
        Book book = null;
        for (Book b: list) {
            if(id == b.getId()){
                book = list.get((int) id);
            }
        }
        return book;
    }

    @Override
    public void editBook(long id, String isbn, String title, String author, String publisher, String type) {
        Book book = selectBookById(id);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setType(type);
    }

    @Override
    public void deleteBook(long id) {
        for (Book b: list) {
            if(id == b.getId()){
                list.remove(b);
            }
        }
    }
}


