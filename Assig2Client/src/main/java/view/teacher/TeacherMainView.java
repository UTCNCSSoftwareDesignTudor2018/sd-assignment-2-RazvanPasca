/*
 * Created by JFormDesigner on Wed Apr 18 19:31:05 EEST 2018
 */

package view.teacher;

import entities.Course;
import entities.Student;
import entities.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Razvan Pasca
 */
public class TeacherMainView extends JFrame {
    public TeacherMainView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        tabbedPane1 = new JTabbedPane();
        teacherProfile = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        passwordTextField = new JTextField();
        updateProfileButton = new JButton();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        studentList = new JList();
        label5 = new JLabel();
        textField1 = new JTextField();
        addGradeButton = new JButton();
        coursesBox = new JComboBox();
        writeReportButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== teacherProfile ========
            {

                // JFormDesigner evaluation mark
                teacherProfile.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), teacherProfile.getBorder())); teacherProfile.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label2 ----
                label2.setText("Name");

                //---- label3 ----
                label3.setText("Email");

                //---- label4 ----
                label4.setText("Password");

                //---- updateProfileButton ----
                updateProfileButton.setText("Update my profile");

                GroupLayout teacherProfileLayout = new GroupLayout(teacherProfile);
                teacherProfile.setLayout(teacherProfileLayout);
                teacherProfileLayout.setHorizontalGroup(
                    teacherProfileLayout.createParallelGroup()
                        .addGroup(teacherProfileLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(teacherProfileLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(teacherProfileLayout.createParallelGroup()
                                .addGroup(teacherProfileLayout.createSequentialGroup()
                                    .addGroup(teacherProfileLayout.createParallelGroup()
                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(206, Short.MAX_VALUE))
                );
                teacherProfileLayout.setVerticalGroup(
                    teacherProfileLayout.createParallelGroup()
                        .addGroup(teacherProfileLayout.createSequentialGroup()
                            .addGroup(teacherProfileLayout.createParallelGroup()
                                .addGroup(teacherProfileLayout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(teacherProfileLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(teacherProfileLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, teacherProfileLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(teacherProfileLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(120, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Teacher Profile", teacherProfile);

            //======== panel1 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(studentList);
                }

                //---- label5 ----
                label5.setText("Grade");

                //---- addGradeButton ----
                addGradeButton.setText("Add grade");

                //---- writeReportButton ----
                writeReportButton.setText("Write report");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(addGradeButton, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(coursesBox, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 58, Short.MAX_VALUE))
                                .addComponent(writeReportButton, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(coursesBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(addGradeButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(writeReportButton)
                                    .addGap(0, 13, Short.MAX_VALUE))
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Enrolled Students View", panel1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 742, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JTabbedPane tabbedPane1;
    private JPanel teacherProfile;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JButton updateProfileButton;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList studentList;
    private JLabel label5;
    private JTextField textField1;
    private JButton addGradeButton;
    private JComboBox coursesBox;
    private JButton writeReportButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setTeacherFields(Teacher teacher) {
        this.emailTextField.setText(teacher.getEmail());
        this.passwordTextField.setText(teacher.getPassword());
        this.nameTextField.setText(teacher.getName());
    }

    public void addUpdateButtonListener(ActionListener e) {
        this.updateProfileButton.addActionListener(e);
    }

    public void setAddGradeButtonListener(ActionListener e) {
        this.addGradeButton.addActionListener(e);
    }

    public void setStudentList(List<Student> students) {
        studentList.setListData(students.toArray());
    }

    public void setCoursesBox(List<Course> courses) {
        for (Course course : courses)
            this.coursesBox.addItem(course.getName());
    }

    public void setWriteReportButtonListener(ActionListener e){
        this.writeReportButton.addActionListener(e);
    }

    public void addCoursesBoxListener(ItemListener e){
        this.coursesBox.addItemListener(e);
    }
    public int getSelectedCourseIndex(){
        return this.coursesBox.getSelectedIndex();
    }
    public void addStudentListListener(MouseListener e){
        this.studentList.addMouseListener(e);
    }

    public int getClickIndex(){
        return this.studentList.getSelectedIndex();
    }

}
