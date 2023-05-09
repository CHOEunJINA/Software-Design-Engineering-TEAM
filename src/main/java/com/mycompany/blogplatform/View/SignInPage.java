/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.Controller.MoveToMainPage;
import com.mycompany.blogplatform.Controller.MoveToSignUpPage;
import com.mycompany.blogplatform.Model.SignIn;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author bluev
 */
public class SignInPage extends Page{
    private SignIn signIn = new SignIn();
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel formPanel;
    private JTextField idField;
    private JPasswordField pwField;
    private JLabel messageLabel;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JButton signInButton;
    private JButton signUpButton;
    private int formPanelHeight = 100;
    private int formPanelWidth = 200;
    private int menuPanelHeight = 50;
    
    public SignInPage() {}
    
    public SignInPage(JPanel receivedMenuPanel, JPanel receivedContentPanel) {

        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));
        contentPanel.setLayout(new FlowLayout());
        
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        formPanel.setPreferredSize(new Dimension(formPanelWidth, formPanelHeight));
        JButton mainPageButton = new JButton("MainPage");
        mainPageButton.addActionListener(new MoveActionListener());
        
        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        idField = new JTextField(15);
        pwLabel = new JLabel("Password");
        pwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        pwField = new JPasswordField(15);
        signInButton = new JButton("로그인");
        signUpButton = new JButton("회원가입");
        
        signInButton.addActionListener(new SignInActionListener());
        signUpButton.addActionListener(new MoveActionListener());
        
        menuPanel.add(mainPageButton);
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(pwLabel);
        formPanel.add(pwField);
        formPanel.add(signInButton);
        formPanel.add(signUpButton);
        
        contentPanel.add(formPanel);
    }
    class MoveActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        menuPanel.removeAll();
        contentPanel.removeAll();
        if ("MainPage".equals(page)) {
            setMoveBehavior(new MoveToMainPage());
        } else if ("회원가입".equals(page)) {
            setMoveBehavior(new MoveToSignUpPage());
        } 
        move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
    class SignInActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (signIn.authenticate(idField.getText(), pwField.getPassword())) {
                user = idField.getText();
                menuPanel.removeAll();
                contentPanel.removeAll();
                setMoveBehavior(new MoveToMainPage());
                move(menuPanel, contentPanel);
                menuPanel.updateUI();
                contentPanel.updateUI();
            }
        }
    }
}
