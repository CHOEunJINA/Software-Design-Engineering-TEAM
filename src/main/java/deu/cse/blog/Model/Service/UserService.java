/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Service;

import deu.cse.blog.Model.Repository.UserRepository;
import deu.cse.blog.Model.User;

/**
 *
 * @author 조은진
 */
public class UserService {

    private UserRepository userRepository = new UserRepository();

    public Boolean signUp(String id, String name, String password, String passwordConfirm, String gender) {
        // 전달 받은 id로 유저 검색
        User target = userRepository.findById(id);

        // 이미 있는 ID 정보
        if (target != null) {
            return null;
        }

        // ID 정보가 없으면 userRepository한테 User정보 저장 요청
        // Repository한테 요청하기 위해서 매개변수를 User 타입으로 변경
        User user = new User.Builder()
                .userId(id)
                .password(password)
                .name(name)
                .gender(gender)
                .build();

        // save 결과 리턴
        return userRepository.save(user);
    } //회원가입시 Repository에 요청하기 -> 이미 있는 회원인지 확인을 한다.

    public String login(String id, String password) {

        // 로그인한 사용자의 정보를 id를 통해 가져옴
        User target = userRepository.findById(id);
        // id로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return "null";
        }

        // 입력받은 비밀번호랑 저장된 비밀번호 다르면 null 리턴
        if (!target.getPassword().equals(password)) {

            return "null";
        }

        return "success";
    }

    public String delete(String id) {

        User target = userRepository.deleteById(id);

        // id로 검색한 결과가 없으면 null 리턴
        if (target == null) {
            return "null";
        }

        return "success";
    }

}
