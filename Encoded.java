//class declaration
public class Encoded{  //public-can accessed to other classes
//Data field(instance variable)- to store information
  private String inputText; // declare to store the string that the user wants to encode
  private int charCount; //declare to keep track the number of non-space characters in inputText
  private String resultText; //declare to store the encoded version of the inputtext
  private final String groupID="G04/SE-G04"; //the secret group ID,fixed and hidden

  //constructor without any input,sets defoult values
  public Encoded(){
   this.inputText= ""; // start with an empty string
    this.charCount= 0;  //no characters yet
    this.resultText= ""; // no encoded text yet
    
  }
//constructor with an input string provided by the user
  public Encoded(String inputText) {
      this.inputText= inputText; //store the provided string
      this.charCount= 0;  //initially zero, will count later
      this.resultText= ""; //empty untill encoding
  }
 //getters and setters method (for access)
  public String getInputText() {  //It returns the current value of inputText
    return inputText;  
  }
  public void setInputText(String inputText) { //it allows other parts of the program to set a new value of inputText
      this.inputText= inputText; //to refer to the instance variable and assigns it the value passed as a parameter
  }
  public int getCharCount(){ //it returns the current count of non-space characters
    return charCount;
  }
  public Steing getResultText(){//return encoded string
    return resultText;
  }
}
