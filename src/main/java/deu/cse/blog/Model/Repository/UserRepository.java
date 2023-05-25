/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import deu.cse.blog.Model.User;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Repository로부터 유저 데이터를 받아 요청을 처리하여 반환
 *
 * @author 조은진
 * 2023.5.24 "setUser, getUser 생성, Repository에게 전반적인 데이터 입출력 맡김" 강대한
 */
public class UserRepository {

    private static String currentUser = "user1";
    private static UserRepository userRepository_ = new UserRepository();
    private static Repository repository_ = Repository.repository();

    private UserRepository() {
    }

    public static UserRepository userRepository() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
        return userRepository_;
    }

    //사용자 정보 저장 메소드
    public Boolean save(User user) {
        System.out.println("User" + user);
        // 기존 파일 로드          
        JSONArray jsonArr = repository_.get("userFile");

        // JSONArray에 추가
        jsonArr.add(user.toJson());
        System.out.println("JSONARR : " + jsonArr);

        // JSON 데이터를 텍스트 파일에 저장
        repository_.set("userFile", jsonArr);

        return true;
    }

    /**
     * 저장 -> save 조회 -> findBy~~ 수정 -> update 삭제 -> deleteBy~~
     *
     * 전달 받은 id 값으로 파일에 저장되어 있는 사용자 정보를 찾아옴
     */
    // id로 기존 회원정보가 있는지 찾는 메소드
    public User findById(String id) {
        // 기존 파일 로드
        JSONArray jsonArr = repository_.get("userFile");

        // JSONArray 다 돌면서 전달 받은 id값이 있는지 확인하는 것
        // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
        Iterator iter = jsonArr.iterator();

        while (iter.hasNext()) {
            JSONObject item = (JSONObject) iter.next();
            // 읽어온 JSON이 User로 바뀜
            User user = User.toEntity(item);
            //User user= new User().toEntity(item);

            // 전달 받은 id값이랑 비교를 하는 것
            // 전달받은 id에 해당하는 사용자가 있는 경우
            if (user.getUserId().equals(id)) {
                // 해당 사용자 정보 반환
                return user;
            }
        }
        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return null;
    }
    
    public JSONArray getUserArray() {
        return repository_.get("userFile");
    }
    
    public int findIndex() {
        JSONArray jsonArr = repository_.get("userFile");
        int index = 0;
        for (Object obj : jsonArr) { //삭제된 글을 뺀 글 리스트를 새롭게 만든다. 
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("Name").equals(currentUser)) { //글 정보 확인
                break;
            }
            index++;
        }
        return index;
    }
    
    public void update(JSONArray jsonArr) {
        repository_.set("userFile", jsonArr);
    }
    
    public void setUser(String name) {
        currentUser = name;
    }

    public String getUser() {
        return currentUser;
    }
}
