/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model;

/**
 *
 * @author a4424
 */
import java.io.*;
import java.util.*;

public class LoginModel {
    private static final String LoginUser = "users.txt";
    
    // 유저 정보를 담은 클래스
    private class User {
        String username;
        String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public boolean authenticate(String username, String password) {
        List<User> userList = loadUsers();
        for (User user : userList) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    private List<User> loadUsers() {
        List<User> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(LoginUser))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String username = tokens[0];
                String password = tokens[1];
                userList.add(new User(username, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean addUser(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LoginUser, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}


