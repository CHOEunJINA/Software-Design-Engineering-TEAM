/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.cse.blog.Utils;

import deu.cse.blog.Model.Post;
import java.util.ArrayList;

/**
 *
 * @author 조은진
 */
public class DataParser {
        public static Object[][] postsToObject(ArrayList<Post> posts) {
        Object[][] values = new Object[posts.size()][];

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);

            values[i] = new Object[]{
                i+1,
                post.getTitle(),
                post.getAuthor(),
                (int)(Math.random() * 400) + 100
            };
        }

        return values;
    }
}
