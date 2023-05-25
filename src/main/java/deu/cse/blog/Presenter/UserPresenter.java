/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Service.UserService;
import org.json.simple.JSONObject;

/**
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한 
 * 2023.05.19 수정 조은진
 */
public class UserPresenter {

    private UserService userService;

    public UserPresenter() {
        this.userService = new UserService();
    }

    public Boolean registerUser(String id, String name, String password, String passwordConfirm, String gender) {

        Boolean result = userService.signUp(id, name, password, passwordConfirm, gender);

        return result;

    }

    public String loginUser(String id, String password) {

        Boolean result = userService.login(id, password);

        if (result == true) {
            return id;
        } else {
            return null;
        }

    }
    
    public JSONObject loadUserInfo() {
        return userService.loadUserInfo();
    }
    
    public boolean updateUser(String id, String password, String gender) {
        userService.updateUser(id, password, gender);
        return true;
    }
    
    public boolean deleteUser() {
        userService.deleteUser();
        return true;
    }
    
    public boolean logOut() {
        return userService.logOut();
    }
    
    public String getCurrentUser() {
        return userService.currentUser();
    }
}
