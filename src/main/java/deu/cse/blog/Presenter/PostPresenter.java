/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Service.PostService;
import java.util.ArrayList;

/**
 *
 * @author 조은진 게시물 presenter
 */
public class PostPresenter {

    private PostService postService;

    public PostPresenter() {

        this.postService = new PostService();
    }

    public Boolean register(String title, String content, String author) {

        Boolean result = postService.add(title, content, author);

        return result;

    }

    public Boolean delete(String postId) {

        String result = postService.delete(postId);

        if (result.equals("success")) {
            return true;
        } else if (result.equals("null")) {
            return false;
        }
        return null;

    }

    public Boolean deleteByUserId(String userId) {

        ArrayList result = postService.deleteByUserId(userId);

        if (result.equals("success")) {
            return true;
        } else if (result.equals("null")) {
            return false;
        }

        return true;
    }

    public ArrayList<Post> findAll() {
        ArrayList<Post> result = postService.findAll();
        return result;
    }

}
