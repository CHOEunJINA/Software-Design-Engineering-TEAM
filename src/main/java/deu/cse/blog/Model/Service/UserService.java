/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Repository.UserRepository;
import deu.cse.blog.Model.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 조은진
 * 2023.5.24 "currentUser 메서드 생성" 강대한
 */
public class UserService {

    private UserRepository userRepository_ = UserRepository.userRepository();

    public Boolean signUp(String id, String name, String password, String passwordConfirm, String gender) {
        // 전달 받은 id로 유저 검색
        User target = userRepository_.findById(id);
        System.out.println("TARGET SignUP: "+target);

        // 이미 있는 ID 정보
        if (target != null) {
            return null;
        }

        // ID 정보가 없으면 userRepository한테 User정보 저장 요청
        // Repository한테 요청하기 위해서 매개변수를 User 타입으로 변경
        User user = new User.Builder()
                .userId(id)
                .password(password)
                .name(name)
                .gender(gender)
                .build();
        
        // save 결과 리턴
        return userRepository_.save(user);
    } //회원가입시 Repository에 요청하기 -> 이미 있는 회원인지 확인을 한다.

    public Boolean login(String id, String password) {

        // 로그인한 사용자의 정보를 id를 통해 가져옴
        User target = userRepository_.findById(id);
        System.out.println("TARGET Login : "+target);
        // id로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return null;
        }
        
        // 입력받은 비밀번호랑 저장된 비밀번호 다르면 null 리턴
        if (!target.getPassword().equals(password)) {

            return null;
        }
        userRepository_.setUser(target.getName());
        return true;
    }
    
    public boolean logOut() {
        userRepository_.setUser("");
        if (userRepository_.getUser().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void deleteUser() {
        JSONArray jsonArr = userRepository_.getUserArray();
        
        int index = userRepository_.findIndex();
        JSONArray newJsonArr = new JSONArray();
        int i = 0;
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (i == index) {
                i++;
                continue;
            }
            newJsonArr.add(jsonObj);
            i++;
        }
        userRepository_.update(newJsonArr);
    }
    
    public JSONObject loadUserInfo() {
        JSONArray jsonArr = userRepository_.getUserArray();
        int index = userRepository_.findIndex();
        JSONObject jsonObj = (JSONObject) jsonArr.get(index);
        return jsonObj;
    }
    
    public void updateUser(String id, String name, String password, String gender) {
        JSONArray jsonArr = userRepository_.getUserArray();
        JSONArray newJsonArr = new JSONArray();

        User user = new User.Builder()
                .userId(id)
                .password(password)
                .name(name)
                .gender(gender)
                .build();
        int index = userRepository_.findIndex();
        int i = 0;
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (i == index) {
                newJsonArr.add(user.toJson());
                i++;
                continue;
            }
            newJsonArr.add(jsonObj);
            i++;
        }
        userRepository_.update(newJsonArr);
    }
    
    public String currentUser() {
        return userRepository_.getUser();
    }
}