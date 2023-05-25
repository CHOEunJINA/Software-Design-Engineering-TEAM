/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Utils;

import deu.cse.blog.Model.Post;
import java.util.ArrayList;

/**
 *
 * @author a4424
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
