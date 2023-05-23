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
public class UpdatePost {
    private Model instance_ = instance();
        public void updatePost(String title, String user, String date) {
            JSONArray jsonArr = instance_.getPost();
            JSONArray newJsonArr = new JSONArray();
            for (Object obj : jsonArr) { //삭제된 글을 뺀 글 리스트를 새롭게 만든다. 
                JSONObject jsonObj = (JSONObject) obj;
                if (jsonObj.get("Title").equals(title) && jsonObj.get("User").equals(user)) { //글 정보 확인
                    List<String> timeList = new ArrayList<String>();
                    timeList = (List<String>) jsonObj.get("TimeList");
                    int latestIndex = timeList.size() - 1;
                    if (timeList.get(latestIndex).equals(date)) {
                        
                    }
                }
                newJsonArr.add(jsonObj);
            }
            instance_.setPost(newJsonArr);
        }
}
