/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Service.UserService;

/**
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한 2023.05.19 수정 조은진
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

        String result = userService.login(id, password);
        if (result.equals("success")) {
            //userid =id;

            return id;
        } else if (result.equals("null")) {
            return "null";
        }
        return null;

    }

    public Boolean deleteUser(String id) {

        String result = userService.delete(id);

        if (result.equals("success")) {
            return true;
        } else if (result.equals("null")) {
            return false;
        }
        return null;

    }
}
