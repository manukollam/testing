package com.mindtree.assignment.service;

import java.util.List;

import com.mindtree.assignment.model.User;

public interface UserService {
   void save(User user);

   List<User> list();
}
