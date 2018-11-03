package com.mindtree.assignment.dao;

import java.util.List;

import com.mindtree.assignment.model.User;

public interface UserDao {
   void save(User user);
   List<User> list();
}
