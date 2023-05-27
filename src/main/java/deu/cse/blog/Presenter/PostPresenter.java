package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Service.PostService;
import deu.cse.blog.View.UserSession;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 강대한
 */
public class PostPresenter {
    private PostService postService;

    public PostPresenter() {
        postService = new PostService();
    }

     public Boolean register(String title, String content, String author) {
        if (title.equals("") && content.equals("")) {
            return false;
        } else {
            Boolean result = postService.add(title, content, author);  
            return result;
        }
    }
    
    public boolean update(String title, String content, String author, String postID) {
        if (title.equals("") && content.equals("")) {
            return false;
        } else {
            postService.updatePost(title, content, author, postID);           
        }
        return true;
    }
    
    public boolean delete(String postID) {
        return postService.delete(postID);
    }
    
    public ArrayList<Post> deleteByName(String name) {
        return postService.deleteByUserId(name);
    }
    //로그인된 유저의 모든 글 찾기
    public ArrayList<Post> getMyPost() {
        String name = UserSession.getSession();
        ArrayList<Post> result = postService.findPostByName(name);
        
        return result;
    }
    
    public ArrayList<Post> getResultPost(String search) {
        return postService.getResultPost(search);
    }
    
    public ArrayList<Post> findAll() {
        ArrayList<Post> result = postService.findAll();
        return result;
    }
}
