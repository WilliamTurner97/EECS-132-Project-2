/* William Turner. Contains the methods asked for in the homework instructions*/
public class HW2 {
  
  // tells whether or not every open parentheses has a closing parentheses
  public static boolean matchingParentheses(String s) {
    
    // will be 0 if there are the same number of opening and closing parentheses
    int matches = 0;
   
    // the cumulative value of the indices of all opening parentheses
    int lengthopen = 0;
   
    // the cumulative value of the indices of all closing parentheses
    int lengthclosed = 0;
   
    int i;
   
    /* preconditions: matches = 0, lengthopen = 0, and lengthclosed = 0. Goal: for matches to be 0 if there are
     * the same number of '(' and ')' parentheses and for lengthclosed to be greater than lengthopen if every
     opening parentheses has a corresponding closing parentheses.*/
     
    for(i = 0; i < s.length(); i++) {
    
      if (s.charAt(i) == '(' ) {
    	  
        matches++;
        lengthopen = lengthopen + i;
      }
    
      if (s.charAt(i) == ')' ) {
    	  
        matches--;
        lengthclosed = lengthclosed + i;
      }  
    }
   
    if (matches == 0 && lengthopen <= lengthclosed)
      return true;
   
    else
      return false; 
  }
  
  // returns a StringBuilder containing every nth element from a point expect every xth element from the point
  public static StringBuilder everyNthExcept(String string, int start, int skip, int except) {
    
    int i;
  
    // the stringbuilder that will be returned
    StringBuilder returnstring = new StringBuilder("");
  
    if (string.equals(""))
      return returnstring;
  
    else {
  
      returnstring.append(string.charAt(start-1));
  
    /* Goal: Append every character for which i is divisible by skip and not divisible by except.
     * Iteration subgoal: append character at i if it meets the correct requirements */
    for(i = start - 1; i < string.length(); i++) {
    
      if( (i-(start-1)) % skip == 0 && (i-(start-1)) % except != 0)
       
        returnstring.append(string.charAt(i)); 
    }
  
    return returnstring;
    } 
  }
  
  // flips every other interval of k characters
  public static StringBuilder flipEachK(String s, int k) {
   
    // the StringBuilder that will later be converted into the string that is returned
    StringBuilder returnstring = new StringBuilder("");
   
    /* Goal: run through the string in intervals of k; run different loops if the interval
     *  is to be added to the returnstring directly or reversed first
     * Iteration subgoal: Append interval of k characters in order if the loop has run an even number of times 
     * and in reverse if the loop has run an odd number of times*/
         
    for(int i = 0; i < s.length(); i = i + k) {
     
      if ((i/k) % 2 == 0) {
        
        /* Goal: append next k characters if there are k characters remaining in string; otherwise, append all remaining characters.
         * Iteration subgoal: append character at index (i+m)*/
        for(int m = 0; ((m < k) && m < ((s.length()-i) - 1)); m++){
          
          returnstring.append(s.charAt(i+m));
        }      
      }
      
      else {
        
        int n = 0;
         
        // determines correct n based on whether or not there are at least k characters remaining
        if (i+k+1 <s.length())
          n = k;
        
          else
            n = (s.length()-i) - 1;
       
        /* Goal: append next k characters in reverse order if there are k characters remaining;
         *  otherwise, append all remaining characters in reverse order.
         *  Iteration subgoal: append character at index (i+n-1)*/
        for(n = n; n > 0; n--) {
         
          returnstring.append(s.charAt(i+n-1));
        }
      }
    }
    return returnstring;   
  }  
}