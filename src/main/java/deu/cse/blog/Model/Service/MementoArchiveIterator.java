/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Memento;
import java.util.Iterator;
import java.util.List;

/**
 * 메멘토 패턴의 caretaker, 이터레이터 패턴의 이터레이터, 출력을 관리 
 * @author 강대한
 */
public class MementoArchiveIterator implements Iterator<Memento>{
    private List<Memento> mementoList;
    private int index = 0; //현재 상태 인덱스
    //집합체를 받아와 초기화
    public MementoArchiveIterator(List<Memento> mementoList) {
        System.out.println("이터레이터 생성");
        this.mementoList = mementoList; 
    }
    
    @Override
    public boolean hasNext() {
        System.out.println("이터레이터 되돌리기 할 수 있는지 확인");
        return index < (mementoList.size() - 1);
    }
    
    public boolean hasBack() {
        System.out.println("이터레이터 실행 취소할 데이터가 있는지 확인");
        return index > 0;
    }
    
    @Override
    public Memento next() {
        index++;
        Memento memento = mementoList.get(index);
        System.out.println("이터레이터가 되돌리기 실행");
        return memento;
    }
    
    public Memento backward() {
        index--;
        Memento memento = mementoList.get(index);
        System.out.println("이터레이터 이전 상태 반환");
        return memento;
    }
    //상태 저장
    public void add(Memento state) {
        index++;
        mementoList.add(index, state);
        System.out.println("이터레이터가" + state + " 저장");
    }
}
