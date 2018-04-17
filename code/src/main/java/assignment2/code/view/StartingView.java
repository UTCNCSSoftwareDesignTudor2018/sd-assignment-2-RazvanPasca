/*
 * Created by JFormDesigner on Tue Apr 17 21:54:23 EEST 2018
 */

package assignment2.code.view;

import javax.swing.*;
import java.awt.*;

//import java.awt.*;

/**
 * @author Razvan Pasca
 */
public class StartingView extends JFrame {
//    public StartingView() {
//        initComponents();
//    }
//
//    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
// Generated using JFormDesigner Evaluation license - Razvan Pasca
    studentsBox =new //======== this ========
    Container contentPane = getContentPane();
    teachersBox =new
    GroupLayout contentPaneLayout = new GroupLayout(contentPane);
    studentLoginButton =new //        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    //    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
// Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JComboBox studentsBox;
    teacherLoginButton =new
    private JComboBox teachersBox;
    private JButton studentLoginButton;

//---- studentLoginButton ----
studentLoginButton.setText("Login as Student");

//---- teacherLoginButton ----
teacherLoginButton.setText("Login as Teacher");
    private JButton teacherLoginButton;
contentPane.setLayout(contentPaneLayout);
contentPaneLayout.setHorizontalGroup(
        contentPaneLayout.createParallelGroup()
        .

    JComboBox();
            .

    JComboBox();
            .

    JButton();
                .

    JButton();
                .

    addGroup(contentPaneLayout.createSequentialGroup())
            .

    addGap(68,68,68)
            .

    addGroup(contentPaneLayout.createParallelGroup()
                .

    addComponent(studentsBox, GroupLayout.PREFERRED_SIZE, 138,GroupLayout.PREFERRED_SIZE)
                .

    addComponent(studentLoginButton))
            .

    addGap(107,107,107))
            );
contentPaneLayout.setVerticalGroup(
        contentPaneLayout.createParallelGroup()
        .

    addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .

    addComponent(teacherLoginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .

    addComponent(teachersBox)
                .

    addContainerGap(23,Short.MAX_VALUE)
                .

    addGroup(contentPaneLayout.createSequentialGroup())
            .

    addGap(43,43,43)
            .

    addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .

    addComponent(studentsBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .

    addComponent(teachersBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .

    addGap(93,93,93))
            );

    addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)

    addComponent(teacherLoginButton, GroupLayout.PREFERRED_SIZE, 37,GroupLayout.PREFERRED_SIZE));

    addComponent(studentLoginButton)

    addContainerGap(33,Short.MAX_VALUE)

    pack();

    setLocationRelativeTo(getOwner()
//    // JFormDesigner - End of variables declaration  //GEN-END:variables
//
//    public void setStudentsBox(List<Student> students) {
//        for (Student student : students)
//            studentsBox.addItem(student.getName());
//    }
//
//    public void setTeachersBox(List<Teacher> teachers) {
//        for (Teacher teacher : teachers)
//            teachersBox.addItem(teacher.getName());
//    }
//
//    public int getSelectedStudentIndex() {
//        return studentsBox.getSelectedIndex();
//    }
//
//    public int getSelectedTeacherIndex() {
//        return teachersBox.getSelectedIndex();
//    }
//
//    public void addTeacherLoginListener(ActionListener e){
//        this.teacherLoginButton.addActionListener(e);
//    }
//
//    public void addStudentLoginListener(ActionListener e){
//        this.studentLoginButton.addActionListener(e);
//    }
}
