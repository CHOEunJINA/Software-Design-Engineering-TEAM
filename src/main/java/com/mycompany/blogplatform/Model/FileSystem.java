package com.mycompany.blogplatform.Model;
/**
 *
 * @author bluev
 */
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;

public class FileSystem {
  public static FileSystem instance() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 정적 함수로 객체가 생성되어 있는지 확인 후 생성
      return instance_;
  }
  private static FileSystem instance_ = new FileSystem();
  
  private String query;
  private FileSystem() {}
  public void setQuery(String receivedQuery) {
      query = receivedQuery;
  }
  public static Object getPost() {
      JSONParser parser = new JSONParser();
      Object obj = new Object();
      try {
          obj = parser.parse(new FileReader("C:\\Users\\bluev\\NetBeansProjects\\BlogPlatform\\src\\main\\java\\com\\mycompany\\blogplatform\\data\\post.json")); //Json 파일로 저장된 글 가져오기        
      } catch (ParseException ex) {
            ex.printStackTrace();
      } catch (IOException e) {
            e.printStackTrace();
      }
      return obj;
  }
  public static void setPost() {
  }
  public static JSONArray getUser() {
      Object obj = new Object();
      JSONParser parser = new JSONParser();
      JSONArray jsonArr = new JSONArray();
      try {
          FileReader reader = new FileReader("C:\\Users\\bluev\\NetBeansProjects\\BlogPlatform\\src\\main\\java\\com\\mycompany\\blogplatform\\data\\user.json");
          obj = parser.parse(reader);
          JSONObject jsonObj = (JSONObject) obj;
          jsonArr = (JSONArray)jsonObj.get("data");
          reader.close();
      } catch (IOException e){
          e.printStackTrace();
      } catch (ParseException e) {
          e.printStackTrace();
      }
      return jsonArr;
  }
  public static void setUser(JSONArray jsonArr) {
      try {
          FileWriter file = new FileWriter("C:\\Users\\bluev\\NetBeansProjects\\BlogPlatform\\src\\main\\java\\com\\mycompany\\blogplatform\\data\\user.json");
          file.write(jsonArr.toJSONString());
          file.flush();
          file.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
