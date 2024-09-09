package com.library.repository;

import com.library.annotations.FileDesc;
import com.library.entity.Book;
import com.library.entity.UserBook;

import java.io.*;
import java.util.List;
public class BookRepository implements Repository <Book, Integer> {

    private String filename;

    public BookRepository() {
        Class<Book> BookClass = Book.class;
        if (BookClass.isAnnotationPresent(FileDesc.class)) {
            BookClass.getAnnotation(FileDesc.class);
            FileDesc annotation = BookClass.getAnnotation(FileDesc.class);
            this.filename = annotation.filename();
        }


    }

    @Override
    public List<Book> findAll() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        return null;
    }
    @Override
    public void save(Book UserBook) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(UserBook.toString());
        }
    }

        public static void main (String[]args) throws IOException {
            BookRepository repository = new BookRepository();
            Book Book = new Book(1,"a",1);
            repository.save(Book);
        }
    }

