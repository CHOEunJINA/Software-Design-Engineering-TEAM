/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import static deu.cse.blog.Model.Model.instance;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * 회원 탈퇴를 구현한 모델
 * @author 강대한
 * 2023.5.11 "deleteUser 구현" 강대한
 */
public class DeleteUserModel {
    private Model instance_ = instance();
    public void deleteUser(String name) {
        JSONArray jsonArr = instance_.getUser();
        JSONArray newJsonArr = new JSONArray();
        for (Object obj : jsonArr) { //탈퇴 유저를 뺀 유저 리스트를 새롭게 만든다. 
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("Name").equals(name)) { //유저 정보 확인
                continue;
            } else {
                newJsonArr.add(jsonObj);
            }   
        }
        instance_.setUser(newJsonArr);
    }
}
