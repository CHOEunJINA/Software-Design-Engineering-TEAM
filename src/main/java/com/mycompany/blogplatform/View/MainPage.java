
package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.Controller.MoveToMainPage;
import com.mycompany.blogplatform.Controller.MoveToMyPage;
import com.mycompany.blogplatform.Controller.MoveToPostPage;
import com.mycompany.blogplatform.Controller.MoveToResultPage;
import com.mycompany.blogplatform.Controller.MoveToSignInPage;
import static com.mycompany.blogplatform.View.Page.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
  private JButton signOutButton;
  private JButton searchButton;
  private JTextField searchBox;
  private int row  = 6;
  private int col = 1;
  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private JLabel userLabel;

  public MainPage() { //처음 메인 페이지를 보여줄 때
        frame = initFrame;
        menuPanel = initMenuPanel;
        contentPanel = initContentPanel;
        
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, contentPanelHeight));
        mypage_button = new JButton("MyPage");
        postpage_button = new JButton("PostPage");
        signin_button = new JButton("SignInPage");
        
        searchBox = new JTextField(50); //검색창
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
        
        List<String> titles = post.getLatestPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) {
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
        frame.add(menuPanel, "North");
        frame.add(contentPanel, "South");
        frame.setVisible(true);
  }
  public MainPage(JPanel receivedMenuPanel, JPanel receivedContentPanel) { // 다른 페이지에서 메인 페이지로 돌아올 때
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        
        mypage_button = new JButton("MyPage");
        postpage_button = new JButton("PostPage");
        signin_button = new JButton("SignInPage");
        signOutButton = new JButton("로그아웃");
        
        userLabel = new JLabel(user);
        searchBox = new JTextField(50); //검색창
        searchButton = new JButton("🔍");
        searchBox.setText("검색어를 입력하시오 ");
        
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(mypage_button);
        menuPanel.add(postpage_button);
        
        if ("".equals(user)) {
                menuPanel.add(signin_button);
            } else {
                menuPanel.add(userLabel);
                menuPanel.add(signOutButton);
            }
        menuPanel.add(searchBox);
        menuPanel.add(searchButton);
        
        mypage_button.addActionListener(new MoveActionListener());
        postpage_button.addActionListener(new MoveActionListener());
        signin_button.addActionListener(new MoveActionListener());
        signOutButton.addActionListener(new MoveActionListener());
        searchButton.addActionListener(new MoveActionListener());
        
        List<String> titles = post.getLatestPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) {
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
  }
  class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 실행됨
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        menuPanel.removeAll();
        contentPanel.removeAll();

        if ("MainPage".equals(page)) {
            setMoveBehavior(new MoveToMainPage());
        } else if ("MyPage".equals(page)) {
            System.out.println(user);
            if ("".equals(user)) {
                setMoveBehavior(new MoveToSignInPage());
                
            } else {
                setMoveBehavior(new MoveToMyPage());
            }
        } else if ("PostPage".equals(page)) {
            if ("".equals(user)) {
                setMoveBehavior(new MoveToSignInPage());          
            } else {
                setMoveBehavior(new MoveToPostPage());
            }
        } else if ("SignInPage".equals(page)) {
            setMoveBehavior(new MoveToSignInPage());
        } else if ("로그아웃".equals(page)) {
            user = "";
            setMoveBehavior(new MoveToMainPage());
        } else if ("🔍".equals(page)) {
            String query = searchBox.getText();
            instance_.setQuery(query);
            setMoveBehavior(new MoveToResultPage());
        } 
        move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
