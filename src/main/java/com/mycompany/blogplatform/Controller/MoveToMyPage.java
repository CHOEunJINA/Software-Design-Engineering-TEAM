/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Controller;

import com.mycompany.blogplatform.Controller.MoveBehavior;
import com.mycompany.blogplatform.View.MyPage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bluev
 */
public class MoveToMyPage implements MoveBehavior{
    @Override
    public void moveTo(JPanel menuPanel, JPanel contentPanel) {
      MyPage myPage = new MyPage(menuPanel, contentPanel);
    }
}
