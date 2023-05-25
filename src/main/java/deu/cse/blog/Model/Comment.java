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
 * @author 조은진 댓글 -> entity형태로 생성 Builder패턴 적용
 */
public class Comment {

    private String commentId; // 댓글의 고유 식별자
    private String postId; // 게시물 식별자
    private String content; // 댓글의 내용
    private String author; // 작성자

    public Comment() {

    }

    public Comment(Builder builder) {
        if (builder.commentId == null) {
            this.commentId = UUID.randomUUID().toString();
        } else {
            this.commentId = builder.commentId;
        }

        this.postId = builder.postId;
        this.content = builder.content;
        this.author = builder.author;

    }

    public String getCommentId() {
        return commentId;
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

        private String commentId;
        private String postId;
        private String content;
        private String author;

        public Builder() {

        }

        public Comment build() {
            return new Comment(this);
        }

        public Builder commentId(String commentId) {
            this.commentId = commentId;
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

    //Comment를 파일에 저장하기 위해 JSON형태로 바꾸는 메소드
    public JSONObject toJson() {

        JSONObject userInfo = new JSONObject();
        userInfo.put("CommentId", this.commentId);
        userInfo.put("PostId", this.postId);
        userInfo.put("Content", this.content);
        userInfo.put("Author", this.author);

        return userInfo;
    }

    //JSON을 Builder 타입으로 변환하는 메소드
    public static Comment toEntity(JSONObject json) {
        return new Comment.Builder()
                .commentId((String) json.get("CommentId"))
                .postId((String) json.get("PostId"))
                .content((String) json.get("Content"))
                .author((String) json.get("Author"))
                .build();
    }

}
