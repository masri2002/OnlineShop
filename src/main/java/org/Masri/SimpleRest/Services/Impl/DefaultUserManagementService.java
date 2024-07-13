    package org.Masri.SimpleRest.Services.Impl;

    import org.Masri.SimpleRest.Enteties.User;
    import org.Masri.SimpleRest.Enteties.impl.DefaultUser;
    import org.Masri.SimpleRest.Services.UserManagementService;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.HashMap;
    import java.util.List;
    import java.util.stream.Stream;

    public class DefaultUserManagementService implements UserManagementService {
        private static DefaultUserManagementService instance;

        public DefaultUserManagementService() {
        }

        HashMap<String,User> users;
        {
            users=new HashMap<>();
        }
        @Override
        public String registerUser(User user) {
         if(users.containsKey(user.getEmail())){
             return "user email exits before";
         }else
            users.put(user.getEmail(),user);
           return "User registered successfully";
        }
        @Override
        public List<User> getUsers() {
          List<User>userList = new ArrayList<>(users.values());
            return userList;
        }

        @Override
        public User getUserByEmail(String userEmail) {
            return users.getOrDefault(userEmail, null);
        }
        public static UserManagementService getInstance() {
            if (instance == null) {
                instance = new DefaultUserManagementService();
            }
            return instance;
        }
    }
