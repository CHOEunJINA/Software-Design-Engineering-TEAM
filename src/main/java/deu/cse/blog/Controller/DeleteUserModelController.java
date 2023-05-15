/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.DeleteUserModel;

/**
 *
 * @author bluev
 */
public class DeleteUserModelController implements UserModelController {
    private DeleteUserModel deleteUserModel = new DeleteUserModel();
    public String action(String id, String pw, String name, boolean gender) {
        deleteUserModel.deleteUser(name);
        return name;
    }
}
