/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Controller;

import com.mycompany.blogplatform.Controller.MoveBehavior;
import com.mycompany.blogplatform.View.ResultPage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bluev
 */
public class MoveToResultPage implements MoveBehavior{
    @Override
    public void moveTo(JPanel menuPanel, JPanel contentPanel) {
      ResultPage resultPage = new ResultPage(menuPanel, contentPanel);
    }
}
