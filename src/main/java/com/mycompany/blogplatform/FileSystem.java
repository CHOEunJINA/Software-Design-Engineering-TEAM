package com.mycompany.blogplatform;
/**
 *
 * @author bluev
 */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileSystem {
  public static FileSystem instance() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 정적 함수로 객체가 생성되어 있는지 확인 후 생성
      if(instance_ == null) {
          instance_ = new FileSystem();
      }
      return instance_;
  }
  private static FileSystem instance_;
  private FileSystem() {}
  public List getLatestPost() {
      List<String> list = new ArrayList<>();
      list.add("<최신 글>");
      JSONParser parser = new JSONParser();
      try {
          Object obj = parser.parse(new FileReader("C:\\Users\\bluev\\NetBeansProjects\\BlogPlatform\\src\\main\\java\\com\\mycompany\\blogplatform\\data\\post.json"));
          JSONArray jsonArr = (JSONArray) obj;
          for (int i=0; i < 5; i++) { // 최신 글의 제목과 작성자를 가져온다.
            String temp = "";           
            JSONObject jsonObj = (JSONObject)jsonArr.get(i);
            temp = jsonObj.get("title") + " by " + jsonObj.get("username");
            list.add(temp);          
          }
      } catch (ParseException ex) {
            ex.printStackTrace();
      } catch (IOException e) {
            e.printStackTrace();
      }      
      return list;
  }

}
