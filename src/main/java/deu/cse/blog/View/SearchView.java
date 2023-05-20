/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 * 2023.5.16 "버튼 이름을 한글로 바꿈" 강대한
 */
public class SearchView extends JFrame{
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public SearchView() {}
    
    public SearchView(JPanel receivedMenuPanel, JPanel receivedContentPanel) {

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
            //setViewController(new MainViewPresenter());
        } else if ("내블로그".equals(page)) {
            //setViewController(new MyViewPresenter());
        } else if ("글쓰기".equals(page)) {
           // setViewController(new PostViewPresenter());
        } else if ("로그인".equals(page)) {
            //setViewController(new UserPresenter());
        } else if ("🔍".equals(page)) {
            //setViewController(new SearchViewPresenter());
        }
        menuPanel.removeAll();
        contentPanel.removeAll();
        //viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
}
