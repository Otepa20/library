package com.library.repository;

import com.library.annotations.FileDesc;
import com.library.entity.User;

import java.io.*;
import java.util.List;

public class UserRepository implements Repository<User, Integer> {


    private String filename;

    public UserRepository() {
        Class<User> UserClass = User.class;
        if (UserClass.isAnnotationPresent(FileDesc.class)) {
            FileDesc annotation = UserClass.getAnnotation(FileDesc.class);
            this.filename = annotation.filename();
        }
    }

    @Override
    public List<User> findAll() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        return null;
    }

    @Override
    public void save(User User) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(User.toString());
        }

    }

    public static void main(String[] args) throws IOException {
        UserRepository repository = new UserRepository();
        User User = new User(1, 1, 1);
        repository.save(User);
    }

}
