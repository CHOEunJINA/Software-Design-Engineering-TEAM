/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Model;

import static com.mycompany.blogplatform.Model.FileSystem.instance;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * 회원가입을 위한 절차가 구현된 클래스
 * @author 조은진
 * 2023.5.11 "최적화" 강대한
 */
public class SignUp {
    private FileSystem instance_ = instance();
    public void saveSignUpInfo(String userID, String password, String name) { //새로운 유저 정보 저장
        JSONArray jsonArr = instance_.getUser();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("ID", userID);
        jsonObj.put("Password", password);
        jsonObj.put("Name", name);
        jsonArr.add(jsonObj);
        instance_.setUser(jsonArr);
    }

    // 아이디 중복 체크 메서드
    public boolean checkDuplicatedID(String userID) {
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
    
    public boolean checkDuplicatedName(String userName) {
        boolean duplicated = false;
        JSONArray jsonArr = instance_.getUser();

        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("Name").equals(userName)) {
                duplicated = true;
            }
        }
        return duplicated;
    }
    
}
