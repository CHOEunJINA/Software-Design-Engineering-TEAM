/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Presenter;


import deu.cse.blog.Model.Service.UserService;

/**
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 * 2023.05.19 수정 조은진
 */
public class UserPresenter {
    private UserService userService; 

    public UserPresenter() {
        this.userService = new UserService();
    }
    
    
    public Boolean registerUser(String id, String name, String password, String passwordConfirm, String gender) {
        // 여기서 signUp 한 결과가 불리언으로 오잖아 ㅇㅇ
        
        Boolean result = userService.signUp(id, name, password, passwordConfirm, gender);
        
        return result; // -> 그니까 얘가 처리 결과니까 뷰에서 이걸 보고 성공/실패 알림 띄워주면댐 오 ㅇㅇㅇ ㅇㅋㅇㅋ??ㅇㅇ
        // 그럼 이제 끝
        //음.. 잠만 registerUser 이자식이 뷰에서 값을 받아오는 그런 역할 아니었음? ?
        // 뷰한테서 입력 값을 매개변수로 받아오고
        // 처리 결과를 뷰한테 돌려주지 아 이해함
    }
    
    
    public Boolean loginUser(String id, String password) {
        
        Boolean result = userService.login(id, password);
        return result;

    }
}
