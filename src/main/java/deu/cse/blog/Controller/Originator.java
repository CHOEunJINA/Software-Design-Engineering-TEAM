/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.CareTaker;
import deu.cse.blog.Model.Memento;

/**
 *
 * @author bluev
 */
public class Originator {
    private String state;
    private CareTaker careTaker = new CareTaker();
    private int index = -1;
    private int maxIndex;
    public void setState(String state) {
        this.state = state;
        careTaker.add(saveStateToMemento());
        index++;
        if (index > maxIndex) {
            maxIndex = index;
        }
    }
    
    public String getState(boolean isUndo) {
        assert(index >= 0);
        assert(index <= maxIndex);
        if (isUndo) {
            getStateFromMemento(careTaker.get(index));
            index--;
        } else {
            index = index + 2;
            getStateFromMemento(careTaker.get(index));
            index--;
        }
        
        return state;
    }
    
    public Memento saveStateToMemento() {
        return new Memento(state);
    }
    
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
