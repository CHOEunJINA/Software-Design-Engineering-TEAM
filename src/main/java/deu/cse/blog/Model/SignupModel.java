/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import static deu.cse.blog.Model.Model.instance;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * 회원가입을 위한 절차가 구현된 모델
 * @author 조은진
 * 2023.5.11 "최적화" 강대한
 */
public class SignupModel {
    private Model instance_ = instance();
    public String saveSignUpInfo(String id, String pwd, String name, boolean gender) { //새로운 유저 정보 저장
        String user = "";
        if (!checkDuplicatedID(id) && !checkDuplicatedName(name)) {
            JSONArray jsonArr = instance_.getUser();
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("ID", id);
            jsonObj.put("Password", pwd);
            jsonObj.put("Name", name);
            if (gender) {
                jsonObj.put("Gender", "male");
            } else {
                jsonObj.put("Gender", "female");
            }
            jsonArr.add(jsonObj);
            instance_.setUser(jsonArr);
            user = name;
        }
        return user;
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
