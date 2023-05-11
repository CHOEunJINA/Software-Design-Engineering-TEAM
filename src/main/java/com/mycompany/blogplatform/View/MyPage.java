/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.Controller.MoveToMainPage;
import com.mycompany.blogplatform.Controller.MoveToMyPage;
import com.mycompany.blogplatform.Controller.MoveToPostPage;
import com.mycompany.blogplatform.Controller.MoveToResultPage;
import com.mycompany.blogplatform.Controller.MoveToSignInPage;
import com.mycompany.blogplatform.Model.DeleteUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 * 마이 페이지 GUI
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
public class MyPage extends Page {
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private DeleteUser deleteUser;
    public MyPage() {}
    
    public MyPage(JPanel receivedMenuPanel,JPanel receivedContentPanel) {
        deleteUser = new DeleteUser();
        
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;

        JButton mainPageButton = new JButton("MainPage");
        mainPageButton.addActionListener(new MoveActionListener());
        JLabel label = new JLabel("test");
        
        menuPanel.add(mainPageButton);
        contentPanel.add(label);

    }
    
    class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 어느 행동을 수행할지 결정
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        
        if ("MainPage".equals(page)) {
            setMoveBehavior(new MoveToMainPage());
        } else if ("PostPage".equals(page)) {
            setMoveBehavior(new MoveToPostPage());
        } else if ("ResultPage".equals(page)) {
            setMoveBehavior(new MoveToResultPage());
        } else if ("회원 탈퇴".equals(page)) {
            deleteUser.deleteUser(user);
            setMoveBehavior(new MoveToMainPage());
        }
        menuPanel.removeAll();
        contentPanel.removeAll();
        move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
