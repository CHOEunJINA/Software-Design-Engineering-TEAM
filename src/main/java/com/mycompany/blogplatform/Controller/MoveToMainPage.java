/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Controller;
import com.mycompany.blogplatform.View.MainPage;
import javax.swing.JPanel;
/**
 * 전략 패턴의 구현된 전략
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
public class MoveToMainPage implements MoveBehavior{
    @Override
    public void moveTo(JPanel menuPanel, JPanel contentPanel) {
      MainPage mainPage = new MainPage(menuPanel, contentPanel); // 메인 페이지 GUI를 가져오기 위해 실행
    }
}
