/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Memento;
import deu.cse.blog.Model.Service.MementoArchiveIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * 메멘토 패턴의 caretaker, 이터레이터 패턴의 집합체 클래스
 * @author 강대한
 * 2023.5.28 "집합체의 역할만 수행할 수 있게 add 메서드 제거" 강대한
 */
public class MementoArchive implements Aggregate {
    private List<Memento> mementoList = new ArrayList<Memento>(); //저장된 글 데이터 집합
    
    public MementoArchive() {
        System.out.println("메멘토 리스트 생성");
        mementoList.add(new Memento(""));
    }
    
    @Override
    public MementoArchiveIterator iterator() { //집합체를 가진 이터레이터 반환
        System.out.println("메멘토 리스트가 이터레이터 반환");
        return new MementoArchiveIterator(mementoList);
    }
}
