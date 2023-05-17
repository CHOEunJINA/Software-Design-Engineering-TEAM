/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model;

import static deu.cse.blog.Model.Model.instance;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bluev
 */
public class SavePostModel {
    private Model instance_ = instance();
    public boolean savePost(String title, String post, String user) {
        JSONArray jsonArr = instance_.getPost();
        JSONObject jsonObj = new JSONObject();
        JSONArray comments = new JSONArray();
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        List<String> timeList = new ArrayList();
        timeList.add(dateNow + " " + timeNow);
        jsonObj.put("Title", title);
        jsonObj.put("Post", post);
        jsonObj.put("User", user);
        jsonObj.put("TimeList", timeList);
        jsonObj.put("Comments", comments);
        jsonArr.add(jsonObj);
        instance_.setPost(jsonArr);
        return true;
    }
}
