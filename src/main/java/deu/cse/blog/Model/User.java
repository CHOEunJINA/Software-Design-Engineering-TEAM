/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model;

import org.json.simple.JSONObject;

/**
 * user.json -> entity형태로 생성
 *
 * @author 조은진
 */
public class User {

    private String userId;
    private String password;
    private String name;
    private String gender;

    public User() {

    }

    public User(String userId, String gender, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.gender = gender;
    }

    //User를 파일에 저장하기 위해 JSON형태로 바꾸는 메소드
    public JSONObject toJson() {

        JSONObject userInfo = new JSONObject();
        userInfo.put("ID", this.userId);
        userInfo.put("Gender", this.gender);
        userInfo.put("Password", this.password);
        userInfo.put("Name", this.name);

        return userInfo;
    }

    //JSON을 User 타입으로 변환하는 메소드
    public static User toEntity(JSONObject json) {
        return new User(
                (String) json.get("ID"),
                (String) json.get("Gender"),
                (String) json.get("Password"),
                (String) json.get("Name")
        );
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getUserId() {
        return userId;

    }

    public void setUserId() {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender() {
        this.gender = gender;
    }

}
