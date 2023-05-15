/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.cse.blog.Controller;

/**
 * 전략 패턴의 유저 데이터를 다루는 모델로 이동을 위한 인터페이스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public interface UserModelController {  
    public abstract String action(String id, String pw, String name, boolean gender);
}
