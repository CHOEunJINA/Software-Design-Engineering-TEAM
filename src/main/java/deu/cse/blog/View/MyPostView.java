/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deu.cse.blog.View;

import deu.cse.blog.Presenter.Originator;
import deu.cse.blog.Presenter.PostPresenter;
import deu.cse.blog.Presenter.ViewPresenter;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author 강대한
 */
public class MyPostView extends javax.swing.JFrame {

    private String title;
    private String post;
    private String user;
    private String time;
    private PostPresenter postPresenter = new PostPresenter();
    private ViewPresenter viewPresenter = new ViewPresenter();
    private Originator originator = new Originator();
    private boolean isUndo;
    private String state;
    /**
     * Creates new form MyPostView
     */
    public MyPostView() {
        initComponents();
    }

    public MyPostView(String[] postInfo) {

        title = postInfo[0]; 
        user = postInfo[1];
        time = postInfo[2];
        post = postPresenter.loadPost(title, user, time); // 글 내용 불러오기
        state = post;
        Timer m = new Timer();
        initComponents();
        TimerTask task = new TimerTask() { // 글의 내용이 바뀌어질 때 마다 글 내용 저장
            @Override
            public void run() {
                if (!state.equals(jTextArea1.getText())) {
                    state = jTextArea1.getText();
                    originator.setState(state);
                }
            }
        };
        m.schedule(task, 1000, 3000); // 3초 마다 작업 실행
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myViewButton = new javax.swing.JButton();
        updatePostButton = new javax.swing.JButton();
        deletePostButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        backwardButton = new javax.swing.JButton();
        forewardButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        myViewButton.setText("내블로그");
        myViewButton.setAutoscrolls(true);

        updatePostButton.setText("수정");
        updatePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePostButtonActionPerformed(evt);
            }
        });

        deletePostButton.setText("삭제");
        deletePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePostButtonActionPerformed(evt);
            }
        });

        jTextField1.setText(title);

        backwardButton.setText("");
        backwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardButtonActionPerformed(evt);
            }
        });

        forewardButton.setText("");
        forewardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forewardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(myViewButton)
                .addGap(28, 28, 28)
                .addComponent(backwardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forewardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(updatePostButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletePostButton)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myViewButton)
                    .addComponent(updatePostButton)
                    .addComponent(deletePostButton)
                    .addComponent(backwardButton)
                    .addComponent(forewardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(post);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePostButtonActionPerformed
        post = jTextArea1.getText();
        boolean success = postPresenter.update(title, post, time); // 글 수정
        
        if (success) {
            JOptionPane.showMessageDialog(getContentPane(), "수정 완료!");
            this.setVisible(false);
            viewPresenter.moveToMyView();
        }
    }//GEN-LAST:event_updatePostButtonActionPerformed

    private void backwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardButtonActionPerformed
        isUndo = true;
        state = originator.getState(isUndo); // 실행 취소
        jTextArea1.setText(state);
    }//GEN-LAST:event_backwardButtonActionPerformed

    private void forewardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forewardButtonActionPerformed
        isUndo = false;
        state = originator.getState(isUndo); // 되돌리기
        jTextArea1.setText(state);
    }//GEN-LAST:event_forewardButtonActionPerformed

    private void deletePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePostButtonActionPerformed
        boolean success = postPresenter.delete(title, user, time); // 글 삭제
        
        if (success) {
            JOptionPane.showMessageDialog(getContentPane(), "삭제 완료!");
            this.setVisible(false);
            viewPresenter.moveToMyView();
        }
    }//GEN-LAST:event_deletePostButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backwardButton;
    private javax.swing.JButton deletePostButton;
    private javax.swing.JButton forewardButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton myViewButton;
    private javax.swing.JButton updatePostButton;
    // End of variables declaration//GEN-END:variables
}
