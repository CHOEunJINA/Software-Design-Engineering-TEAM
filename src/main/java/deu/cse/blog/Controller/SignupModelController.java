/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.SignupModel;

/**
 * 전략 패턴의 구상 클래스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public class SignupModelController implements UserModelController{
    private SignupModel signupModel = new SignupModel();
    @Override
    public String action(String id, String pw, String name, boolean gender) {
        String user = signupModel.saveSignUpInfo(id, pw, name, gender);
        return user;
    }
}
