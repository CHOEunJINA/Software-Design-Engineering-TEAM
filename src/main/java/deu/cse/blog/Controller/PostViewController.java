/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.View.PostView;
import javax.swing.JPanel;

/**
 * 전략 패턴의 구상 클래스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public class PostViewController implements ViewController {
    @Override
    public void move(JPanel menuPanel, JPanel contentPanel) {
        PostView postView = new PostView(menuPanel, contentPanel);
    }
}
