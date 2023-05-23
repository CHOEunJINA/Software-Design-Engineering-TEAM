/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog;

/**
 *
 * @author bluev
 */
public class CharToString {
    public static String charToString(char[] password) {
        String pwd = "";
        for (char cha : password) {
            Character.toString(cha);
            pwd += cha;
        }
        return pwd;
    }
}
