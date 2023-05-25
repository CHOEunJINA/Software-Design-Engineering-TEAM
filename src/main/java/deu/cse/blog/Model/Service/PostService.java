/*
<<<<<<< HEAD
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Repository.PostRepository;
import java.util.ArrayList;

/**
 *
 * @author 조은진
 */
public class PostService {

    private PostRepository postRepository=PostRepository.getInstance();
    

    public Boolean add(String title, String content, String author) {

        Post post = new Post.Builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        // save 결과 리턴
        return postRepository.save(post);
    }

    public String delete(String postId) {

        Post target = postRepository.deleteById(postId);

        // commentId, postId로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return "null";
        }

        return "success";
    }

    // userId로 게시물 지우기
    public ArrayList deleteByUserId(String userId) {
        System.out.println("PostRepository deleteByUserId" + userId);

        return postRepository.deleteByUserId(userId);

    }

    // ArrayList를 다 찾아옴
    public ArrayList<Post> findAll() {

        ArrayList<Post> target = postRepository.findAll();

        return target;

    }

}
