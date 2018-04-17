/*
 * Created by JFormDesigner on Tue Apr 17 22:11:26 EEST 2018
 */

package assignment2.code.view.student;

import javax.swing.*;

/**
 * @author Razvan Pasca
 */
public class StudentMainView extends JFrame {
//    public StudentMainView() {
//        initComponents();
//    }
//
//    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
//        // Generated using JFormDesigner Evaluation license - Razvan Pasca
//        tabbedPane1 = new JTabbedPane();
//        mainPanel = new JPanel();
//        label1 = new JLabel();
//        nameTextField = new JTextField();
//        label2 = new JLabel();
//        addressTextField = new JTextField();
//        label3 = new JLabel();
//        cnpTextField = new JTextField();
//        label4 = new JLabel();
//        passwordTextField = new JTextField();
//        label5 = new JLabel();
//        groupTextField = new JTextField();
//        updateProfileButton = new JButton();
//        label6 = new JLabel();
//        emailTextField = new JTextField();
//        coursesPanel = new JPanel();
//
//        //======== this ========
//        Container contentPane = getContentPane();
//
//        //======== tabbedPane1 ========
//        {
//
//            //======== mainPanel ========
//            {
//
//                // JFormDesigner evaluation mark
//                mainPanel.setBorder(new javax.swing.border.CompoundBorder(
//                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                        java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
//
//
//                //---- label1 ----
//                label1.setText("Name");
//
//                //---- label2 ----
//                label2.setText("Address");
//
//                //---- label3 ----
//                label3.setText("CNP");
//
//                //---- label4 ----
//                label4.setText("Password");
//
//                //---- label5 ----
//                label5.setText("Group");
//
//                //---- updateProfileButton ----
//                updateProfileButton.setText("Update Profile");
//
//                //---- label6 ----
//                label6.setText("Email");
//
//                GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
//                mainPanel.setLayout(mainPanelLayout);
//                mainPanelLayout.setHorizontalGroup(
//                    mainPanelLayout.createParallelGroup()
//                        .addGroup(mainPanelLayout.createSequentialGroup()
//                            .addGap(21, 21, 21)
//                            .addGroup(mainPanelLayout.createParallelGroup()
//                                .addGroup(mainPanelLayout.createSequentialGroup()
//                                    .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
//                                    .addContainerGap(510, Short.MAX_VALUE))
//                                .addGroup(mainPanelLayout.createSequentialGroup()
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//                                        .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
//                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
//                                    .addGap(18, 18, 18)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
//                                        .addComponent(addressTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
//                                        .addComponent(cnpTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
//                                    .addGap(71, 71, 71)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
//                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
//                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
//                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
//                                        .addComponent(groupTextField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
//                                        .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
//                                    .addGap(44, 44, 44))))
//                );
//                mainPanelLayout.setVerticalGroup(
//                    mainPanelLayout.createParallelGroup()
//                        .addGroup(mainPanelLayout.createSequentialGroup()
//                            .addGap(38, 38, 38)
//                            .addGroup(mainPanelLayout.createParallelGroup()
//                                .addGroup(mainPanelLayout.createSequentialGroup()
//                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addGap(18, 18, 18)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                    .addGap(18, 18, 18)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(cnpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(label3)))
//                                .addGroup(mainPanelLayout.createSequentialGroup()
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                    .addGap(20, 20, 20)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(label5)
//                                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                    .addGap(18, 18, 18)
//                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
//                            .addGap(21, 21, 21)
//                            .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
//                            .addGap(28, 28, 28))
//                );
//            }
//            tabbedPane1.addTab("Profile", mainPanel);
//
//            //======== coursesPanel ========
//            {
//
//                GroupLayout coursesPanelLayout = new GroupLayout(coursesPanel);
//                coursesPanel.setLayout(coursesPanelLayout);
//                coursesPanelLayout.setHorizontalGroup(
//                    coursesPanelLayout.createParallelGroup()
//                        .addGap(0, 695, Short.MAX_VALUE)
//                );
//                coursesPanelLayout.setVerticalGroup(
//                    coursesPanelLayout.createParallelGroup()
//                        .addGap(0, 291, Short.MAX_VALUE)
//                );
//            }
//            tabbedPane1.addTab("View Courses", coursesPanel);
//        }
//
//        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
//        contentPane.setLayout(contentPaneLayout);
//        contentPaneLayout.setHorizontalGroup(
//            contentPaneLayout.createParallelGroup()
//                .addGroup(contentPaneLayout.createSequentialGroup()
//                    .addContainerGap()
//                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
//                    .addContainerGap(30, Short.MAX_VALUE))
//        );
//        contentPaneLayout.setVerticalGroup(
//            contentPaneLayout.createParallelGroup()
//                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
//                    .addContainerGap(31, Short.MAX_VALUE)
//                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
//                    .addGap(17, 17, 17))
//        );
//        pack();
//        setLocationRelativeTo(getOwner());
//        // JFormDesigner - End of component initialization  //GEN-END:initComponents
//    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
//    // Generated using JFormDesigner Evaluation license - Razvan Pasca
//    private JTabbedPane tabbedPane1;
//    private JPanel mainPanel;
//    private JLabel label1;
//    private JTextField nameTextField;
//    private JLabel label2;
//    private JTextField addressTextField;
//    private JLabel label3;
//    private JTextField cnpTextField;
//    private JLabel label4;
//    private JTextField passwordTextField;
//    private JLabel label5;
//    private JTextField groupTextField;
//    private JButton updateProfileButton;
//    private JLabel label6;
//    private JTextField emailTextField;
//    private JPanel coursesPanel;
//    // JFormDesigner - End of variables declaration  //GEN-END:variables
//
//
//    public JPanel getCoursesPanel() {
//        return coursesPanel;
//    }
//
//    public void setCoursesPanel(JPanel coursesPanel) {
//        this.coursesPanel = coursesPanel;
//    }
//
//    public JTextField getNameTextField() {
//        return nameTextField;
//    }
//
//    public void setNameTextField(JTextField nameTextField) {
//        this.nameTextField = nameTextField;
//    }
//
//    public JTextField getAddressTextField() {
//        return addressTextField;
//    }
//
//    public void setAddressTextField(JTextField addressTextField) {
//        this.addressTextField = addressTextField;
//    }
//
//    public JTextField getCnpTextField() {
//        return cnpTextField;
//    }
//
//    public void setCnpTextField(JTextField cnpTextField) {
//        this.cnpTextField = cnpTextField;
//    }
//
//    public JTextField getPasswordTextField() {
//        return passwordTextField;
//    }
//
//    public void setPasswordTextField(JTextField passwordTextField) {
//        this.passwordTextField = passwordTextField;
//    }
//
//    public JTextField getGroupTextField() {
//        return groupTextField;
//    }
//
//    public void setGroupTextField(JTextField groupTextField) {
//        this.groupTextField = groupTextField;
//    }
//
//    public void addUpdateButtonListener(ActionListener e){
//        this.updateProfileButton.addActionListener(e);
//    }
//
//    public void setStudentFields(Student student){
//        this.passwordTextField.setText(student.getPassword());
//        this.emailTextField.setText(student.getEmail());
//        this.addressTextField.setText(student.getAddress());
//        this.nameTextField.setText(student.getName());
//        this.groupTextField.setText(String.valueOf(student.getStudyGroup()));
//    }
}
