/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model;

import org.json.simple.JSONObject;

/**
 * @author 조은진 
 * user.json -> entity형태로 생성 Builder패턴 적용
 *
 */
public class User {

    private String userId;
    private String password;
    private String name;
    private String gender;

    public User() {

    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.gender = builder.gender;
        this.name = builder.name;
        
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public static class Builder {

        private String userId;
        private String password;
        private String name;
        private String gender;

        public Builder() {

        }

        public User build() {
            return new User(this);
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

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

    //JSON을 Builder 타입으로 변환하는 메소드
    public static User toEntity(JSONObject json) {
        return new User.Builder()
                .userId((String) json.get("ID"))
                .password((String) json.get("Password"))
                .name((String) json.get("Name"))
                .gender((String) json.get("Gender"))
                .build();
    }

}
