
public class FillBlankQ extends Question {
   private String correctAnswer;

   public FillBlankQ(String text, String qID, double pGrade, String correctAnswer) {
      super(text, qID, pGrade); this.correctAnswer = correctAnswer;
   }


   public FillBlankQ(Question q) {
      super(q); this.correctAnswer = ((FillBlankQ)q).correctAnswer;
   }

   public String formattedQ () {
      return String.format("Fill the following blank \n %s: %s\n", qID, text);
   }

   public String formattedQwithA () {
      return formattedQ() + String.format("Correct Answer is: %s\n", correctAnswer);
   }

}