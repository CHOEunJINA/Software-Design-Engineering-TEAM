/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.Model.Post;
import deu.cse.blog.View.*;

/**
 *
 * @author 강대한
 */
public class ViewPresenter {

    public ViewPresenter() {
    }
    
    public void moveToMainView() {  
        
    }
    
    public void moveToMainView(String userID) {
        if (userID.equals("")) {
            new MainView();
        } else {
            new MainView(userID);
        }    
    }
    
    public void moveToMyView() {
        new MyView();
    }
    
    public void moveToLoginView() {
        new LoginView();
    }
    
    public void moveToSignUpView() {
        new SignUpView();
    }
    
    public void moveToPostWriteView() {
        new PostWriteView();
    }
    
    public void moveToMyPostView(Post selectedPost)  {
        new MyPostView(selectedPost);
    }
    
    public void moveToCheckPostView(Post selectedPost) {
        new CheckPostView(selectedPost);
    }
    
    public void moveToSearchView(String search) {
        new SearchView(search);
    }
    
    public void moveToMyInfoView() {
        new MyInfoView();
    }
    
    public void moveToDeleteInfoView() {
        new DeleteInfoView();
    }
}
