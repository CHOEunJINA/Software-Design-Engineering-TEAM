/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

/**
 *
 * @author 강대한
 */
public class Memento {
    private String state; // 글 내용
    
    public Memento(String state) {
        System.out.println(state + " 메멘토 객체 생성");
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
