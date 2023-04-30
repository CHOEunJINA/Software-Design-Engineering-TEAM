/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.LoginController;
import deu.cse.blog.Model.LoginModel;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author a4424
 */


public class MainGUI extends JFrame {

    private JButton loginButton;
    private JButton signUpButton;
    private JButton MyPageButton;
    private JButton MyblogButton;
    private JButton WriteButton;

    public MainGUI() {
        super("Blog System");

        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // 중앙 정렬
        
        Container contentPane=getContentPane();
        contentPane.setBackground(Color.WHITE);

        // 버튼 추가
        loginButton = new JButton("로그인");
        signUpButton = new JButton("회원가입");
        MyPageButton=new JButton("마이페이지");
        MyblogButton = new JButton("내 블로그");
        WriteButton = new JButton("글쓰기");
        
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
        contentPane.add(MyblogButton);
        contentPane.add(WriteButton);
        contentPane.add(loginButton);
        contentPane.add(signUpButton);
        contentPane.add(MyPageButton);
        
        // 회원가입 버튼에 ActionListener 추가
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUpView();
                setVisible(false);
            }
        });
        
        // 로그인 버튼 클릭 시 LoginView 보이기
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginView();
                setVisible(false);
            }
        });

        
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}


