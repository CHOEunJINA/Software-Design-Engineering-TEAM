/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.LatestPostModel;
import java.util.List;

/**
 *
 * @author bluev
 */
public class LatestPostModelController implements PostModelController {
    public List<String> getPost() {
        LatestPostModel latestPostModel = new LatestPostModel();
        List<String> list = latestPostModel.getLatestPost();
        return list;
    }
    public boolean setPost() {
        return true;
    }
}
