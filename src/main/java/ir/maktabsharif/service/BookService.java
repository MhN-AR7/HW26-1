package ir.maktabsharif.service;

import ir.maktabsharif.exception.CountLimitException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepo;

import java.math.BigDecimal;
import java.util.List;

public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public List<Book> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public void register(String title, String author, String category, BigDecimal price, int maxBooks) throws CountLimitException {
        if (maxBooks <= repo.findAll().size()) throw new CountLimitException("Book List is Full!(" + maxBooks + ")");

        repo.addBook(new Book(title, author, category, price));
    }
}
