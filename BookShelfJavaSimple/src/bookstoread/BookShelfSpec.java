package bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookShelfSpec {

    private BookShelf shelf;

    private Book cleanCode;
    private Book effectiveJava;
    private Book codeComplete;

    @BeforeEach
    void init() {
        shelf = new BookShelf();

        cleanCode = new Book("Clean Code", "Robert C. Martin", LocalDate.of(2008, Month.AUGUST, 1));
        effectiveJava = new Book("Effective Java", "Joshua Bloch", LocalDate.of(2007, Month.MAY, 8));
        codeComplete = new Book("Code Complete", "Steve McConnell", LocalDate.of(2004, Month.JUNE, 9));

        shelf.add(cleanCode, effectiveJava, codeComplete);
    }

    @Test
    @DisplayName("Les livres sont triés par date de publication")
    void booksAreArrangedByPublicationDate() {
        List<Book> books = shelf.arrange(
            (book1, book2) -> book1.getPublishedOn().compareTo(book2.getPublishedOn())
        );

        assertEquals(codeComplete, books.get(0));
        assertEquals(effectiveJava, books.get(1));
        assertEquals(cleanCode, books.get(2));
    }
}
