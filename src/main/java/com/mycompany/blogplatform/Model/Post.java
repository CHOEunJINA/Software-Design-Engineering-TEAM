/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blogplatform.Model;

import static com.mycompany.blogplatform.Model.FileSystem.instance;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bluev
 */
public class Post {
    private FileSystem instance_ = instance();
    public List getLatestPost() {
      List<String> list = new ArrayList<>();
      list.add("<최신 글>");
      Object obj = instance_.getPost();
      JSONObject jsonObj = (JSONObject) obj;
      JSONArray jsonArr = (JSONArray)jsonObj.get("data");
      for (int i=0; i < 5; i++) { // 최신 글의 제목과 작성자를 가져온다.
        String temp = "";           
        JSONObject jObj = (JSONObject)jsonArr.get(i);
        temp = jsonObj.get("title") + " by " + jObj.get("username");
        list.add(temp);
      }
      return list;
    }
}
