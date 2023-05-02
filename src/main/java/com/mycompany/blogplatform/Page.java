package com.mycompany.blogplatform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page extends JFrame{
  protected MoveBehavior moveBehavior;
  protected FileSystem instance_;
  protected JFrame frame;
  protected JPanel menuPanel;
  protected JPanel contentPanel;
  protected int pageHeight = 500;
  protected int pageWidth = 500;
  protected int menuPanelHeight = 50;
  protected int menuPanelWidth = 500;
  protected int contentPanelHeight = pageHeight - menuPanelHeight - 10;
  protected int contentPanelWidth = 500;
  
  public Page() {
      instance_ = FileSystem.instance(); //하나의 객체만 생성되기에 Page의 서브클래스들이 상속받아 사용한다.
     
      frame = new JFrame();
      menuPanel = new JPanel();
      contentPanel = new JPanel();
      
      frame.setSize(pageWidth, pageHeight);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void move(JFrame frame, JPanel menuPanel, JPanel contentPanel) {
      moveBehavior.moveTo(frame, menuPanel, contentPanel);
  }
  public void setMoveBehavior(MoveBehavior m) {
      moveBehavior = m;
  }
  
//  public class MyPageActionListener implements ActionListener {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          
//          move(frame, menuPanel, contentPanel);
//      }
//  }
//  public class PostPageActionListener implements ActionListener {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          
//          move(frame, menuPanel, contentPanel);
//      }
//  }
//  public class SignInActionListener implements ActionListener {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          setMoveBehavior(new MoveToSignInPage());
//          move(frame, menuPanel, contentPanel);
//      }
//  }
//  public class ResultPageActionListener implements ActionListener {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        setMoveBehavior(new MoveToResultPage());
//        move(frame, menuPanel, contentPanel);
//      }
//    }

}
