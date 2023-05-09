/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Model;

import static com.mycompany.blogplatform.Model.FileSystem.instance;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bluev
 */
public class SignIn {
    private static final String LoginUser = "users.txt";
    private FileSystem instance_ = instance();

    public boolean authenticate(String username, char[] password) {
        boolean authenticated = false;
        String pwd = "";
        for (char cha : password) {
            Character.toString(cha);
            pwd += (pwd.equals("")) ? ""+cha+"" : ""+cha+"";
        }
        JSONArray jsonArr = instance_.getUser();
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("ID").equals(username) && jsonObj.get("Password").equals(pwd)) {
                authenticated = true;
            }
        }
        return authenticated;
    }
}
