/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Repository.Memento;
import deu.cse.blog.Model.Service.MementoArchiveIterator;

/**
 *
 * @author bluev
 */
public class Originator {

    private String state;
    private MementoArchiveIterator mementoArchiveIterator = new MementoArchiveIterator();

    public void setState(String state) {
        this.state = state;
        mementoArchiveIterator.add(saveStateToMemento());
    }

    public String getState(boolean isUndo) {
        if (isUndo && mementoArchiveIterator.hasBack()) {
            getStateFromMemento(mementoArchiveIterator.backward());
        } else if (!isUndo && mementoArchiveIterator.hasNext()) {
            getStateFromMemento(mementoArchiveIterator.next());
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
