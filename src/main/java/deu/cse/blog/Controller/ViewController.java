/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.cse.blog.Controller;

import javax.swing.JPanel;

/**
 * 전략 패턴의 view간의 이동을 다루는 인터페이스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public interface ViewController {
    abstract void move(JPanel menuPanel, JPanel contentPanel); 
}
