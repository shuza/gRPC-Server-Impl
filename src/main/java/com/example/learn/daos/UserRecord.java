package com.example.learn.daos;

import java.util.HashMap;

public class UserRecord {
    private HashMap<String, String> userList;

    private static UserRecord instance = null;

    private UserRecord() {
        userList = new HashMap<String, String>();
    }

    public static UserRecord getInstance() {
        if (instance == null) {
            instance = new UserRecord();
        }

        return instance;
    }

    public boolean isUserMatch(String username, String password) {
        try {
            return userList.get(username).contentEquals(password);
        } catch (Exception e) {
            System.out.println("isUserMatch  Error   ===//    " + e.getMessage());
            return false;
        }
    }

    public boolean isUserExist(String username) {
        return userList.containsKey(username);
    }

    public boolean createUser(String username, String password) {
        if (isUserExist(username)) {
            return false;
        }

        userList.put(username, password);
        return true;
    }
}
