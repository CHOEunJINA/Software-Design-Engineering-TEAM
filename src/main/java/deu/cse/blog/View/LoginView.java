/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

/**
 *
 * @author a4424
 */
import deu.cse.blog.Controller.LoginController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginView extends JFrame implements ActionListener {

    private LoginController controller;
    private JTextField idField;
    private JPasswordField pwField;
    private JLabel messageLabel;

    public LoginView() {
        this.controller = controller;

        setTitle("로그인");
        setSize(100,200);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 로그인 폼을 위한 컴포넌트 생성
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,15));
        JLabel idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        idField = new JTextField(15);
        JLabel pwLabel = new JLabel("비밀번호");
        pwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        pwField = new JPasswordField(15);
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(pwLabel);
        formPanel.add(pwField);

        // 로그인 버튼 생성
        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(this);

        // 메시지 표시 레이블 생성
        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        messageLabel.setForeground(Color.RED);

        // 레이아웃 설정 및 컴포넌트 추가
        JPanel contentPane = new JPanel(new BorderLayout(15, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.setBackground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new BorderLayout(10, 10));
        buttonPanel.add(loginButton, BorderLayout.WEST);
        buttonPanel.add(messageLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("로그인")) {
            String id = idField.getText();
            String pw = new String(pwField.getPassword());
            controller.login(id, pw);
        }
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }


    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
