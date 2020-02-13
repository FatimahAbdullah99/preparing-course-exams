
import java.util.*;
import java.io.*;
public class ExamManager implements Serializable {
   private QuestionBank qBank;

   public ExamManager (String courseName) {
      qBank = new QuestionBank(courseName);
      try {
         qBank.loadQuestions(courseName+".ser");
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      } catch (IOException e) {
         System.out.println("problem in finding the file");
      }
   }

   public QuestionBank getqBank() {
      return qBank;
   }

   public boolean addNewQuestion (Question q) {
      return qBank.addQuestion(q);
   }

   void removeChapterQuestions (String chapterName) {
      Question q [] = qBank.getChapterQuestions(qBank.countChapterQuestions(chapterName), chapterName);
      String [] id = new String [q.length];
      for(int i=0; i<q.length; i++)
         if(q[i] != null)
            id[i] = q[i].getqID();
      qBank.removeAllQuestion(id);
   }

   public double generateExam (String header, int n, String chapterName, boolean withAnswers ) throws FileNotFoundException {
      double grades = 0;
      FileOutputStream fos = new FileOutputStream (new File (qBank.getCourseName()+"Exam.txt"));
      PrintWriter pw = new PrintWriter (fos);
      try{
         pw.println(header);
         Question q[];
      
      
         if("".equals(chapterName)) 
            q = qBank.getRandomQuestions(n);
         else 
            q = qBank.getChapterQuestions(n, chapterName);
         for (int i=0; i<q.length; i++) {
            if(q[i] != null){
               grades += q[i].getpGrade(); 
               if (withAnswers)
                  pw.println(q[i].formattedQwithA());
               else
                  pw.println(q[i].formattedQ());
            }}}
      finally{ pw.close();}
      return grades;
   }

   public void exportQBank() throws IOException {
      qBank.saveQuestions();
   
   }

}