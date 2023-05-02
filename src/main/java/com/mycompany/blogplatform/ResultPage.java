/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author bluev
 */
public class ResultPage extends Page{
    private JFrame receivedFrame;
    private String query = "";
    public ResultPage(JFrame receivedFrame, String receivedQuery) {
        this.receivedFrame = receivedFrame;
        this.query = receivedQuery;
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, contentPanelHeight));
        
        menuPanel.setLayout(new FlowLayout());
   
        JButton mainPageButton = new JButton("MainPage");
        mainPageButton.addActionListener(new MoveActionListener());
             

        menuPanel.add(mainPageButton);
        receivedFrame.add(menuPanel, "North");
        receivedFrame.add(contentPanel, "South");
        System.out.println(query);
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
        move(receivedFrame, menuPanel, contentPanel, query);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
