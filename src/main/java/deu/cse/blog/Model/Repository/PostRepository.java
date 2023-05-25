/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Repository로부터 유저 데이터를 받아 요청을 처리하여 반환
 *
 * @author 강대한
 */
public class PostRepository {

    private static PostRepository postRepository_ = new PostRepository();
    private static FileManager fileManager_ = FileManager.fileManager();

    private PostRepository() {
    }

    public static PostRepository postRepository() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
        return postRepository_;
    }

    public boolean create(JSONObject jsonObj) {
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            jsonArr.add(jsonObj);
            fileManager_.set("postFile", jsonArr);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false; // Boolean인데 null 던질 필요는 없음 
        }
    }

    public boolean update(JSONArray jsonArr) {
        try {
            fileManager_.set("postFile", jsonArr);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false; // Boolean인데 null 던질 필요는 없음 
        }
    }

    public ArrayList deleteByUserId(String userId) {
        try {
            // 기존 파일 로드
            System.out.println("USERID : " + userId);
            JSONArray jsonArrPost = fileManager_.get("postFile");
            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArrPost.listIterator();
            ArrayList<Post> list = new ArrayList();

            for (int i = jsonArrPost.size() - 1; i >= 0; i--) {
                JSONObject item = (JSONObject) jsonArrPost.get(i);
                Post post = Post.toEntity(item);

                if (post.getAuthor().equals(userId)) {

                    list.add(post);
                    jsonArrPost.remove(i);
                }
            }

            // JSON 데이터를 텍스트 파일에 저장
            fileManager_.set("postFile", jsonArrPost);

            return list;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getPostArray() {
        try {
            return fileManager_.get("postFile");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int findIndex(String title, String user, String time) {
        int index = 0;
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            for (Object obj : jsonArr) { // 해당 글 인덱스 찾기 
                JSONObject jsonObj = (JSONObject) obj;
                if (jsonObj.get("Title").equals(title) && jsonObj.get("User").equals(user)) { //글 정보 확인
                    List<String> timeList = new ArrayList<String>();
                    timeList = (List<String>) jsonObj.get("TimeList");
                    int latestIndex = timeList.size() - 1;
                    if (timeList.get(latestIndex).equals(time)) {
                        break;
                    }
                }
                index++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return index;
    }

    public List<Integer> findUserPostIndex(String user) {
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            int index = 0;
            List<Integer> indexList = new ArrayList<Integer>();
            for (Object obj : jsonArr) { //삭제된 글을 뺀 글 리스트를 새롭게 만든다. 
                JSONObject jsonObj = (JSONObject) obj;
                if (jsonObj.get("User").equals(user)) { //글 정보 확인
                    indexList.add(index);
                }
                index++;
            }
            return indexList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray findPostBySearch(String text) {
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            JSONArray resultArr = new JSONArray();
            for (Object obj : jsonArr) {
                JSONObject jsonObj = (JSONObject) obj;
                String[] words = ((String) jsonObj.get("Title")).split(" ");
                for (String word : words) { // 제목에 해당 단어가 있는지 검사
                    if (word.equals(text)) {
                        resultArr.add(jsonObj);
                    }
                }
            }
            return resultArr;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
