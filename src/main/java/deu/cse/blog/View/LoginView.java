/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.CharToString;
import deu.cse.blog.Controller.LoginModelController;
import deu.cse.blog.Controller.MainViewController;
import deu.cse.blog.Controller.SignupViewController;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 로그인 페이지 GUI
 * @author 조은진
 * 2023.5.11 "최적화" 강대한
 */
public class LoginView extends View{
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel formPanel;
    private JTextField idField;
    private JPasswordField pwField;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JButton signInButton;
    private JButton signUpButton;
    private int formPanelHeight = 100;
    private int formPanelWidth = 200;
    private int menuPanelHeight = 50;
    
    public LoginView() {}
    
    public LoginView(JPanel receivedMenuPanel, JPanel receivedContentPanel) {
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));
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
        
        signInButton.addActionListener(new LoginActionListener());
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
    class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 어느 행동을 수행할지 결정
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        
        if ("MainPage".equals(page)) {
            setViewController(new MainViewController());
        } else if ("회원가입".equals(page)) {
            setViewController(new SignupViewController());
        } 
        menuPanel.removeAll();
        contentPanel.removeAll();
        viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
    class LoginActionListener implements ActionListener { //로그인 절차 수행
        @Override
        public void actionPerformed(ActionEvent e) {
            String pwd = CharToString.charToString(pwField.getPassword());
            String id = idField.getText().trim(); // 공백을 없게 하여 비정상적인 로그인 차단
            setUserModelController(new LoginModelController());
            String name = userModelController.action(id, pwd, "", true);
            if (!name.equals("")) {
                JOptionPane.showMessageDialog(getContentPane(), "로그인 성공!");
                user = name;
                menuPanel.removeAll();
                contentPanel.removeAll();
                setViewController(new MainViewController());
                viewController.move(menuPanel, contentPanel);
                menuPanel.updateUI();
                contentPanel.updateUI();
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "로그인 실패!");
            }
        }
    }
}
