/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Memento;
import deu.cse.blog.Model.Service.MementoArchiveIterator;

/**
 * 글 내용 입출력을 관리
 * @author 강대한
 */
public class Originator {
    private String state;
    private MementoArchiveIterator mementoArchiveIterator = new MementoArchiveIterator();

    public void setState(String state) { // 글 내용 저장
        this.state = state;
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
        return new Memento(state);
    }
    
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
