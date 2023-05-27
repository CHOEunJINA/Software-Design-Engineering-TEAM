/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.View;

import deu.cse.blog.Presenter.Originator;
import deu.cse.blog.Presenter.PostPresenter;
import deu.cse.blog.Utils.ViewManager;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author 조은진
 */
public class PostWriteView extends javax.swing.JFrame {

    private String author = UserSession.getSession();
    private String title;
    private String content;

    private PostPresenter postPresenter = new PostPresenter();
    private Originator originator = new Originator();
    private boolean isUndo;
    private String state = "";

    /**
     * Creates new form PostView1
     */
    public PostWriteView() {
        initComponents();
        setLocationRelativeTo(null); // 중앙 정렬
        setVisible(true);
        Timer m = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                System.out.println("스레드");
                if (!state.equals(contentArea.getText())) {
                    System.out.println("상태 저장");
                    state = contentArea.getText();
                    originator.setState(state);
                }
            }
        };

        m.schedule(task, 1000, 5000); // 5초 단위로 저장됨
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        addPost = new javax.swing.JButton();
        blogHome = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        titleField = new javax.swing.JTextField();
        imageButton = new javax.swing.JButton();
        fontButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        undoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        topPanel.setBackground(new java.awt.Color(255, 255, 255));

        addPost.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        addPost.setText("등록");
        addPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPostMouseClicked(evt);
            }
        });

        blogHome.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        blogHome.setText("블로그 홈");
        blogHome.setPreferredSize(new java.awt.Dimension(77, 29));
        blogHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blogHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(blogHome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPost, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPost, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(blogHome, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleField.setForeground(new java.awt.Color(153, 153, 153));
        titleField.setText("제목");

        imageButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        imageButton.setText("사진");

        fontButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        fontButton.setText("글씨");

        redoButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        redoButton.setText("Redo");
        redoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redoButtonMouseClicked(evt);
            }
        });

        contentArea.setColumns(20);
        contentArea.setForeground(new java.awt.Color(153, 153, 153));
        contentArea.setRows(5);
        contentArea.setText("내용");
        jScrollPane1.setViewportView(contentArea);

        undoButton.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        undoButton.setText("Undo");
        undoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(imageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fontButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                        .addComponent(undoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(redoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                            .addComponent(titleField))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(undoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // 등록 버튼 클릭 시
    private void addPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPostMouseClicked
        // TODO add your handling code here:
        title = titleField.getText();
        content = contentArea.getText();

        Boolean result = false;
        if (!title.equals("") && !content.equals("")) {
            result = postPresenter.register(title, content, author);
        }
        
        if (result == true) {
            JOptionPane.showMessageDialog(getContentPane(), "글이 등록되었습니다.");
            setVisible(false);
            dispose();
            ViewManager.moveToMainView(author);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "글 등록에 실패하였습니다.");
        }
    }//GEN-LAST:event_addPostMouseClicked
    // 블로그 홈 클릭 시
    private void blogHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blogHomeMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        ViewManager.moveToMainView(author);


    }//GEN-LAST:event_blogHomeMouseClicked
    // 뒤로 가기(Undo) 버튼 클릭 시
    private void undoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoButtonMouseClicked
        // TODO add your handling code here:
        isUndo = true;
        state = originator.getState(isUndo);
        contentArea.setText(state);
    }//GEN-LAST:event_undoButtonMouseClicked
    // 앞으로 가기(Redo) 버튼 클릭 시
    private void redoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoButtonMouseClicked
        // TODO add your handling code here:
        isUndo = false;
        state = originator.getState(isUndo);
        contentArea.setText(state);
    }//GEN-LAST:event_redoButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPost;
    private javax.swing.JButton blogHome;
    private javax.swing.JTextArea contentArea;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton fontButton;
    private javax.swing.JButton imageButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton redoButton;
    private javax.swing.JTextField titleField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables

}
