/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bluev
 */
public class MoveToSignInPage implements MoveBehavior{
    @Override
    public void moveTo(JFrame frame, JPanel menuPanel, JPanel contentPanel, String query) {
      SignInPage signInPage = new SignInPage(frame);
    }
}
