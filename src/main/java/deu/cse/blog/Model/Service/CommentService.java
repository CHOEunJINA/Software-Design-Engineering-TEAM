/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Comment;
import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Repository.CommentRepository;
import java.util.ArrayList;

/**
 *
 * @author 조은진
 *
 */
public class CommentService {

    private CommentRepository commentRepository_ = CommentRepository.getInstance();
    //댓글 저장
    public Boolean add(String postId, String content, String author) {

        Comment comment = new Comment.Builder()
                .postId(postId)
                .content(content)
                .author(author)
                .build();

        // save 결과 리턴
        return commentRepository_.save(comment);
    }
    
    
    // 식별자를 통해 삭제
    public String delete(String commentId) {

        Comment target = commentRepository_.deleteById(commentId);

        // commentId 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return "null";
        }

        return "success";
    }
    // 작성자를 통해 삭제
    public boolean deleteByUserId(String userId) {

        return commentRepository_.deleteByUserId(userId);
    }
    /**
     * 게시물 하나에 대한 댓글을 지움
     *
     * @param postId
     * @return
     */
    public String deleteByPostId(String postId) {

        Boolean target = commentRepository_.deleteByPostId(postId);

        //postId로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return "null";
        }

        return "success";
    }

    /**
     * 게시물 여러개에 대한 댓글을 지움
     *
     * @param posts
     * @return
     */
    //Overloading
    public Boolean deleteByPostId(ArrayList<Post> posts) {

        for (Post post : posts) {
            deleteByPostId(post.getPostId());
        }

        return true;

    }
    
    // postId를 통해 게시물의 댓글 정보 가져옴
    public ArrayList<Comment> findByPostId(String postId) {

        ArrayList<Comment> target = commentRepository_.findByPostId(postId);

        return target;

    }
}
