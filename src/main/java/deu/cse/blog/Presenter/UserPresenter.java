/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Service.UserService;
import deu.cse.blog.Model.User;

/**
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한 
 * 2023.05.19 수정 조은진
 */
public class UserPresenter {

    private UserService userService;
    private Facade userFacade;
    
    public UserPresenter() {
        this.userService = new UserService();
        this.userFacade = new Facade();
    }

    public Boolean registerUser(String id, String name, String password, String passwordConfirm, String gender) {

        Boolean result = userService.signUp(id, name, password, passwordConfirm, gender);

        return result;

    }

    public Boolean signOut(String userId){
        return this.userFacade.deleteUser(userId);
    }
    
    public String loginUser(String id, String password) {

        User result = userService.login(id, password);

        if (result == null) {
            return null;
        } 
        return result.getName();
    }
    
    public User loadUserInfo() {
        return userService.loadUserInfo();
    }
    
    public boolean updateUser(String id, String password, String gender, String name) {    
        return userService.updateUser(id, password, gender, name);
    }
    
    public boolean deleteUser() {
        userService.deleteUser();
        return true;
    }
    
    public boolean logOut() {
        return userService.logOut();
    }
    
}
