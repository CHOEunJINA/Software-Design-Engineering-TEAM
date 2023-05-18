/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bluev
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public CareTaker() {
        mementoList.add(new Memento(""));
    }
    
    public void add(Memento state) {
        mementoList.add(state);
    }
    
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
