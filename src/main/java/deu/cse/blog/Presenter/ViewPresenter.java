/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;

import deu.cse.blog.View.MorePostView;
import deu.cse.blog.View.*;

/**
 *
 * @author 강대한
 */
public class ViewPresenter {

    public ViewPresenter() {
    }
    
    public void moveToMainView() {
        new MainView().setVisible(true);
    }
    
    public void moveToMyView() {
        new MyView().setVisible(true);
    }
    
    public void moveToLoginView() {
        new LoginView();
    }
    
    public void moveToSignUpView() {
        new SignUpView();
    }
    
    public void moveToPostView() {
        new PostView();
    }
    
    public void moveToMyPostView(String[] postInfo)  {
        new MyPostView(postInfo).setVisible(true);
    }
    
    public void moveToAnotherUserPostView(String[] postInfo, String search) {
        new AnotherUserPostView(postInfo, search).setVisible(true);
    }
    
    public void moveToMorePostView() {
        new MorePostView();
    }
    
    public void moveToSearchView(String search) {
        new SearchView(search).setVisible(true);
    }
    
    public void moveToMyInfoView(String user) {
        new MyInfoView(user).setVisible(true);
    }
}
