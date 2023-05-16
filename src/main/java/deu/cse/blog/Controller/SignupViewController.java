/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.View.SignupView;
import javax.swing.JPanel;

/**
 * 전략 패턴의 구상 클래스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public class SignupViewController implements ViewController {
    @Override
    public void move(JPanel menuPanel, JPanel contentPanel) {
        SignupView signupView = new SignupView(menuPanel, contentPanel);
    }
}
