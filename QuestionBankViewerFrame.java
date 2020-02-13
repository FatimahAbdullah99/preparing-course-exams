

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
import java.util.*;

public class QuestionBankViewerFrame extends JFrame implements ActionListener {

	public JPanel jPanel1;
   public JPanel jPanel2;
   public JPanel jPanel3;
   public JPanel jPanel4;
	public JLabel label1;
   public JLabel label2;
   public JLabel label3;
   public JLabel label4;
   public JLabel label5;
   public JLabel label6;
   public JLabel label7;
   public JLabel label8;
   public JLabel label9;
	public JTextField text1;
   public JTextField text2;
   public JTextField text3;
   public JTextField text4;
   public JTextField text5;
   public JTextField text6;
   public JTextField text7;
   public JTextField text8;
   public JTextField text9;
   public JTextField text10;
   public JTextField text11;
   public JTextField text12;
	public JRadioButton radio1;
   public JRadioButton radio2;
   public JRadioButton radio3;
	public JButton bAdd;
   public JButton bExam;
   public JButton bRemove;
	public JCheckBox checkBox;
	public static JTextArea textArea;
	public JScrollPane scrolltxt;
	public ExamManager exam;



	public QuestionBankViewerFrame(ExamManager obj,String s) {
		exam = obj;
		addWindowListener(new CloseFrame());

		Container contentPane = getContentPane();

		setTitle(s+" Question Bank");
		setResizable(false);
		setSize(950, 600);
		contentPane.setLayout(null);
		this.setVisible(true);

		jPanel1 = new JPanel();
		jPanel1.setBorder(BorderFactory.createTitledBorder("Add a New Question"));
		jPanel1.setBounds(20, 110, 400, 400);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		jPanel2 = new JPanel();
		jPanel2.setBorder(BorderFactory.createTitledBorder("Generate Exam"));
		jPanel2.setBounds(430, 110, 500, 280);
		jPanel2.setLayout(null);
		contentPane.add(jPanel2);

		jPanel3 = new JPanel();
		jPanel3.setBorder(BorderFactory.createTitledBorder("Delete Chapter Questions"));
		jPanel3.setBounds(430, 400, 500, 110);
		jPanel3.setLayout(null);
		contentPane.add(jPanel3);

		label1 = new JLabel("Question Text");
		label1.setBounds(20, 20, 150, 30);
		jPanel1.add(label1);

		text1 = new JTextField();
		text1.setColumns(10);
		text1.setBounds(160, 20, 150, 20);
		jPanel1.add(text1);

		label2 = new JLabel("Quesetion ID");
		label2.setBounds(20, 50, 150, 30);
		jPanel1.add(label2);

		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(160, 50, 150, 20);
		jPanel1.add(text2);

		label3 = new JLabel("Possible Grade");
		label3.setBounds(20, 80, 150, 30);
		jPanel1.add(label3);

		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(160, 80, 150, 20);
		jPanel1.add(text3);

		label4 = new JLabel("Choose the type of the question:");
		label4.setBounds(20, 100, 200, 50);
		jPanel1.add(label4);

		radio1 = new JRadioButton("MCQ");
		radio1.setBounds(30, 140, 80, 40);
		jPanel1.add(radio1);
		radio1.addActionListener(this);

		radio2 = new JRadioButton("True/False");
		radio2.setBounds(110, 140, 100, 40);
		jPanel1.add(radio2);
		radio2.addActionListener(this);

		radio3 = new JRadioButton("Fill Blank");
		radio3.setBounds(210, 140, 80, 40);
		jPanel1.add(radio3);
		radio3.addActionListener(this);

		label5 = new JLabel("Correct Answer");
		label5.setBounds(20, 190, 150, 30);
		jPanel1.add(label5);

		text4 = new JTextField();
		text4.setColumns(10);
		text4.setBounds(160, 195, 150, 20);
		jPanel1.add(text4);

		jPanel4 = new JPanel();
		jPanel4.setBorder(BorderFactory.createTitledBorder("Answers for MCQ"));
		jPanel4.setBounds(20, 230, 220, 160);
		jPanel4.setLayout(null);
		jPanel1.add(jPanel4);

		text9 = new JTextField();
		text9.setColumns(50);
		text9.setBounds(20, 30, 180, 20);
		jPanel4.add(text9);

		text10 = new JTextField();
		text10.setColumns(50);
		text10.setBounds(20, 60, 180, 20);
		jPanel4.add(text10);

		text11 = new JTextField();
		text11.setColumns(50);
		text11.setBounds(20, 90, 180, 20);
		jPanel4.add(text11);

		text12 = new JTextField();
		text12.setColumns(50);
		text12.setBounds(20, 120, 180, 20);
		jPanel4.add(text12);

		bAdd = new JButton("Add Question");
		bAdd.setBounds(250, 340, 120, 30);
		jPanel1.add(bAdd);
		bAdd.addActionListener(this);

		label6 = new JLabel("Exam Header");
		label6.setBounds(20, 20, 150, 30);
		jPanel2.add(label6);

		text5 = new JTextField();
		text5.setColumns(10);
		text5.setBounds(160, 20, 150, 20);
		jPanel2.add(text5);

		label7 = new JLabel("Number of Questions");
		label7.setBounds(20, 50, 150, 30);
		jPanel2.add(label7);

		text6 = new JTextField();
		text6.setColumns(10);
		text6.setBounds(160, 50, 150, 20);
		jPanel2.add(text6);

		label8 = new JLabel("Chapter Name");
		label8.setBounds(20, 80, 150, 30);
		jPanel2.add(label8);

		text7 = new JTextField();
		text7.setColumns(10);
		text7.setBounds(160, 80, 150, 20);
		jPanel2.add(text7);

		checkBox = new JCheckBox("With Answers");
		checkBox.setBounds(160, 100, 120, 70);
		jPanel2.add(checkBox);

		bExam = new JButton("Generate Exam");
		bExam.setBounds(320, 125, 140, 20);
		jPanel2.add(bExam);
		bExam.addActionListener(this);

		textArea = new JTextArea();
		scrolltxt = new JScrollPane(textArea);
		scrolltxt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrolltxt.setBounds(20, 170, 450, 100);
		jPanel2.add(scrolltxt);

		label9 = new JLabel("Chapter Name");
		label9.setBounds(20, 40, 150, 30);
		jPanel3.add(label9);

		text8 = new JTextField();
		text8.setColumns(10);
		text8.setBounds(150, 45, 150, 20);
		jPanel3.add(text8);

		bRemove = new JButton("Remove");
		bRemove.setBounds(320, 45, 140, 20);
		jPanel3.add(bRemove);
		bRemove.addActionListener(this);

		jPanel4.setVisible(false);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void clearTexts() {
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		text5.setText("");
		text6.setText("");
		text7.setText("");
		text8.setText("");
		text9.setText("");
		text10.setText("");
		text11.setText("");
		text12.setText("");
		radio1.setSelected(false);
		radio2.setSelected(false);
		radio3.setSelected(false);
		//textArea.setText("");
		checkBox.setSelected(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == (JRadioButton) radio1) {
			radio1.setSelected(true);
			radio2.setSelected(false);
			radio3.setSelected(false);
			jPanel4.setVisible(true);
		} else if (e.getSource() == (JRadioButton) radio2) {
			radio1.setSelected(false);
			radio2.setSelected(true);
			radio3.setSelected(false);
			jPanel4.setVisible(false);
		} else if (e.getSource() == (JRadioButton) radio3) {
			radio1.setSelected(false);
			radio2.setSelected(false);
			radio3.setSelected(true);
			jPanel4.setVisible(false);
		}

		if (e.getSource() == (JButton) bAdd) {

			try {
				if (text1.getText().length() == 0 || text2.getText().length() == 0 || text3.getText().length() == 0|| text4.getText().length() == 0) {

					JOptionPane.showMessageDialog(this, "Please enter all the information ♡");
					return;
				}
            if ( !(text2.getText().startsWith("ch"))|| (text2.getText().indexOf('_') == -1) ) {

					JOptionPane.showMessageDialog(this, "Please enter a correct Question ID ♡");
					return;
				}
				Question q = null;
				String[] answers = new String[4];

				if (radio1.isSelected()) {

					if (text9.getText().length() == 0 || text10.getText().length() == 0|| text11.getText().length() == 0 || text12.getText().length() == 0) {

						JOptionPane.showMessageDialog(this, "Please fill all choices ♡");
						return;
					}
					answers[0] = text9.getText();
					answers[1] = text10.getText();
					answers[2] = text11.getText();
					answers[3] = text12.getText();

					q = new MCQ(text1.getText(), text2.getText(), Double.parseDouble(text3.getText()), Integer.parseInt(text4.getText()), answers);

					if (exam.addNewQuestion(q))
						JOptionPane.showMessageDialog(this, "Question added successfully!✓");
					else
						System.out.print("SORRY!✖ the array is full or question already exist");

				} else if (radio2.isSelected()) {

					q = new TrueFalseQ(text1.getText(), text2.getText(), Double.parseDouble(text3.getText()),Boolean.parseBoolean(text4.getText()));

					if (exam.addNewQuestion(q))
						JOptionPane.showMessageDialog(this, "Question added successfully!✓");
					else
						System.out.print("SORRY!✖ the array is full or question already exist");

				} else if (radio3.isSelected()) {

					q = new FillBlankQ(text1.getText(), text2.getText(), Double.parseDouble(text3.getText()),
							text4.getText());
					if (exam.addNewQuestion(q))
						JOptionPane.showMessageDialog(this, "Question added successfully!✓");
					else
						JOptionPane.showMessageDialog(this, "SORRY!✖ the array is full or question already exist");

				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "✖ NumberFormatException ✖");
				return;
			} finally {
				clearTexts();
            textArea.setText("");
			}

		}

		if (e.getSource() == (JButton) bExam) {

			try {

				if (text5.getText().length() == 0 || text6.getText().length() == 0) {

					JOptionPane.showMessageDialog(this, "Please enter all the information ♡");
					return;
				}
                                String chapterName;
                                String header= text5.getText();
                                int num = Integer.parseInt(text6.getText());
                                if (text7.getText().length() == 0)
                                    chapterName = "";
                                else
                                    chapterName = text7.getText().trim();
                                boolean withAnswer = checkBox.isSelected();
                                double total;
                                try {
                                total = exam.generateExam(header, num, chapterName, withAnswer);
                                } catch (IllegalArgumentException ex){
                                    JOptionPane.showMessageDialog(null, "Oops!\nThere is no questions under this chapter");
                                    clearTexts();
                                    textArea.setText("");
                                    return;
                                }
                                String fname = exam.getqBank().getCourseName() + "Exam.txt";
                                Scanner file = new Scanner ( new File ( fname ) );
                                      textArea.setText("");

                                do {
                                textArea.append(file.nextLine()+"\n");
                                } while ( file.hasNext() );
                                file.close();
                                clearTexts();

                               //end of try

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "✖ NumberFormatException ✖");
				return;
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "File Not Found!");
				return;
			}
		}

		if (e.getSource() == (JButton) bRemove) {

			String delete = text8.getText();

if (delete.equalsIgnoreCase("")){
JOptionPane.showMessageDialog(null, "Please enter all the information ♡", "Error",JOptionPane.ERROR_MESSAGE);
return;
}

 else{ 
int num  = exam.getqBank().countChapterQuestions(delete);
if(num != 0){
 exam.removeChapterQuestions(delete);
JOptionPane.showMessageDialog(null, "Chapter deleted successfully!✓", "Done!", JOptionPane.INFORMATION_MESSAGE);
text8.setText("");
textArea.setText("");

}else JOptionPane.showMessageDialog(null, "Oops\nThere is no quetions uder this name ", "Done!",JOptionPane.INFORMATION_MESSAGE);
}
}
}
   

	class CloseFrame extends WindowAdapter {

		public void windowClosing(WindowEvent evt) {
			int answer = JOptionPane.showConfirmDialog(null, "save the changes?", "Alert!",JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				try {
					exam.exportQBank();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "error while saving questions of this course");
				}
				JOptionPane.showMessageDialog(null,"♡ Thank you ♡\n" + "All questions have been saved. ");

			} else
				JOptionPane.showMessageDialog(null, "Thank you for using the Exam Manager.");
		}
	}

}

/*
if (text8.getText().length() == 0) {

				JOptionPane.showMessageDialog(this, "Please enter all the information ♡");
				return;
            
            
			} else JOptionPane.showMessageDialog(null, "There is no quetions uder this name! ", "Done!",JOptionPane.INFORMATION_MESSAGE);

         exam.removeChapterQuestions(text8.getText());
			JOptionPane.showMessageDialog(this, "Chapter deleted successfully!✓");
         textArea.setText("");
			clearTexts();
*/
