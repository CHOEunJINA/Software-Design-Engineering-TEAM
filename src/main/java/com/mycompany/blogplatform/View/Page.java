package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.Model.FileSystem;
import com.mycompany.blogplatform.Controller.MoveBehavior;
import com.mycompany.blogplatform.Model.Post;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page extends JFrame{
  protected MoveBehavior moveBehavior;
  protected static FileSystem instance_ = FileSystem.instance(); //하나의 객체만 생성되기에 Page의 서브클래스들이 상속받아 사용한다.
  protected Post post;
  protected JFrame initFrame;
  protected JPanel initMenuPanel;
  protected JPanel initContentPanel;
  protected int pageHeight = 600;
  protected int pageWidth = 800;
  protected int menuPanelHeight = 100;
  protected int menuPanelWidth = 1000;
  protected int contentPanelHeight = pageHeight - menuPanelHeight;
  protected int contentPanelWidth = 1000;
  protected static String user = "";
  
  public Page() {
      post = new Post();
      initFrame = new JFrame();
      initMenuPanel = new JPanel();
      initContentPanel = new JPanel();
      
      initFrame.setSize(pageWidth, pageHeight);
      initFrame.setResizable(false);
      initFrame.setLocationRelativeTo(null);
      initFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public Page(JFrame receivedFrame, JPanel receivedMenuPanel, JPanel receivedContentPanel) {}
  public void move(JPanel menuPanel, JPanel contentPanel) {
      moveBehavior.moveTo(menuPanel, contentPanel);
  }
  public void setMoveBehavior(MoveBehavior m) {
      moveBehavior = m;
  }
//  public String getUserName() {
//      System.out.println(this.user);
//      return user;
//  }
//  public void setUserName(String user) {
//      this.user = user;
//      System.out.println(this.user);
//  }
}
