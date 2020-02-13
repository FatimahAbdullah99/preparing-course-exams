
public class TrueFalseQ extends Question {
   private boolean correctAnswer;


   public TrueFalseQ(String text, String qID, double pGrade, boolean correctAnswer) {
      super(text, qID, pGrade); this.correctAnswer = correctAnswer;
   }

   public TrueFalseQ(Question q) {
      super(q); this.correctAnswer = ((TrueFalseQ)q).correctAnswer;
   }

   public String formattedQ () {
      return String.format("True or False \n %s: %s\n", qID, text);
   }

   public String formattedQwithA () {
      return formattedQ() + String.format("Correct Answer is: %s\n", correctAnswer);
   }



}