/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import static deu.cse.blog.Model.Model.instance;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * 로그인을 위한 절차가 구현된 모델
 * @author 조은진
 * 2023.5.11 "최적화" 강대한
 */
public class LoginModel {
    private Model instance_ = instance();

    public String authenticate(String username, String password) {
        String user = "";
        JSONArray jsonArr = instance_.getUser();
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("ID").equals(username) && jsonObj.get("Password").equals(password)) { //유저 정보 확인
                user = (String)jsonObj.get("Name"); //로그인된 유저 이름 저장
            }
        }
        return user;
    }
}
