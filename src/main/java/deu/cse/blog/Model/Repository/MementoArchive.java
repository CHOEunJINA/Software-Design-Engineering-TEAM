/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Memento;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author bluev
 */
public class MementoArchive {
    private List<Memento> mementoList = new ArrayList<Memento>(); //저장된 글 데이터 집합
    
    public MementoArchive() {
        mementoList.add(new Memento(""));
    }
    
    public void add(int index, Memento state) {
        mementoList.add(index, state);
    }
    
    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
    
    public int getLength() {
        return mementoList.size();
    }
    
}
