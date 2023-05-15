/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.MainViewController;
import deu.cse.blog.Controller.MyViewController;
import deu.cse.blog.Controller.SearchViewController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 글 작성 페이지 GUI
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
public class PostView extends View{
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public PostView() {}
    
    public PostView(JPanel receivedMenuPanel, JPanel receivedContentPanel) {

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
            setViewController(new MainViewController());
        } else if ("MyPage".equals(page)) {
            setViewController(new MyViewController());
        } else if ("ResultPage".equals(page)) {
            setViewController(new SearchViewController());
        }
        menuPanel.removeAll();
        contentPanel.removeAll();
        viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
