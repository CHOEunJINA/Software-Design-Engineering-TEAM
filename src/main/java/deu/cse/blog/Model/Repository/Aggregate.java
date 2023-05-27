/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Memento;
import java.util.Iterator;

/**
 * 이터레이터 패턴의 집학체 인터페이스
 * @author 강대한
 */
public interface Aggregate {
    Iterator<Memento> iterator();
}
