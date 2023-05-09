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
import com.mycompany.blogplatform.View.Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author bluev
 */
public class PostPage extends Page{
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public PostPage() {}
    
    public PostPage(JPanel receivedMenuPanel, JPanel receivedContentPanel) {

        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        
        JButton mainPageButton = new JButton("MainPage");
        mainPageButton.addActionListener(new MoveActionListener());
        JLabel label = new JLabel("test");
        
        menuPanel.add(mainPageButton);
        contentPanel.add(label);
    }
    class MoveActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        menuPanel.removeAll();
        contentPanel.removeAll();
        if ("MainPage".equals(page)) {
            setMoveBehavior(new MoveToMainPage());
        } else if ("MyPage".equals(page)) {
            setMoveBehavior(new MoveToMyPage());
        } else if ("PostPage".equals(page)) {
            setMoveBehavior(new MoveToPostPage());
        } else if ("SignInPage".equals(page)) {
            setMoveBehavior(new MoveToSignInPage());
        } else if ("ResultPage".equals(page)) {
            setMoveBehavior(new MoveToResultPage());
        }
        move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
