/*
 * Created by JFormDesigner on Tue Apr 17 22:11:26 EEST 2018
 */

package view.student;

import java.awt.event.*;

import entities.Course;
import entities.Student;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Razvan Pasca
 */
public class StudentMainView extends JFrame {
    public StudentMainView() {
        initComponents();
    }

    private void courseListMouseClicked(MouseEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        tabbedPane1 = new JTabbedPane();
        profilePanel = new JPanel();
        nameTextField = new JTextField();
        label2 = new JLabel();
        addressTextField = new JTextField();
        label3 = new JLabel();
        cnpTextField = new JTextField();
        label4 = new JLabel();
        passwordTextField = new JTextField();
        label5 = new JLabel();
        groupTextField = new JTextField();
        updateProfileButton = new JButton();
        label6 = new JLabel();
        emailTextField = new JTextField();
        label1 = new JLabel();
        coursesPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        courseList = new JList();
        enrollButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== profilePanel ========
            {

                // JFormDesigner evaluation mark
                profilePanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), profilePanel.getBorder())); profilePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label2 ----
                label2.setText("Address");

                //---- label3 ----
                label3.setText("CNP");

                //---- label4 ----
                label4.setText("Password");

                //---- label5 ----
                label5.setText("Group");

                //---- updateProfileButton ----
                updateProfileButton.setText("Update Profile");

                //---- label6 ----
                label6.setText("Email");

                //---- label1 ----
                label1.setText("Name");

                GroupLayout profilePanelLayout = new GroupLayout(profilePanel);
                profilePanel.setLayout(profilePanelLayout);
                profilePanelLayout.setHorizontalGroup(
                    profilePanelLayout.createParallelGroup()
                        .addGroup(profilePanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(profilePanelLayout.createParallelGroup()
                                .addGroup(profilePanelLayout.createSequentialGroup()
                                    .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(profilePanelLayout.createSequentialGroup()
                                    .addGroup(profilePanelLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                            .addComponent(cnpTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, profilePanelLayout.createSequentialGroup()
                                            .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, profilePanelLayout.createSequentialGroup()
                                            .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addGroup(profilePanelLayout.createParallelGroup()
                                        .addComponent(passwordTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                                    .addGap(183, 183, 183))))
                );
                profilePanelLayout.setVerticalGroup(
                    profilePanelLayout.createParallelGroup()
                        .addGroup(profilePanelLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5)
                                .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(profilePanelLayout.createParallelGroup()
                                .addGroup(profilePanelLayout.createSequentialGroup()
                                    .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
                                .addGroup(profilePanelLayout.createSequentialGroup()
                                    .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(cnpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)))
                            .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                );
            }
            tabbedPane1.addTab("Profile", profilePanel);

            //======== coursesPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- courseList ----
                    courseList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            courseListMouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(courseList);
                }

                //---- enrollButton ----
                enrollButton.setText("Enroll Me");

                GroupLayout coursesPanelLayout = new GroupLayout(coursesPanel);
                coursesPanel.setLayout(coursesPanelLayout);
                coursesPanelLayout.setHorizontalGroup(
                    coursesPanelLayout.createParallelGroup()
                        .addGroup(coursesPanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(coursesPanelLayout.createParallelGroup()
                                .addComponent(enrollButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(100, Short.MAX_VALUE))
                );
                coursesPanelLayout.setVerticalGroup(
                    coursesPanelLayout.createParallelGroup()
                        .addGroup(coursesPanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(enrollButton)
                            .addContainerGap(35, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("View Courses", coursesPanel);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JTabbedPane tabbedPane1;
    private JPanel profilePanel;
    private JTextField nameTextField;
    private JLabel label2;
    private JTextField addressTextField;
    private JLabel label3;
    private JTextField cnpTextField;
    private JLabel label4;
    private JTextField passwordTextField;
    private JLabel label5;
    private JTextField groupTextField;
    private JButton updateProfileButton;
    private JLabel label6;
    private JTextField emailTextField;
    private JLabel label1;
    private JPanel coursesPanel;
    private JScrollPane scrollPane1;
    private JList courseList;
    private JButton enrollButton;
    //    // JFormDesigner - End of variables declaration  //GEN-END:variables
//
//
    public JPanel getCoursesPanel() {
        return coursesPanel;
    }

    public void setCoursesPanel(JPanel coursesPanel) {
        this.coursesPanel = coursesPanel;
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public String getAddressTextField() {
        return addressTextField.getText();
    }

    public void setAddressTextField(String addressTextField) {
        this.addressTextField.setText(addressTextField);
    }

    public String getCnpTextField() {
        return cnpTextField.getText();
    }

    public void setCnpTextField(String cnpTextField) {
        this.cnpTextField.setText(cnpTextField);
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public String getGroupTextField() {
        return groupTextField.getText();
    }

    public void setGroupTextField(JTextField groupTextField) {
        this.groupTextField = groupTextField;
    }

    public void addUpdateButtonListener(ActionListener e) {
        this.updateProfileButton.addActionListener(e);
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setStudentFields(Student student) {
        this.passwordTextField.setText(student.getPassword());
        this.emailTextField.setText(student.getEmail());
        this.addressTextField.setText(student.getAddress());
        this.nameTextField.setText(student.getName());
        this.groupTextField.setText(String.valueOf(student.getStudyGroup()));
        this.cnpTextField.setText(student.getCnp());
    }

    public void setCourseList(List<Course> courses) {
        this.courseList.setListData(courses.toArray());
    }

    public void addListMouseListener(MouseAdapter e) {
        this.courseList.addMouseListener(e);
    }

    public void addEnrollMeListener(ActionListener e) {
        this.enrollButton.addActionListener(e);
    }

    public int getSelectedCourseIndex() {
        return this.courseList.getSelectedIndex();
    }

}
