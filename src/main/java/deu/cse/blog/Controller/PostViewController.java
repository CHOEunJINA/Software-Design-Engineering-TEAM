/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.View.PostView;
import javax.swing.JPanel;

/**
 *
 * @author bluev
 */
public class PostViewController implements ViewController {
    @Override
    public void move(JPanel menuPanel, JPanel contentPanel) {
        PostView postView = new PostView(menuPanel, contentPanel);
    }
}
