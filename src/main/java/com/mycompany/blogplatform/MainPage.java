
package com.mycompany.blogplatform;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;


public class MainPage extends Page {
  private JButton mypage_button;
  private JButton postpage_button;
  private JButton signin_button;
  private JButton searchButton;
  private JTextField searchBox;
  private int row  = 6;
  private int col = 1;
  private boolean init = false;
  private JFrame receivedFrame;
  private String query = "";

  public MainPage() {
        receivedFrame = frame;
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, contentPanelHeight));
        mypage_button = new JButton("MyPage");
        postpage_button = new JButton("PostPage");
        signin_button = new JButton("SignInPage");
        
        searchBox = new JTextField(50);
        searchButton = new JButton("🔍");
        searchBox.setText("검색어를 입력하시오 ");
        
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(mypage_button);
        menuPanel.add(postpage_button);
        menuPanel.add(signin_button);
        menuPanel.add(searchBox);
        menuPanel.add(searchButton);
        
        mypage_button.addActionListener(new MoveActionListener());
        postpage_button.addActionListener(new MoveActionListener());
        signin_button.addActionListener(new MoveActionListener());
        searchButton.addActionListener(new MoveActionListener());
        
        List<String> titles = instance_.getLatestPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) {
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
        receivedFrame.add(menuPanel, "North");
        receivedFrame.add(contentPanel, "South");
        if (init == false) {
            receivedFrame.setVisible(true);
            init = true;
        } 
  }
  public MainPage(JFrame receivedFrame) {
        this.receivedFrame = receivedFrame;
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, contentPanelHeight));
        mypage_button = new JButton("MyPage");
        postpage_button = new JButton("PostPage");
        signin_button = new JButton("SignInPage");
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(mypage_button);
        menuPanel.add(postpage_button);
        menuPanel.add(signin_button);
        
        mypage_button.addActionListener(new MoveActionListener());
        postpage_button.addActionListener(new MoveActionListener());
        signin_button.addActionListener(new MoveActionListener());
        List<String> titles = instance_.getLatestPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) {
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
        receivedFrame.add(menuPanel, "North");
        receivedFrame.add(contentPanel, "South");
        if (init == false) {
            receivedFrame.setVisible(true);
            init = true;
        } 
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
        } else if ("🔍".equals(page)) {
            query = searchBox.getText();
            setMoveBehavior(new MoveToResultPage());
        } 
        move(receivedFrame, menuPanel, contentPanel, query);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
