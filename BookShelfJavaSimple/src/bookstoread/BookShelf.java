package bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    private final List<Book> books = new ArrayList<>();

    public void add(Book... booksToAdd) {
        books.addAll(Arrays.asList(booksToAdd));
    }

    public List<Book> arrange() {
        return arrange(Comparator.naturalOrder());
    }

    public List<Book> arrange(Comparator<Book> criteria) {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }
}
