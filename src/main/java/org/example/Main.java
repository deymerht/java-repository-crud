package org.example;

import org.example.model.User;
import org.example.repository.IRepository;
import org.example.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        String id = "f42ddd26-b675-45ca-8261-2b90c02c56ec";
        String idToDelete = "677e969b-e0b4-800b-9571-e1fdefaf661f";
        User newUser = new User();
        newUser.setId("677e969b-e0b4-800b-9571-e1fdefaf661f");
        newUser.setFirstName("Deymer");
        newUser.setLastName("Hernadnez");
        newUser.setEmail("deymerh@deymerh.com");
        newUser.setLastConnection("2024-01-12");
        newUser.setCountry("COL");
        newUser.setWebsite("http://deymerh.com");
        newUser.setUsername("deymerh");
        newUser.setFollowers(1000);
        newUser.setFollowing(2000);
        try {
            IRepository<User> repository = new UserRepository();
            repository.findAll().forEach(System.out::println);

//            User user = repository.getById(id);
//            System.out.println("User whit id: " + id + " " + user);

//            repository.save(newUser);
//            User user = repository.getById(newUser.getId());
//            System.out.println(user);
//            User user = repository.getById(newUser.getId());
//            System.out.println("User whit id: " + newUser.getId() + " " + user);
//            repository.delete(user.getId());
//            System.out.println(user);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
