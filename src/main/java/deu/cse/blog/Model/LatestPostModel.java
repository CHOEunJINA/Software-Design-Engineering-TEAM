/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import static deu.cse.blog.Model.Model.instance;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bluev
 */
public class LatestPostModel {
    private Model instance_ = instance();
    public List getLatestPost() {
      List<String> list = new ArrayList<>();
      list.add("<최신 글>");
      JSONArray jsonArr = instance_.getPost();
      
      for (int i=1; i <= 5; i++) { // 최신 글의 제목과 작성자를 가져온다.
        String temp = "";           
        JSONObject jsonObj = (JSONObject)jsonArr.get(jsonArr.size() - i);
        temp = jsonObj.get("title") + " by " + jsonObj.get("username");
        list.add(temp);
      }
      return list;
    }
}
