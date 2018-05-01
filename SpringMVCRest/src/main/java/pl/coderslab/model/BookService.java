package pl.coderslab.model;

import java.util.List;

public interface BookService {
    public Book selectBookById(long id);
    public void addNewBook(long id, String isbn, String title, String author, String publisher, String type);
    public void editBook(long id, String isbn, String title, String author, String publisher, String type);
    public void deleteBook(long id);
    public List<Book> getList();
    public void setList(List<Book> list);
}
