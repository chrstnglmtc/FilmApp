package com.filmlist.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmlist.film.dao.UserDao;
import com.filmlist.film.model.User;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())){
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    public void logout() {
        session.invalidate();
    }

    public User getLoggedInUser() {
        return (User) session.getAttribute("user");
    }
}
