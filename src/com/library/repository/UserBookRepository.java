package com.library.repository;

import com.library.annotations.FileDesc;
import com.library.entity.UserBook;

import java.io.*;
import java.util.List;

public class UserBookRepository implements Repository <UserBook, Integer>{

      private  String filename;
      public UserBookRepository(){
          Class <UserBook> UserBookClass=UserBook.class;
          if(UserBookClass.isAnnotationPresent(FileDesc.class)){
              UserBookClass.getAnnotation(FileDesc.class);
              FileDesc annotation =UserBookClass.getAnnotation(FileDesc.class);
              this.filename= annotation.filename();
          }

      }

    @Override
    public List<UserBook> findAll() throws IOException {
          try (BufferedReader br = new BufferedReader( new FileReader(filename))){
              String line;
              while ((line= br.readLine())!=null){
                  System.out.println(line);
              }

          }
        return null;
    }

    @Override
    public void save(UserBook UserBook) throws IOException {
     try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true))){
         bw.write (UserBook.toString());
     }
    }
    public static void main (String []args) throws IOException {
          UserBookRepository repository = new UserBookRepository();
          UserBook userBook = new UserBook(1,1,1);
          repository.save(userBook);
    }
}
