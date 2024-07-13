package org.Masri.SimpleRest.Services;

import org.Masri.SimpleRest.Enteties.User;

import java.util.List;

public interface UserManagementService {
    String registerUser(User user);

    List<User> getUsers();

    User getUserByEmail(String userEmail);
}
