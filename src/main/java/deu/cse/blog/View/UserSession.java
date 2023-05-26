/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

/**
 * 로그인 한 userId를 받아와 세션으로 저장하는 클래스
 * @author 조은진
 */
public class UserSession {
    
    private static String session = "";

    //사용자 로그인 아이디를 받아와 세션으로 저장
    public static void setSession(String auth) {
        session = auth;
        System.out.println(session);
    }
    public static String getSession(){
        System.out.println(session);
        return session;     
    }
}
