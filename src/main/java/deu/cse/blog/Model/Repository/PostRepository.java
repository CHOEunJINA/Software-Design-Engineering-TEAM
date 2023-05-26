/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

    public Boolean save(Post post) {
        try {
            JSONArray jsonArr = FileManager.get("postFile");

            // JSONArray에 추가
            jsonArr.add(post.toJson());
            FileManager.set("postFile", jsonArr);

            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Post targetPost, String postID) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("postFile");

            // JSONArray 다 돌면서 전달 받은 postId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Post로 바뀜
                Post post = Post.toEntity(item);

                // 전달 받은 postId값이랑 content 비교를 하는 것
                // 전달받은 postId와 content에 해당하는 사용자가 있는 경우
                if (post.getPostId().equals(postID)) {
                    // 해당 사용자 정보 삭제
                    jsonArr.remove(iter.nextIndex() - 1);
                    jsonArr.add(targetPost.toJson());
                    // JSON 데이터를 텍스트 파일에 저장
                    FileManager.set("postFile", jsonArr);
                    return true;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();          
        }
        return false;
        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
    }
    
    // 식별자로 기존 게시물 정보가 있는지 찾고 삭제하는 메소드
    public Post deleteById(String postId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("postFile");
            System.out.println("POSTID : " + postId);

            // JSONArray 다 돌면서 전달 받은 postId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Post로 바뀜
                Post post = Post.toEntity(item);

                // 전달 받은 postId값이랑 content 비교를 하는 것
                // 전달받은 postId와 content에 해당하는 사용자가 있는 경우
                if (post.getPostId().equals(postId)) {
                    // 해당 사용자 정보 삭제

                    jsonArr.remove(iter.nextIndex() - 1);

                    // JSON 데이터를 텍스트 파일에 저장
                    FileManager.set("postFile", jsonArr);

                    return post;

                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return null;
    }

    public ArrayList<Post> deleteByUserId(String userId) {
        try {
            // 기존 파일 로드
            System.out.println("USERID : " + userId);
            JSONArray jsonArrPost = fileManager_.get("postFile");
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

    public ArrayList<Post> findPostBySearch(String search) {
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            ArrayList<Post> resultPosts = new ArrayList();
            String[] texts = search.split(" ");

            for (String text : texts) {
                Iterator iter = jsonArr.iterator();
                while (iter.hasNext()) {
                    JSONObject item = (JSONObject) iter.next();
                    String[] words = ((String) item.get("Title")).split(" ");
                    for (String word : words) { // 제목에 해당 단어가 있는지 검사
                        if (word.equals(text)) {
                            Post post = Post.toEntity(item);
                            resultPosts.add(post);
                        }
                    }

                }
            }

            return resultPosts;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Post> findPostByName(String name) {
        try {
            JSONArray jsonArr = fileManager_.get("postFile");
            ArrayList<Post> resultPosts = new ArrayList();
            Iterator iter = jsonArr.iterator();
            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                if (((String) item.get("Author")).equals(name)) {
                    Post post = Post.toEntity(item);
                    resultPosts.add(post);
                }
            }

            return resultPosts;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 전체 글 불러오기
    public ArrayList<Post> findAll() {
        try {
            JSONArray jsonArr = FileManager.get("postFile");

            ArrayList<Post> posts = new ArrayList();
            Iterator iter = jsonArr.iterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                Post post = Post.toEntity(item);
                posts.add(post);
            }

            return posts;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
