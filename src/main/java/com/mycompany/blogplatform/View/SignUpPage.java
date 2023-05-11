/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.CharToString;
import com.mycompany.blogplatform.Controller.MoveToMainPage;
import com.mycompany.blogplatform.Controller.MoveToSignInPage;
import com.mycompany.blogplatform.Model.SignUp;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 회원가입 페이지 GUI
 * @author 조은진
 * 2023.5.11 "최적화" 강대한
 */
public class SignUpPage extends Page {
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel formPanel;
    private int formPanelHeight = 200;
    private int formPanelWidth = 200;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JLabel nameLabel;
    private JLabel birthLabel;
    private JLabel pwConfirmLabel;
    
    private JTextField idTextField;
    private JPasswordField pwField;
    private JPasswordField pwConfirmField;
    private JTextField nameField;
    
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    
    private JButton signUpButton;
    private JButton cancelButton;
    
    private SignUp signUp;
    public SignUpPage() {
    }
    public SignUpPage(JPanel receivedMenuPanel, JPanel receivedContentPanel) {
        signUp = new SignUp();
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));
        contentPanel.setLayout(new FlowLayout());
        
        formPanel.setPreferredSize(new Dimension(formPanelWidth, formPanelHeight));
        
        // 아이디 입력 필드
        idLabel = new JLabel("아이디");
        idTextField = new JTextField(17);
        formPanel.add(idLabel);
        formPanel.add(idTextField);

        // 비밀번호 입력 필드
        pwLabel = new JLabel("비밀번호");
        pwField = new JPasswordField(17);
        formPanel.add(pwLabel);
        formPanel.add(pwField);

        // 비밀번호 확인 필드
        pwConfirmLabel = new JLabel("비밀번호 확인");
        pwConfirmField = new JPasswordField(17);
        formPanel.add(pwConfirmLabel);
        formPanel.add(pwConfirmField);
        
        // 이름 확인 필드
        nameLabel = new JLabel("이름");
        nameField = new JTextField(17);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        
        // 라디오 버튼 추가
        maleButton = new JRadioButton("남성");
        femaleButton = new JRadioButton("여성");

        // 라디오 버튼 그룹으로 묶기
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        formPanel.add(maleButton);
        formPanel.add(femaleButton);

        // 버튼 추가
        signUpButton = new JButton("회원가입");
        cancelButton = new JButton("취소");
        
        signUpButton.addActionListener(new SignUpActionListener());
        cancelButton.addActionListener(new MoveActionListener());
        
        formPanel.add(signUpButton);
        formPanel.add(cancelButton);
        
        contentPanel.add(formPanel);
    }
    class MoveActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        setMoveBehavior(new MoveToMainPage());
        menuPanel.removeAll();
        contentPanel.removeAll();
        move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
    class SignUpActionListener implements ActionListener { //회원가입 절차 수행
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = idTextField.getText();
            String pwd1 = CharToString.charToString(pwField.getPassword());
            String pwd2 = CharToString.charToString(pwConfirmField.getPassword());
            String name = nameField.getText();
            if ((!signUp.checkDuplicatedID(user)) && pwd1.equals(pwd2)) {
                if (!signUp.checkDuplicatedName(name)) {
                    signUp.saveSignUpInfo(user, pwd1, name);
                    menuPanel.removeAll();
                    contentPanel.removeAll();
                    setMoveBehavior(new MoveToSignInPage());
                    move(menuPanel, contentPanel);
                    menuPanel.updateUI();
                    contentPanel.updateUI();
                }
            }
        }
    }
}
