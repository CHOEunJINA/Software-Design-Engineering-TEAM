/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import deu.cse.blog.Model.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import org.json.simple.JSONObject;

/**
 *
 * @author 조은진
 */
public class UserRepository {

    private static String userFile = "./user.json"; // 유저 데이터
    public JSONParser parser = new JSONParser();

    //사용자 정보 저장 메소드
    public Boolean save(User user) {
        try {
            // 기존 파일 로드
            FileReader reader = new FileReader(userFile, Charset.forName("utf-8"));
            Object obj = parser.parse(reader);

            JSONArray jsonArr = (JSONArray) obj;
            reader.close();

            // JSONArray에 추가
            jsonArr.add(user.toJson());

            // JSON 데이터를 텍스트 파일에 저장
            FileWriter fileWriter = new FileWriter(userFile);
            fileWriter.write(jsonArr.toString());

            // 성공하면 true 리턴
            System.out.println(jsonArr);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            // 실패하면 false 리턴
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
            FileReader reader = new FileReader(userFile, Charset.forName("utf-8"));
            Object obj = parser.parse(reader);

            JSONArray jsonArr = (JSONArray) obj;
            reader.close();

            // JSONArray 다 돌면서 전달 받은 id값이 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            Iterator iter = jsonArr.iterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 User로 바뀜
                User user = User.toEntity(item);

                // 전달 받은 id값이랑 비교를 하는 것
                // 전달받은 id에 해당하는 사용자가 있는 경우
                if (user.getUserId().equals(id)) {
                    // 해당 사용자 정보 반환
                    return user;
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return null;
    }


}
