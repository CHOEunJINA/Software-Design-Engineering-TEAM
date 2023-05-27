/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Post;
import deu.cse.blog.Model.Repository.PostRepository;
import deu.cse.blog.Model.Repository.UserRepository;
import java.util.ArrayList;

/**
 *
 * @author 강대한
 */
public class PostService {

    private PostRepository postRepository_ = PostRepository.postRepository();
    private UserRepository userRepository_ = UserRepository.userRepository();

    
    public Boolean add(String title, String content, String author) {

        Post post = new Post.Builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        // save 결과 리턴
        return postRepository_.save(post);
    }

    public boolean updatePost(String title, String content, String author, String postID) {
        Post post = new Post.Builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        return postRepository_.update(post, postID);
    }

    
    public boolean delete(String postId) {

        Post target = postRepository_.deleteById(postId);

        // commentId, postId로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return false;
        }

        return true;
    }
    
    public ArrayList<Post> deleteByUserId(String userId) {

        return postRepository_.deleteByUserId(userId);

    }
    
    public ArrayList<Post> findPostByName(String name) {
        ArrayList<Post> list = postRepository_.findPostByName(name);

        return list;
    }
    // 검색 결과 찾기
    public ArrayList<Post> getResultPost(String search) {
        return postRepository_.findPostBySearch(search);
    }
    // 모든 게시물 찾기
    public ArrayList<Post> findAll() {

        ArrayList<Post> target = postRepository_.findAll();

        return target;

    }
}
