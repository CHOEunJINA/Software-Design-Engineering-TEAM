/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.MainViewController;
import deu.cse.blog.Controller.Originator;
import deu.cse.blog.Controller.SavePostModelController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Timer;
/**
 * 글 작성 페이지 GUI
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 * 2023.5.16 "버튼 이름을 한글로 바꿈" 강대한
 * 2023.5.17 "글 저장 기능 구현" 강대한
 */
public class PostView extends View{
    private Originator originator;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JScrollPane scroller;
    private JTextArea postArea;
    private JTextField titleField;
    private JPanel postPanel;
    private JPanel titlePanel;
    private JPanel toolPanel;
    private JButton mainPageButton;
    private JButton saveButton;
    private JButton backForwardButton;
    private JButton foreForwardButton;
    private int postPanelHeight = 490;
    private int postPanelWidth = 800;
    private String state = "";
    private Timer m;
    private boolean isUndo;
    public PostView() {}
    
    public PostView(JPanel receivedMenuPanel, JPanel receivedContentPanel) {
        originator = new Originator();
        m = new Timer();
        menuPanel = receivedMenuPanel;
        contentPanel = receivedContentPanel;
        postPanel = new JPanel();
        titlePanel = new JPanel();
        toolPanel = new JPanel();
        
        JLabel title = new JLabel("제목"); 
        postArea = new JTextArea();
        titleField = new JTextField(70);
        scroller = new JScrollPane(postArea);
        postPanel.setSize(new Dimension(postPanelWidth, postPanelHeight));
        postPanel.setLayout(new BorderLayout());
        menuPanel.setLayout(new BorderLayout());
        contentPanel.setLayout(new BorderLayout());
        mainPageButton = new JButton("블로그홈");
        saveButton = new JButton("저장");
        backForwardButton = new JButton("");
        foreForwardButton = new JButton("");
        mainPageButton.addActionListener(new MoveActionListener());
        saveButton.addActionListener(new PostActionListener());
        backForwardButton.addActionListener(new PostActionListener());
        foreForwardButton.addActionListener(new PostActionListener());
        
        toolPanel.add(mainPageButton);
        toolPanel.add(saveButton);
        toolPanel.add(backForwardButton);
        toolPanel.add(foreForwardButton);
        titlePanel.add(title);
        titlePanel.add(titleField);
        postPanel.add(scroller, BorderLayout.CENTER);
        
        menuPanel.add(toolPanel);
        menuPanel.add(titlePanel, BorderLayout.SOUTH);
        contentPanel.add(postPanel, BorderLayout.CENTER);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!state.equals(postArea.getText())) {
                    state = postArea.getText();
                    originator.setState(state);
                }
            }
        };
        m.schedule(task, 1000, 3000);
        
    }
    class MoveActionListener implements ActionListener { //페이지 이동이나 검색 버튼을 클릭했을 때 어느 행동을 수행할지 결정
      @Override
      public void actionPerformed(ActionEvent e) {
        m.cancel();
        setViewController(new MainViewController());
        menuPanel.removeAll();
        contentPanel.removeAll();
        viewController.move(menuPanel, contentPanel);
        menuPanel.updateUI();
        contentPanel.updateUI();
      }
    }
    class PostActionListener implements ActionListener { 
      @Override
      public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("저장")) {
            String post = postArea.getText();
            String title = titleField.getText();
            setSetPostModelController(new SavePostModelController());
            boolean success = setPostModelController.setPost(title, post, user);
            if (success) {
                m.cancel();
                setViewController(new MainViewController());
                JOptionPane.showMessageDialog(getContentPane(), "글이 등록되었습니다");
                menuPanel.removeAll();
                contentPanel.removeAll();
                viewController.move(menuPanel, contentPanel);
                menuPanel.updateUI();
                contentPanel.updateUI();
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "잠시 후 다시 시도해주세요");
            }
        } else if (action.equals("")) {
            isUndo = true;
            state = originator.getState(isUndo);
            postArea.setText(state);
        } else if (action.equals("")) {
            isUndo = false;
            state = originator.getState(isUndo);
            postArea.setText(state);
        }
      }
    }
}
