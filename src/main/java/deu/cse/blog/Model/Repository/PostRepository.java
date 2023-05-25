/*
<<<<<<< HEAD
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 조은진 "싱글턴 패턴 적용" - 강대한
 */
public class PostRepository {

    private static String postFile = "./post.json"; // 게시물 데이터
    private static PostRepository postRepository = new PostRepository();

    private PostRepository() {
    }

    //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
    public static PostRepository getInstance() {
        return postRepository;
    }

    //게시물 저장 메소드
    public Boolean save(Post post) {
        try {
            JSONArray jsonArr = FileManager.readFile(postFile);

            // JSONArray에 추가
            jsonArr.add(post.toJson());
            FileManager.writeFile(postFile, jsonArr);

            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    // 식별자로 기존 게시물 정보가 있는지 찾고 삭제하는 메소드
    public Post deleteById(String postId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.readFile(postFile);
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
                    FileManager.writeFile(postFile, jsonArr);

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

    // 식별자로 기존 댓글정보가 있는지 찾고 삭제하는 메소드
    public ArrayList deleteByUserId(String userId) {
        try {
            // 기존 파일 로드
            System.out.println("USERID : " + userId);
            JSONArray jsonArrPost = FileManager.readFile(postFile);
            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것

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
            FileManager.writeFile(postFile, jsonArrPost);

            return list;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 게시물 파일 들고옴
    public ArrayList<Post> findAll() {
        try {
            JSONArray jsonArr = FileManager.readFile(postFile);

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
