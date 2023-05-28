/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import deu.cse.blog.Model.User;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Repository로부터 유저 데이터를 받아 요청을 처리하여 반환
 *
 * @author 조은진 2023.5.24 "setUser, getUser 생성, Repository에게 전반적인 데이터 입출력 맡김" 강대한
 */
public class UserRepository {

    private static String currentUser = ""; // 로그인된 유저 이름
    //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 객체를 이른 초기화로 생성
    private static UserRepository userRepository_ = new UserRepository();
    private static FileManager fileManager_ = FileManager.fileManager();
    private static String userFile = "./user.json"; // 유저 데이터
    //생성자를 외부에서 접근 못하도록

    private UserRepository() {
        System.out.println("userRepository 객체 생성");
    }

    //정적 메서드를 통해 객체 반환
    public static UserRepository userRepository() {
        System.out.println("userRepository 객체 반환");
        return userRepository_;
    }

    //사용자 정보 저장 메소드
    public boolean save(User user) {
        System.out.println("User" + user);
        try {
            // 기존 파일 로드          
            JSONArray jsonArr = fileManager_.get(userFile);

            // JSONArray에 추가
            jsonArr.add(user.toJson());
            System.out.println("JSONARR : " + jsonArr);

            // JSON 데이터를 파일에 저장
            fileManager_.set(userFile, jsonArr);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 저장 -> save 조회 -> findBy~~ 수정 -> update 삭제 -> deleteBy~~
     *
     * 전달 받은 id 값으로 파일에 저장되어 있는 사용자 정보를 찾아옴
     */
    // id로 기존 회원정보가 있는지 찾는 메소드
    public User findById(String id) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = fileManager_.get(userFile);

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

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //유저 이름을 기준으로 정보 찾기
    public User findByName(String name) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = fileManager_.get(userFile);

            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            Iterator iter = jsonArr.iterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 User로 바뀜
                User user = User.toEntity(item);
                //User user= new User().toEntity(item);

                // 전달 받은 name값이랑 비교를 하는 것
                if (user.getName().equals(name)) {
                    // 해당 사용자 정보 반환
                    return user;
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete() {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get(userFile);

            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 User로 바뀜
                User user = User.toEntity(item);

                // 로그인된 유저 정보 찾기
                if (user.getName().equals(currentUser)) {
                    // 해당 사용자 정보 삭제

                    jsonArr.remove(iter.nextIndex() - 1);

                    // JSON 데이터를 파일에 저장
                    FileManager.set(userFile, jsonArr);

                    return true;

                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    // 유저 리스트 업데이트
    public boolean update(User targetUser, String name) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get(userFile);

            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();
            // 유저 이름이 바뀌지 않았으면
            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Post로 바뀜
                User user = User.toEntity(item);
                if (user.getName().equals(currentUser)) {
                    // 해당 사용자 정보 삭제
                    jsonArr.remove(iter.nextIndex() - 1);
                    jsonArr.add(targetUser.toJson());
                    // JSON 데이터를 텍스트 파일에 저장
                    FileManager.set(userFile, jsonArr);
                    currentUser = "";
                    return true;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 로그인된 유저 변경
    public void setUser(String name) {
        currentUser = name;
    }

    // 로그인된 유저 이름 반환
    public String getUser() {
        return currentUser;
    }
}
