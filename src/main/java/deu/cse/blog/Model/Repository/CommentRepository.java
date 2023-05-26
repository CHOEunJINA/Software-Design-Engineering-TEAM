/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import deu.cse.blog.Model.Comment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 조은진 댓글 관리 - 싱글턴 패턴 적용
 */
public class CommentRepository {

    private static CommentRepository commentRepository_ = new CommentRepository();

    private CommentRepository() {
    }

    //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
    public static CommentRepository getInstance() {
        return commentRepository_;
    }

    //댓글 저장 메소드
    public Boolean save(Comment comment) {
        try {
            JSONArray jsonArr = FileManager.get("commentFile");

            // JSONArray에 추가
            jsonArr.add(comment.toJson());
            // JSON 데이터를 텍스트 파일에 저장
            FileManager.set("commentFile", jsonArr);

            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false; // Boolean인데 null 던질 필요는 없음 ㅇㅇㅇ
        }
    }

    // 식별자로 기존 댓글정보가 있는지 찾고 삭제하는 메소드
    public Comment deleteById(String commentId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("commentFile");

            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Comment로 바뀜
                Comment comment = Comment.toEntity(item);

                // 전달 받은 commentId값이랑 postId 비교를 하는 것
                // 전달받은 commentId와 postId에 해당하는 사용자가 있는 경우
                if (comment.getCommentId().equals(commentId)) {
                    // 해당 사용자 정보 삭제
                    jsonArr.remove(iter.nextIndex() - 1);

                    // JSON 데이터를 텍스트 파일에 저장
                    FileManager.set("commentFile", jsonArr);

                    return comment;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return null;
    }
    
    public boolean deleteByUserId(String userId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("commentFile");
            for (int i = jsonArr.size() - 1; i >= 0; i--) {
                JSONObject item = (JSONObject) jsonArr.get(i);
                Comment comment = Comment.toEntity(item);

                if (comment.getAuthor().equals(userId)) {
   
                    jsonArr.remove(i);
                }
            }
            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            
            FileManager.set("commentFile", jsonArr);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
    }

    // postId로 해당되는 게시물의 댓글을 지우는 것
    public Boolean deleteByPostId(String postId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArrComment = FileManager.get("commentFile");
            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것

            for (int i = jsonArrComment.size() - 1; i >= 0; i--) {
                JSONObject item = (JSONObject) jsonArrComment.get(i);
                Comment comment = Comment.toEntity(item);

                if (comment.getPostId().equals(postId)) {

                    jsonArrComment.remove(i);
                }
            }

            // JSON 데이터를 텍스트 파일에 저장
            FileManager.set("commentFile", jsonArrComment);

            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    // userId로 댓글의 작성자를 찾는 것
    public ArrayList findByUserId(String userId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("commentFile");

            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();
            ArrayList<Comment> commentList = new ArrayList();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Comment로 바뀜
                Comment comment = Comment.toEntity(item);

                // 전달 받은 commentId값이랑 postId 비교를 하는 것
                // 전달받은 commentId와 postId에 해당하는 사용자가 있는 경우
                if (comment.getAuthor().equals(userId)) {

                    commentList.add(comment);

                }
            }
            return commentList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // postId로 게시물의 댓글 찾는 것
    public ArrayList findByPostId(String postId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get("commentFile");

            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArr.listIterator();
            ArrayList<Comment> commentList = new ArrayList();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Comment로 바뀜
                Comment comment = Comment.toEntity(item);

                // 전달 받은 commentId값이랑 postId 비교를 하는 것
                // 전달받은 commentId와 postId에 해당하는 사용자가 있는 경우
                if (comment.getPostId().equals(postId)) {

                    commentList.add(comment);

                }
            }
            return commentList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

}