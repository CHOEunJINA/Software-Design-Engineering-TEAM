/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author 조은진 댓글 관리
 */
public class CommentRepository {

    private static String commentFile = "./comment.json"; // 댓글 데이터

    //댓글 저장 메소드
    public Boolean save(Comment comment) {
        try {
            JSONArray jsonArr = FileManager.get(commentFile);

            // JSONArray에 추가
            jsonArr.add(comment.toJson());
            // JSON 데이터를 텍스트 파일에 저장
            FileManager.set(commentFile, jsonArr);

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
            JSONArray jsonArr = FileManager.get(commentFile);

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
                    FileManager.set(commentFile, jsonArr);

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

    // 식별자로 기존 댓글정보가 있는지 찾고 삭제하는 메소드
    public Boolean deleteByPostId(String postId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArrComment = FileManager.get(commentFile);

            // JSONArray 다 돌면서 전달 받은 commentId 있는지 확인하는 것
            // JSONArray에 저장되어 있는 애들을 이터레이터로 뽑아오는 것
            ListIterator iter = jsonArrComment.listIterator();

            while (iter.hasNext()) {
                JSONObject item = (JSONObject) iter.next();
                // 읽어온 JSON이 Comment로 바뀜
                Comment comment = Comment.toEntity(item);

                // 전달 받은 commentId값이랑 postId 비교를 하는 것
                // 전달받은 commentId와 postId에 해당하는 사용자가 있는 경우
                if (comment.getPostId().equals(postId)) {
                    // 해당 사용자 정보 삭제
                    jsonArrComment.remove(iter.nextIndex() - 1);

                    // JSON 데이터를 텍스트 파일에 저장
                    FileManager.set(commentFile, jsonArrComment);

                    return true;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return false;
    }

    // 
    public ArrayList findByUserId(String userId) {
        try {
            // 기존 파일 로드
            JSONArray jsonArr = FileManager.get(commentFile);

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

                    return commentList;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }

        // id에 해당하는 사용자를 못 찾은 경우 null 리턴
        return null;
    }

}
