package service;

import model.User;
import repository.UserRepository;
import util.PasswordUtil;
import util.ValidationUtil;

public class AuthService {
    private final UserRepository userRepository = new UserRepository();

    public boolean register(String username, String email, String password) {
        if (!ValidationUtil.isValidUsername(username)) return false;
        if (!ValidationUtil.isValidEmail(email)) return false;
        if (!ValidationUtil.isValidPassword(password)) return false;
        if (userRepository.findByUsername(username) != null) return false;

        User user = new User(0, username.trim(), email.trim(), PasswordUtil.hash(password));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return null;

        String hash = PasswordUtil.hash(password);
        if (user.getPasswordHash().equals(hash)) {
            return user;
        }
        return null;
    }
}