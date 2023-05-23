/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import java.util.Iterator;

/**
 * 메멘토 패턴의 caretaker
 * @author bluev
 */
public class MementoArchiveIterator implements Iterator<Memento>{
    private MementoArchive mementoArchive;
    private int index = 0;
    public MementoArchiveIterator() {
        mementoArchive = new MementoArchive();
    }
    
    @Override
    public boolean hasNext() {
        return index < (mementoArchive.getLength() - 1);
    }
    
    public boolean hasBack() {
        return index > 0;
    }
    
    @Override
    public Memento next() {
        index++;
        Memento memento = mementoArchive.getMemento(index);
        return memento;
    }
    
    public Memento backward() {
        index--;
        Memento memento = mementoArchive.getMemento(index);
        return memento;
    }
    
    public void add(Memento state) {
        index++;
        mementoArchive.add(index, state);
    }
}
