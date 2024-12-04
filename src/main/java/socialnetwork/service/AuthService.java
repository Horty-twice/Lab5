package socialnetwork.service;

import socialnetwork.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, String> users = new HashMap<>();

    public AuthService() {
        // Пример добавления пользователей
        users.put("admin", "admin123");
        users.put("moderator", "mod123");
        users.put("visitor", "vis123");
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public User getUser(String username) {
        if (username.equals("admin")) {
            return new User(username, "ADMIN");
        } else if (username.equals("moderator")) {
            return new User(username, "MODERATOR");
        } else {
            return new User(username, "USER");
        }
    }
}