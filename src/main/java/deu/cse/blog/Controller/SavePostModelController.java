/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.SavePostModel;
import org.json.simple.JSONArray;

/**
 *
 * @author bluev
 */
public class SavePostModelController implements SetPostModelController {
    private SavePostModel savePostModel = new SavePostModel();
    @Override
    public boolean setPost(String title, String post, String user) {
        boolean success = false;
        success = savePostModel.savePost(title, post, user);
        return success;
    }
}
