
public class MCQ extends Question {
   private int correctAnswer;
   private String[] choices;

   public MCQ (String text, String qID, double pGrade, int correctAnswer, String[] choices) {
      super(text, qID, pGrade);
      this.correctAnswer = correctAnswer;
      this.choices = choices;
   }

   public MCQ (Question q ) {
      this (q.text, q.qID, q.pGrade, ((MCQ)q).correctAnswer, ((MCQ)q).choices);
   }

   public String formattedQ () {
      String str = "";
      str = String.format("Choose the correct answer: \n %s: %s\n", qID, text);
      for (int i=0; i<choices.length; i++)
         str += (i+1) + ": "+ choices[i] + "\n";
      return str;
   }

   public String formattedQwithA () {
      return formattedQ() + String.format("Correct Answer is: %s\n", correctAnswer);
   }
}
