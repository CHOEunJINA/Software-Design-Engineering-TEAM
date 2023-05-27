/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Utils;

import deu.cse.blog.Model.Post;
import deu.cse.blog.View.*;

/**
 *
 * @author 강대한
 */
public class ViewManager {
    
    public static void moveToMainView(String userID) {
        if (userID.equals("")) { 
            new MainView();
        } else { //로그인되었을 때
            new MainView(userID);
        }    
    }
    
    public static void moveToMyView() {
        new MyView();
    }
    
    public static void moveToLoginView() {
        new LoginView();
    }
    
    public static void moveToSignUpView() {
        new SignUpView();
    }
    
    public static void moveToPostWriteView() {
        new PostWriteView();
    }
    
    public static void moveToMyPostView(Post selectedPost)  {
        new MyPostView(selectedPost);
    }
    
    public static void moveToCheckPostView(Post selectedPost) {
        new CheckPostView(selectedPost);
    }
    
    public static void moveToSearchView(String search) {
        new SearchView(search);
    }
    
    public static void moveToMyInfoView() {
        new MyInfoView();
    }
    
    public static void moveToDeleteInfoView() {
        new DeleteInfoView();
    }
}
