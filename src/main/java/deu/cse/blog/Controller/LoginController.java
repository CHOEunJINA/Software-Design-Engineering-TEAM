/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Controller;

/**
 *
 * @author a4424
 */
import deu.cse.blog.Model.LoginModel;
import deu.cse.blog.View.LoginView;
import deu.cse.blog.View.SignUpView;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginController {
    
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        //this.loginView.addLoginListener(new LoginListener());
    }

    public void login(String id, String pw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();
            
            if (loginModel.authenticate(username, password)) {
                loginView.showMessage("로그인 성공!");
                loginView.dispose();
                // 로그인 성공시 다음 화면으로 이동
            } else {
                loginView.showMessage("로그인 실패!");
            }
        }
    }
}
