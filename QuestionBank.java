
import java.io.*;
public class QuestionBank implements Serializable {

   private String courseName;
   private int nOfQ;
   private Question [] qList;
	
   public QuestionBank (String courseName) {
      this.courseName = courseName;
      qList = new Question[100];
   }

   public String getCourseName() {
      return courseName;
   }

   public Question[] getqList() { //check
      Question [] ql = new Question [100];
      for (int i=0; i<nOfQ; i++)
         if (qList[i] instanceof FillBlankQ)
            ql[i] = new FillBlankQ (qList[i]);
         else if (qList[i] instanceof MCQ)
            ql[i] = new MCQ (qList[i]);
         else if (qList[i] instanceof TrueFalseQ)
            ql[i] = new TrueFalseQ (qList[i]);
      return ql;
   }
	
   public int getnOfQ() {
      return nOfQ;
   }
	
   public int findQuestion (Question q) {
      for (int i=0; i<nOfQ; i++)
         if(qList[i] != null)
         
            if ( (qList[i].getqID().equals(q.getqID())) || (qList[i].getText().equals(q.getText())))
               return i;
      return -1;
   }
	
   public boolean addQuestion (Question q) {
      if (qList.length == nOfQ) 
         return false;
      if (findQuestion(q) != -1 ) 
         return false;
   	
      if (q instanceof FillBlankQ)
         qList[nOfQ++] = new FillBlankQ (q);
      if (q instanceof MCQ)
         qList[nOfQ++] = new MCQ (q);
      if (q instanceof TrueFalseQ)
         qList[nOfQ++] = new TrueFalseQ (q);
      return true;
   }
	
   
   public Question[] getRandomQuestions (int n) throws IllegalArgumentException { //check
      if (nOfQ < n) throw new IllegalArgumentException();
      Question[] qs = new Question [n]; 
      
      int[] num = new int [n];
      int k=0;
      for (int i = 0; i < n; i++) {
         num[i] = (int)(Math.random()*nOfQ);
         for (int j = 0; j < i; j++) {
            if (num[i] == num[j]) {
               i--; 
               break;
            }}}
        
        
      for ( int i = 0; i< n ; i++ ){
          if(qList[num[i]] != null){
         if (qList[num[i]] instanceof FillBlankQ)
            qs[k++] = new FillBlankQ (qList[num[i]]);
         if (qList[num[i]] instanceof MCQ)
            qs[k++] = new MCQ (qList[num[i]]);
         if (qList[num[i]] instanceof TrueFalseQ)
            qs[k++] = new TrueFalseQ(qList[num[i]]);
         }
      }
      return  qs;
   }
       
   public int countChapterQuestions(String cName) {
   
      cName = cName.toLowerCase();      
      int count = 0;
      for (int i = 0; i < nOfQ; i++) {
         if(qList[i] != null){
            String qID = qList[i].qID;
            String chapter = qID.substring(0, qID.indexOf('_')).toLowerCase();
         
            if (chapter.equals(cName)) {
               count++;
            }
         }}//end loop
   
      return count;
   }

   public Question[] getChapterQuestions(int n, String cName) {
   
      cName = cName.toLowerCase();
      int count = 0;
      for (int i = 0; i < nOfQ; i++) {
         if( qList[i] != null ) 
         if (qList[i].qID.indexOf('_') != -1) 
            if (qList[i].qID.substring(0, qList[i].qID.indexOf('_')).toLowerCase().equals(cName)) {
               count++;
            }
      }
      int size=0;
      if( count < n ) 
         size =  count;
      else size =n;
      if(size == 0) throw new IllegalArgumentException();
      Question[] chapterQuestions = new Question[size];
      int j = 0;
      for (int i = 0 ; i < nOfQ && j < size; i++) {
         if(qList[i] != null){
         
            if (qList[i].qID.substring(0, qList[i].qID.indexOf('_')).toLowerCase().equals(cName)) {
            
               if (qList[i] instanceof FillBlankQ) {
               
                  chapterQuestions[j++] = new FillBlankQ(qList[i]);
               } else if (qList[i] instanceof MCQ) {
               
                  chapterQuestions[j++] = new MCQ(qList[i]);
               } else {
                  chapterQuestions[j++] = new TrueFalseQ(qList[i]);
               }
            
            }
         }}
   
      return chapterQuestions;
   }


   public void saveQuestions () throws IOException {
      FileOutputStream fos = new FileOutputStream (new File (courseName+".ser"));
      ObjectOutputStream obj = new ObjectOutputStream (fos);
      try{
         for (int i=0; i<nOfQ; i++)
            obj.writeObject(qList[i]);}
      finally{
         obj.close();}
   }
	
   public int loadQuestions (String fName) throws FileNotFoundException, IOException {
      if(!fName.substring(0,fName.indexOf('.')).equalsIgnoreCase(courseName)) 
         throw new IllegalArgumentException ();
   	
      int count = 0;
      FileInputStream fis = new FileInputStream (new File (fName));
      ObjectInputStream obj = new ObjectInputStream (fis);
   	
      try {
         while (nOfQ < qList.length) {
            qList[nOfQ++] = (Question) obj.readObject();
            count++;
         }
      } catch (ClassNotFoundException e) {
         System.out.println(e);
      } catch (EOFException e) {
         System.out.println("End of file");
      }
   	
      obj.close();
      return count;
   }
	

   void removeAllQuestion (String ids []) {
    for (int i=0; i<ids.length; i++)
                if(qList[i] != null)
         for(int j=0; j<nOfQ; j++)
               if (ids[i].equalsIgnoreCase(qList[j].getqID())) {
                  for(int k=j; k<nOfQ-1; k++)
                     qList[k] = qList[k+1];
                  qList[--nOfQ] = null;
                  break;
               }
               
         
   }

	
}