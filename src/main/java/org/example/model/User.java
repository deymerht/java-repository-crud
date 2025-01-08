package org.example.model;

import java.time.LocalDateTime;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String lastConnection;
    private String country;
    private String website;
    private String username;
    private Integer followers;
    private Integer following;

    public User() {
    }

    public User(String id, String firstName, String lastName, String email, String lastConnection, String country, String website, String username, Integer followers, Integer following) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lastConnection = lastConnection;
        this.country = country;
        this.website = website;
        this.username = username;
        this.followers = followers;
        this.following = following;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User Details:" +
                "\nID: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nLast Connection: " + lastConnection +
                "\nCountry: " + country +
                "\nWebsite: " + website +
                "\nUsername: " + username +
                "\nFollowers: " + followers +
                "\nFollowing: " + following +
                "\n---------------------------";
    }

}
