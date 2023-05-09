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
public class SignUp {
    private static final String UserData = "user_data.txt";
    private static FileSystem instance_ = instance();
    public static void saveSignUpInfo(String userID, String password, String name) {
        JSONArray jsonArr = instance_.getUser();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("ID", userID);
        jsonObj.put("Password", password);
        jsonArr.add(jsonObj);
        instance_.setUser(jsonArr);
    }

    // 아이디 중복 체크 메서드
    public static boolean checkDuplicateId(String userID) {
        boolean duplicated = false;
        JSONArray jsonArr = instance_.getUser();

        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("ID").equals(userID)) {
                duplicated = true;
            }
        }
        return duplicated;
    }
}
