/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Controller.GetPostModelController;
import deu.cse.blog.Controller.SetPostModelController;
import deu.cse.blog.Controller.UserModelController;
import deu.cse.blog.Controller.ViewController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * 페이지 슈퍼 클래스
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */

public class View extends JFrame{
  protected ViewController viewController;
  protected UserModelController userModelController;
  protected SetPostModelController setPostModelController;
  protected GetPostModelController getPostModelController;
  protected JFrame initFrame;
  protected JPanel initMenuPanel;
  protected JPanel initContentPanel;
  protected int pageHeight = 600;
  protected int pageWidth = 800;
  protected int menuPanelHeight = 80;
  protected int menuPanelWidth = 800;
  protected int contentPanelHeight = pageHeight - menuPanelHeight - 30;
  protected int contentPanelWidth = 800;
  protected static String user = ""; //로그인된 유저 이름
  
  public View() {
      initFrame = new JFrame();
      initMenuPanel = new JPanel();
      initContentPanel = new JPanel();
      
      initFrame.setSize(pageWidth, pageHeight);
      initFrame.setResizable(false);
      initFrame.setLocationRelativeTo(null); // 모니터 중앙에 화면 띄우기
      initFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public View(JFrame receivedFrame, JPanel receivedMenuPanel, JPanel receivedContentPanel) {}

  // 어느 페이지로 이동할지 설정
  public void setViewController(ViewController vc) { 
      viewController = vc;
  }
  //어떤 컨트롤러를 사용할지 설정
  public void setUserModelController(UserModelController umc) { 
      userModelController = umc;
  }
  
  public void setSetPostModelController(SetPostModelController spmc) { 
      setPostModelController = spmc;
  }
  
  public void setGetPostModelController(GetPostModelController gpmc) { 
      getPostModelController = gpmc;
  }
}
