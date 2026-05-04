//class declaration
public class Encoded{  //public-can accessed to other classes
//Data field(instance variable)- to store information
  private String inputText; // declare to store the string that the user wants to encode
  private int charCount; //declare to keep track the number of non-space characters in inputText
  private String resultText; //declare to store the encoded version of the inputtext
  private final String groupID="G04/SE-G04"; //the secret group ID,fixed and hidden

  //constructor without any input,sets defoult values
  //run when no value is given
  //to create an object with empty values.
  public Encoded(){
   this.inputText= ""; // set input text to  empty string
    this.charCount= 0;  //no characters yet
    this.resultText= ""; // no encoded text yet
    
  }
//constructor with an input string provided by the user
  //run when user gives a text
  public Encoded(String inputText) {
      this.inputText= inputText; //save the user input into the variable
      this.charCount= 0;  //initially zero, will count later
      this.resultText= ""; //empty untill encoding
  }
 //getters and setters method (for access)
  public String getInputText() {  //It returns the current value of inputText
    return inputText;  
  }
  public void setInputText(String inputText) { //it allows other parts of the program to set a new value of inputText
      this.inputText= inputText; //replace old text with new text
                                 //inputText=the new value from user
  }
  public int getCharCount(){ //it returns the current count of non-space characters
    return charCount;
  }
  public String getResultText(){//return encoded string
    return resultText;
  }
//Contributed by Rosfanida

  /*method for string validation:
    ensure letters are lowercase and allow digits and white space
    return true if input matches a-z, 0-9, and ' '
  */
  public boolean checkStringValidity(String text) {
    return text.matches("[a-z0-9 ]+");
  } 

  /*method to count characters input by user
    num is used for final shift
  */
  public int countCharacters(String text) {
    int count = 0;
    for (char c : text.toCharArray()) {
      if (c != ' ') {
        count++;
      }
      this.charCount = count; //update class field so can be easily called
      return count;
  }
    
  // method to generate unique integer based on groupID (G04/SE-G04)
  public int generateShift() {
    return Math.abs(groupID.hashcode() % 10) + 1;
    /*hashCode() turns groupID into a large integer
      %10 reduce it to its remainder
      Math.abs to ensure returned integer is positive
    */
  }
// Contributed by Sabrina
}
