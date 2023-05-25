package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Service.PostService;
import java.util.List;
import org.json.simple.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bluev
 */
public class PostPresenter {
    private PostService postService;

    public PostPresenter() {
        postService = new PostService();
    }
    public boolean save(String title, String post) {
        if (title.equals("") && post.equals("")) {
            return false;
        } else {
            postService.createPost(title, post);           
        }
        return true;
    }
    
    public boolean update(String title, String post, String time) {
        if (title.equals("") && post.equals("")) {
            return false;
        } else {
            postService.updatePost(title, post, time);           
        }
        return true;
    }
    
    public boolean delete(String title, String post, String time) {
        postService.deletePost(title, post, time);
        return true;
    }
    
    public String loadPost(String title, String user, String time) {

        return postService.findPost(title, user, time);
    }
    public List<String> getLatestPost() {
        List<String> list = postService.getLatestPost();
        return list;
    }
    
    public List<String> getMorePost() {
        List<String> list = postService.getMorePost();
        return list;
    }
    
    public String[] getMyPost() {
        List<String> list = postService.getMyPost();
        String[] stringList = new String[list.size()];
        int i = 0;
        for (String string : list) {
            stringList[i] = string;
            i++;
        }
        
        return stringList;
    }
}
