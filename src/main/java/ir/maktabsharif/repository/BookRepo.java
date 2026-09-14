package ir.maktabsharif.repository;

import ir.maktabsharif.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    private final List<Book> books;

    public BookRepo() {
        this.books = new ArrayList<>();

        books.add(new Book(
                1L, "Java Core", "Ali Najafi", "Programming", new BigDecimal("19.99")
        ));
        books.add(new Book(
                2L, "Spring", "Ali Noori", "Programming", new BigDecimal("34.99")
        ));
        books.add(new Book(
                3L, "The Hobbit", "J.R.R. Tolkien", "Fantasy", new BigDecimal("14.99")
        ));
        books.add(new Book(
                4L, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", new BigDecimal("9.99")
        ));
        books.add(new Book(
                5L, "Dune", "Frank Herbert", "Fantasy", new BigDecimal("13.99")
        ));
    }

    public List<Book> findAll() {
        return books;
    }

    public List<Book> findByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public void addBook(Book book) {
        Long id = (long) (books.size() + 1);

        books.add(new Book(id, book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice()));
    }
}
