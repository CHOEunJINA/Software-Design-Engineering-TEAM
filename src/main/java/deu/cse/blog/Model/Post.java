/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model;

import java.util.UUID;
import org.json.simple.JSONObject;

/**
 *
 * @author 조은진
 * 게시물 -> entity형태로 생성 Builder패턴 적용
 */
public class Post {

    private String title; // 게시물 제목
    private String postId; // 게시물 식별자
    private String content; // 게시물의 내용
    private String author; // 작성자

    public Post() {

    }

    public Post(Builder builder) {
        if(builder.postId == null){
            this.postId= UUID.randomUUID().toString();
        } else {
            this.postId = builder.postId;
        }
        
        this.title = builder.title;
        
        this.content = builder.content;
        this.author = builder.author;

    }

    public String getTitle() {
        return title;
    }

    public String getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public static class Builder {

        private String title;
        private String postId;
        private String content;
        private String author;

        public Builder() {

        }

        public Post build() {
            return new Post(this);
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder postId(String postId) {
            this.postId = postId;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }


    }

    //Post를 파일에 저장하기 위해 JSON형태로 바꾸는 메소드
    public JSONObject toJson() {

        JSONObject userInfo = new JSONObject();
        userInfo.put("Title", this.title);
        userInfo.put("PostId", this.postId);
        userInfo.put("Content", this.content);
        userInfo.put("Author", this.author);

        return userInfo;
    }

    //JSON을 Builder 타입으로 변환하는 메소드
    public static Post toEntity(JSONObject json) {
        return new Post.Builder()
                .title((String) json.get("Title"))
                .postId((String) json.get("PostId"))
                .content((String) json.get("Content"))
                .author((String) json.get("Author"))
                .build();
    }
}
