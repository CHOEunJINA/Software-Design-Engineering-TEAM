/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Controller;

import com.mycompany.blogplatform.View.ResultPage;
import javax.swing.JPanel;

/**
 * 전략 패턴의 구현된 전략
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
public class MoveToResultPage implements MoveBehavior{
    @Override
    public void moveTo(JPanel menuPanel, JPanel contentPanel) {
      ResultPage resultPage = new ResultPage(menuPanel, contentPanel);
    }
}
