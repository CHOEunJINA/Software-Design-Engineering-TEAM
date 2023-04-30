/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

/**
 *
 * @author a4424
 */
import java.awt.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class SignUpView extends JFrame {

    private JLabel idLabel;
    private JLabel pwLabel;
    private JLabel nameLabel;
    private JLabel birthLabel;
    private JLabel pwConfirmLabel;
    
    private JTextField idTextField;
    private JPasswordField pwField;
    private JPasswordField pwConfirmField;
    private JTextField nameField;
    
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    
    private JButton signUpButton;
    private JButton cancelButton;

    public SignUpView() {
        super("회원가입");

        // 프레임 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null); // 중앙 정렬

        // 패널 추가
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,15));

        // 아이디 입력 필드
        idLabel = new JLabel("아이디");
        idTextField = new JTextField(17);
        panel.add(idLabel);
        panel.add(idTextField);

        // 비밀번호 입력 필드
        pwLabel = new JLabel("비밀번호");
        pwField = new JPasswordField(17);
        panel.add(pwLabel);
        panel.add(pwField);

        // 비밀번호 확인 필드
        pwConfirmLabel = new JLabel("비밀번호 확인");
        pwConfirmField = new JPasswordField(17);
        panel.add(pwConfirmLabel);
        panel.add(pwConfirmField);
        
        // 이름 확인 필드
        nameLabel = new JLabel("이름");
        nameField = new JPasswordField(17);
        panel.add(nameLabel);
        panel.add(nameField);
        
        // 라디오 버튼 추가
        maleButton = new JRadioButton("남성");
        femaleButton = new JRadioButton("여성");

        // 라디오 버튼 그룹으로 묶기
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        panel.add(maleButton);
        panel.add(femaleButton);

        // 버튼 추가
        signUpButton = new JButton("회원가입");
        cancelButton = new JButton("취소");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(signUpButton);
        buttonPanel.add(cancelButton);

        // 전체 패널에 패널 및 버튼 추가
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(contentPane);
        
        setVisible(true);
    }

   
}
