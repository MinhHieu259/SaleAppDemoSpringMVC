/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minhhieu.repository;

import com.minhhieu.pojos.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UserRepository {
    User getUserById(int userId);
    boolean addUser(User user);
    List<User> getUsers(String username);
}
