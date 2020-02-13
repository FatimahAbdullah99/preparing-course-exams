
// Section : 41342
// Gruop Number : 2
// Names: 
// Maram Alabbad 438202072
// Raneem Alnajim 438200793
// Fatima Alshammari 438202838
// Hadeel Alghudair 438201196

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class HomeFrame extends JFrame implements ActionListener {

   public JPanel jPanel1;
   public JLabel label1;
   public JLabel label2;
   public JComboBox<String> list;
   public JTextField text1;
   public JButton bOpen;
   public String courseName;

   public static void main(String[] args) {
   
      HomeFrame obj = new HomeFrame();
      obj.setVisible(true);
   
   }

   public HomeFrame() {
   
      this.setContentPane(new JLabel());
   
      setTitle("Exam Manager ");
      setLocation(200, 10);
      setResizable(false);
      this.pack();
      setSize(280, 400);
   
      jPanel1 = new JPanel();
      jPanel1.setBorder(BorderFactory.createTitledBorder("Open"));
      jPanel1.setBounds(18, 80, 240, 280);
      jPanel1.setLayout(null);
      add(jPanel1);
   
      label1 = new JLabel("Previous Courses:");
      label1.setBounds(20, 40, 120, 20);
      jPanel1.add(label1);
   
      list = new JComboBox<String>();
      list.setBounds(20, 60, 200, 30);
      jPanel1.add(list);
   
      label2 = new JLabel("New Course:");
      label2.setBounds(20, 110, 120, 20);
      jPanel1.add(label2);
   
      text1 = new JTextField();
      text1.setColumns(10);
      text1.setBounds(20, 130, 200, 30);
      jPanel1.add(text1);
   
      bOpen = new JButton("Open Question Bank");
      bOpen.setBounds(40, 190, 160, 30);
      jPanel1.add(bOpen);
      bOpen.addActionListener(this);
   
      list.setEnabled(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   
      File folder = new File(System.getProperty("user.dir"));
      File[] listOfFiles = folder.listFiles();
      list.addItem("Select");
      try{
      for (int i = 0; i < listOfFiles.length; i++) {
         if (listOfFiles[i].isFile()) {
            if (listOfFiles[i].getName().endsWith(".ser")) {
               list.setEnabled(true);
               courseName = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().indexOf('.'));
               list.addItem(courseName);
            }
         }
      }
   }catch(NullPointerException e){}
   }

   public void actionPerformed(ActionEvent event) {
      String course;
            
      if (event.getSource() == (JButton) bOpen) {
         if(list.getSelectedItem().toString().equals("Select") && !text1.getText().equals("")) 
            course = text1.getText();
         else if (!list.getSelectedItem().toString().equals("Select") && text1.getText().equals(""))
            course = list.getSelectedItem().toString();
         else {
            JOptionPane.showMessageDialog(null, "Please either select an option or enter a new course name");
            return;
         }
      
         this.dispose();
         ExamManager examManager = new ExamManager(course);
         QuestionBankViewerFrame obj = new QuestionBankViewerFrame(examManager,course);
      }
   
   }}