package com.mycompany.blogplatform.View;

import com.mycompany.blogplatform.Model.FileSystem;
import com.mycompany.blogplatform.Controller.MoveBehavior;
import com.mycompany.blogplatform.Model.Post;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 페이지 슈퍼 클래스
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */

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
  protected int menuPanelWidth = 700;
  protected int contentPanelHeight = pageHeight - menuPanelHeight;
  protected int contentPanelWidth = 700;
  protected static String user = ""; //로그인된 유저 이름
  
  public Page() {
      post = new Post();
      initFrame = new JFrame();
      initMenuPanel = new JPanel();
      initContentPanel = new JPanel();
      
      initFrame.setSize(pageWidth, pageHeight);
      initFrame.setResizable(false);
      initFrame.setLocationRelativeTo(null); // 모니터 중앙에 화면 띄우기
      initFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public Page(JFrame receivedFrame, JPanel receivedMenuPanel, JPanel receivedContentPanel) {}
 //페이지 이동
  public void move(JPanel menuPanel, JPanel contentPanel) {
      moveBehavior.moveTo(menuPanel, contentPanel);
  }
  // 어느 페이지로 이동할지 설정
  public void setMoveBehavior(MoveBehavior m) { 
      moveBehavior = m;
  }
}
