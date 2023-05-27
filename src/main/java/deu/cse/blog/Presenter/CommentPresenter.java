/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Comment;
import deu.cse.blog.Model.Service.CommentService;
import java.util.ArrayList;

/**
 *
 * @author 조은진 댓글 presenter
 */
public class CommentPresenter {

    private CommentService commentService;

    public CommentPresenter() {

        this.commentService = new CommentService();
    }

    public Boolean register(String postId, String content, String author) {

        Boolean result = commentService.add(postId, content, author);

        return result;

    }

    public Boolean delete(String commentId) {

        String result = commentService.delete(commentId);

        if (result.equals("success")) {
            return true;
        } else if (result.equals("null")) {
            return false;
        }
        return null;

    }
    // 글에 등록된 댓글 찾기
    public ArrayList<Comment> findByPostId(String postId) {
        ArrayList<Comment> result = commentService.findByPostId(postId);
        return result;
    }

}
