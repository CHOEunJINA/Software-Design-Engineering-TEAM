/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;
/**
 * 싱글턴 패턴을 적용한 데이터 입출력을 관리하는 모델
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.JSONArray;

public class Model {
  public static Model instance() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
      return instance_;
  }
  private static Model instance_ = new Model();
  public static String user = "";
  private static String postFile = "./post.json"; // 작성된 글 데이터
  private static String userFile = "./user.json"; // 유저 데이터
  private Model() {}

  public static JSONArray getPost() {
      JSONParser parser = new JSONParser();
      Object obj = new Object();
      JSONArray jsonArr = new JSONArray();
      try {
          obj = parser.parse(new FileReader(postFile, Charset.forName("utf-8"))); //Json 파일로 저장된 글 가져오기
          JSONObject jsonObj = (JSONObject) obj;
          jsonArr = (JSONArray)jsonObj.get("data");
      } catch (ParseException ex) {
            ex.printStackTrace();
      } catch (IOException e) {
            e.printStackTrace();
      }
      return jsonArr;
  }
  public static void setPost(JSONArray jsonArr) {
      try {
          FileWriter file = new FileWriter(postFile, Charset.forName("utf-8"));
          file.write(jsonArr.toJSONString());
          file.flush();
          file.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

}
