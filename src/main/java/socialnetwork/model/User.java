package socialnetwork.model;

public class User {
    private String username;
    private String role;

    // Конструкторы, геттеры и сеттеры
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}