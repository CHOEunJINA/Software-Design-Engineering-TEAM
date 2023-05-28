/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Memento;
import deu.cse.blog.Model.Repository.MementoArchive;
import deu.cse.blog.Model.Service.MementoArchiveIterator;

/**
 * 메멘토 패턴의 originator, undo, redo 관리
 * @author 강대한
 */
public class Originator {
    private String state;
    // 집합체에 대한 이터레이터
    private MementoArchiveIterator mementoArchiveIterator = new MementoArchive().iterator();

    public void setState(String state) { // 글 내용 저장
        this.state = state;
        System.out.println("현재 상태 : " + state);
        mementoArchiveIterator.add(saveStateToMemento());
    }
    
    public String getState(boolean isUndo) {
        if (isUndo && mementoArchiveIterator.hasBack()) {
            getStateFromMemento(mementoArchiveIterator.backward());
        } else if(!isUndo && mementoArchiveIterator.hasNext()){
            getStateFromMemento(mementoArchiveIterator.next());
        }    
        return state;
    }
    
    public Memento saveStateToMemento() { // 글 내용을 메멘토 객체로 변환
        System.out.println(state + " 를 메멘토 객체로 변환");
        return new Memento(state);
    }
    
    public void getStateFromMemento(Memento memento) {
        System.out.println("메멘토 객체에서 " + state + " 를 가져옴");
        state = memento.getState();
    }
}
