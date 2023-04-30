/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model;

/**
 *
 * @author a4424
 */
import java.io.*;
import java.util.*;

public class SignUpModel {

    private static final String UserData = "user_data.txt";

    // 회원 가입 정보 저장 메서드
    public static boolean saveSignUpInfo(String userId, String password, String name) {
        try {
            FileWriter fw = new FileWriter(UserData, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(userId + "," + password + "," + name);

            pw.close();
            bw.close();
            fw.close();

            return true;
        } catch (IOException e) {
            System.out.println("Failed to save user information.");
            e.printStackTrace();
            return false;
        }
    }

    // 아이디 중복 체크 메서드
    public static boolean checkDuplicateId(String userId) {
        try {
            File file = new File(UserData);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(userId)) {
                    br.close();
                    fr.close();
                    return true;
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Failed to read user information.");
            e.printStackTrace();
        }
        return false;
    }

    public boolean signUp(String id, String password, String name, ArrayList<User> userList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

