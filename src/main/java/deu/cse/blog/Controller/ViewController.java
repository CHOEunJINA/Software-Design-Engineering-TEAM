/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.cse.blog.Controller;

import javax.swing.JPanel;

/**
 * 전략 패턴의 전략 인터페이스
 * @author 강대한
 * @
 * 2023.5.11 "최적화" 강대한
 */
public interface ViewController {
    public abstract void move(JPanel menuPanel, JPanel contentPanel); 
}
