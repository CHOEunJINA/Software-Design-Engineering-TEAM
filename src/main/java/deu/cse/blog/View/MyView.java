/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.DeleteUserModelController;
import deu.cse.blog.Controller.MainViewController;
import deu.cse.blog.Controller.PostViewController;
import deu.cse.blog.Controller.SearchViewController;
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
 * 2023.5.16 "버튼 이름을 한글로 바꿈" 강대한
 */
public class MyView extends View {
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public MyView() {}
    
    public MyView(JPanel receivedMenuPanel,JPanel receivedContentPanel) {
        
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;

        JButton mainPageButton = new JButton("블로그홈");
        mainPageButton.addActionListener(new MoveActionListener());
        JLabel label = new JLabel("test");
        
        menuPanel.add(mainPageButton);
        contentPanel.add(label);

    }
    
    class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 어느 행동을 수행할지 결정
      @Override
      public void actionPerformed(ActionEvent e) {
        String page = e.getActionCommand();
        
        if ("블로그홈".equals(page)) {
            setViewController(new MainViewController());
        } else if ("글쓰기".equals(page)) {
            setViewController(new PostViewController());
        } else if ("🔍".equals(page)) {
            setViewController(new SearchViewController());
        } 
        menuPanel.removeAll();
        contentPanel.removeAll();
        viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
    class DeleteUserActionListener implements ActionListener { //회원가입 절차 수행
        @Override
        public void actionPerformed(ActionEvent e) {
            setUserModelController(new DeleteUserModelController());
            setViewController(new MainViewController());
            userModelController.action("", "", user, true);
        }
    }
}
