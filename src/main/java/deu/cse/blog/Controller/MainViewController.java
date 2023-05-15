/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.View.MainView;
import javax.swing.JPanel;

/**
 *
 * @author bluev
 */
public class MainViewController implements ViewController {
    @Override
    public void move(JPanel menuPanel, JPanel contentPanel) {
        MainView mainView = new MainView(menuPanel, contentPanel);
    }
}
