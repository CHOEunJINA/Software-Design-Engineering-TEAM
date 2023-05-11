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
 * 글 데이터 입출력에 관한 클래스
 * @author 강대한
 * 2023.5.11 "최적화" 강대한
 */
public class Post {
    private FileSystem instance_ = instance();
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
