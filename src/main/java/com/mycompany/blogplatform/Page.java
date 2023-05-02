package com.mycompany.blogplatform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page extends JFrame{
  protected MoveBehavior moveBehavior;
  protected FileSystem instance_;
  protected JFrame frame;
  protected JPanel menuPanel;
  protected JPanel contentPanel;
  protected int pageHeight = 600;
  protected int pageWidth = 800;
  protected int menuPanelHeight = 150;
  protected int menuPanelWidth = 800;
  protected int contentPanelHeight = pageHeight - menuPanelHeight - 10;
  protected int contentPanelWidth = 1000;
  
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
  public void move(JFrame frame, JPanel menuPanel, JPanel contentPanel, String query) {
      moveBehavior.moveTo(frame, menuPanel, contentPanel, query);
  }
  public void setMoveBehavior(MoveBehavior m) {
      moveBehavior = m;
  }

}
