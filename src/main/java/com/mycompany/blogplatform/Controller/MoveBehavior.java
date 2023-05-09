/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.blogplatform.Controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author bluev
 */
public interface MoveBehavior {
    public abstract void moveTo(JPanel menuPanel, JPanel contentPanel); //새로운 창을 만들지 않고 이전 프레임 상태를 가져오기 위해 매개변수로 프레임 받아옴
}
