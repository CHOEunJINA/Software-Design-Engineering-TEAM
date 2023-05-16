/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.LatestPostModelController;
import deu.cse.blog.Controller.LoginViewController;
import deu.cse.blog.Controller.MainViewController;
import deu.cse.blog.Controller.MyViewController;
import deu.cse.blog.Controller.PostViewController;
import deu.cse.blog.Controller.SearchViewController;
import java.awt.BorderLayout;
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

/**
 * 메인 화면 GUI
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 * 2023.5.16 "버튼 이름을 한글로 바꿈" 강대한
 */
public class MainView extends View {
  private JButton mypage_button;
  private JButton postpage_button;
  private JButton login_button;
  private JButton signOutButton;
  private JButton searchButton;
  private JTextField searchBox;
  private int row  = 6;
  private int col = 1;
  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private JPanel searchPanel;
  private JLabel userLabel;

  public MainView() { //처음 메인 페이지를 보여줄 때
        frame = initFrame;
        menuPanel = initMenuPanel;
        contentPanel = initContentPanel;
        searchPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, contentPanelHeight));
        mypage_button = new JButton("내블로그");
        postpage_button = new JButton("글쓰기");
        login_button = new JButton("로그인");
        
        searchBox = new JTextField(50); //검색창
        searchButton = new JButton("🔍");
        searchBox.setText("");
        
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(mypage_button);
        menuPanel.add(postpage_button);
        menuPanel.add(login_button);
        menuPanel.add(searchPanel, BorderLayout.SOUTH);
        
        mypage_button.addActionListener(new MoveActionListener());
        postpage_button.addActionListener(new MoveActionListener());
        login_button.addActionListener(new MoveActionListener());
        searchButton.addActionListener(new MoveActionListener());
        
        setPostModelController(new LatestPostModelController()); //최신 글 가져오기
        List<String> titles = postModelController.getPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) { //최신 글 배치
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
        frame.add(menuPanel, "North");
        frame.add(contentPanel, "South");
        frame.setVisible(true);
  }
  public MainView(JPanel receivedMenuPanel, JPanel receivedContentPanel) { // 다른 페이지에서 메인 페이지로 돌아올 때
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        searchPanel = new JPanel();
        
        menuPanel.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
        
        mypage_button = new JButton("내블로그");
        postpage_button = new JButton("글쓰기");
        login_button = new JButton("로그인");
        signOutButton = new JButton("로그아웃");
        
        String username = user + "님";
        userLabel = new JLabel(username);
        searchBox = new JTextField(50); //검색창
        searchButton = new JButton("🔍");
        searchBox.setText("");
        
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(mypage_button);
        menuPanel.add(postpage_button);
        
        if ("".equals(user)) { //로그인 되었는지 아닌지에 따라 보여주는 것 달라지게
                menuPanel.add(login_button);
            } else {
                menuPanel.add(userLabel);
                menuPanel.add(signOutButton);
            }
        menuPanel.add(searchPanel, BorderLayout.SOUTH);
        
        mypage_button.addActionListener(new MoveActionListener());
        postpage_button.addActionListener(new MoveActionListener());
        login_button.addActionListener(new MoveActionListener());
        signOutButton.addActionListener(new MoveActionListener());
        searchButton.addActionListener(new MoveActionListener());
        
        setPostModelController(new LatestPostModelController());
        List<String> titles = postModelController.getPost();
        contentPanel.setLayout(new GridLayout(row, col));
        for (String title : titles) {
            JLabel label = new JLabel(title);
            contentPanel.add(label);
        }
  }
  class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 어느 행동을 수행할지 결정
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();

        if ("내블로그".equals(page)) {
            System.out.println(user);
            if ("".equals(user)) {
                setViewController(new LoginViewController());               
            } else {
                setViewController(new MyViewController());
            }
        } else if ("글쓰기".equals(page)) {
            if ("".equals(user)) {
                setViewController(new LoginViewController());          
            } else {
                setViewController(new PostViewController());
            }
        } else if ("로그인".equals(page)) {
            setViewController(new LoginViewController());
        } else if ("로그아웃".equals(page)) { //로그인 유저 지우고 새로 고침
            user = "";
            setViewController(new MainViewController());
        } else if ("🔍".equals(page)) {
            String query = searchBox.getText();
            //instance_.setQuery(query);
            setViewController(new SearchViewController());
        } 
        menuPanel.removeAll(); // 기존 페이지 지우기
        contentPanel.removeAll();
        viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI(); // 이동한 페이지 출력
        contentPanel.updateUI();
      }
    }
}
