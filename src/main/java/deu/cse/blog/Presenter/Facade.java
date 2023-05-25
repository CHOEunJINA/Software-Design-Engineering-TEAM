/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Service.CommentService;
import deu.cse.blog.Model.Service.PostService;
import deu.cse.blog.Model.Service.UserService;
import java.util.ArrayList;

/**
 *
 * @author 조은진 // Facade 클래스 구현
 */
public class Facade {

    UserService userService = new UserService();
    PostService postService = new PostService();
    CommentService commentService = new CommentService();

    public Facade() {
    }

    // 회원탈퇴시 처리되는 메소드
    public Boolean deleteUser(String userId) {

        boolean success = userService.deleteUser();
        ArrayList<Post> posts = postService.deleteByUserId(userId); // userId로 게시물 지움
        Boolean result2 = commentService.deleteByPostId(posts);

        // commentService에 userId로 사용자가 단 댓글을 모두 찾아오는 메소드
        String result3 = commentService.delete(userId); // userId로 댓글 지움
        if (success && result2 == true && result3.equals("success")) {
            return true;
        } else {
            return false;
        }

    }

}
