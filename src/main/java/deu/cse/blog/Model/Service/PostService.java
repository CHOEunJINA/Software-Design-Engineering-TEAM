/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Repository.PostRepository;
import deu.cse.blog.Model.Repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 강대한
 */
public class PostService {

    private PostRepository postRepository_ = PostRepository.postRepository();
    private UserRepository userRepository_ = UserRepository.userRepository();

    public void createPost(String title, String post) {
        JSONObject jsonObj = new JSONObject();
        String user = userRepository_.getUser();
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        List<String> timeList = new ArrayList();
        timeList.add(dateNow + " " + timeNow);
        
        jsonObj.put("Title", title);
        jsonObj.put("Post", post);
        jsonObj.put("User", user);
        jsonObj.put("TimeList", timeList);

        postRepository_.create(jsonObj);
    }

    public void updatePost(String title, String post, String time) {
        JSONArray jsonArr = postRepository_.getPostArray();
        JSONArray newJsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        String user = userRepository_.getUser();

        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        jsonObj.put("Title", title);
        jsonObj.put("Post", post);
        jsonObj.put("User", user);

        int index = postRepository_.findIndex(title, user, time);
        int i = 0;
        for (Object obj : jsonArr) {
            JSONObject jsonObj2 = (JSONObject) obj;
            if (i == index) {
                List<String> timeList = (List<String>) jsonObj2.get("TimeList");
                timeList.add(dateNow + " " + timeNow);
                jsonObj.put("TimeList", timeList);
                newJsonArr.add(jsonObj);
                i++;
                continue;
            }
            newJsonArr.add(jsonObj2);
            i++;
        }
        postRepository_.update(newJsonArr);
    }

    public void deletePost(String title, String post, String time) {
        JSONArray jsonArr = postRepository_.getPostArray();
        String user = userRepository_.getUser();
        
        int index = postRepository_.findIndex(title, user, time);
        JSONArray newJsonArr = new JSONArray();
        int i = 0;
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            if (i == index) {
                i++;
                continue;
            }
            newJsonArr.add(jsonObj);
            i++;
        }
        postRepository_.update(newJsonArr);
    }

    public String findPost(String title, String user, String time) {
        JSONArray jsonArr = postRepository_.getPostArray();
        int index = postRepository_.findIndex(title, user, time);
        Object obj = jsonArr.get(index);
        JSONObject jsonObj = (JSONObject) obj;
        String post = (String) jsonObj.get("Post");
        return post;
    }

    public List<String> getMorePost() {
        List<String> list = new ArrayList<>();
        JSONArray jsonArr = postRepository_.getPostArray();

        for (Object obj : jsonArr) { // 
            String temp = "";
            JSONObject jsonObj = (JSONObject) obj;
            List<String> timeList = (List<String>) jsonObj.get("TimeList");
            int latestIndex = timeList.size() - 1;
            String time = timeList.get(latestIndex);
            temp = jsonObj.get("Title") + "," + jsonObj.get("User") + "," + time;
            list.add(temp);
        }
        return list;
    }

    public List<String> getLatestPost() {
        List<String> list = new ArrayList<>();
        JSONArray jsonArr = postRepository_.getPostArray();

        for (int i = 1; i <= 5; i++) { // 최신 글의 제목과 작성자를 가져온다.
            String temp = "";
            JSONObject jsonObj = (JSONObject) jsonArr.get(jsonArr.size() - i);
            List<String> timeList = (List<String>) jsonObj.get("TimeList");
            int latestIndex = timeList.size() - 1;
            String time = timeList.get(latestIndex);
            temp = jsonObj.get("Title") + "," + jsonObj.get("User") + "," + time;
            list.add(temp);
        }
        return list;
    }
    
    public List<String> getMyPost() {
        String user = userRepository_.getUser();
        List<String> list = new ArrayList<>();
        JSONArray jsonArr = postRepository_.getPostArray();
        List<Integer> indexList = postRepository_.findUserPostIndex(user);
        int i = 0;
        int k = 0;
        int index = indexList.get(k);
        for (Object obj : jsonArr) { // 
            if (i == index) {
                String temp = "";
                JSONObject jsonObj = (JSONObject) obj;
                List<String> timeList = (List<String>) jsonObj.get("TimeList");
                int latestIndex = timeList.size() - 1;
                String time = timeList.get(latestIndex);
                temp = jsonObj.get("Title") + "," + jsonObj.get("User") + "," + time;
                list.add(temp);
                k++;
                if (k == indexList.size()) {
                    break;
                }
                index = indexList.get(k);
            }
            i++;
        }
        return list;
    }
}
