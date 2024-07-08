//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
// Also, sorry that the "Paste" feature no longer works! GitHub broke
// this (so we'll switch to a new provider): https://blog.github.com\
// /2018-02-18-deprecation-notice-removing-anonymous-gist-creation/
//*******************************************************************

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.Math; // headers MUST be above the first class
import java.util.Map;
import java.util.Scanner;
import java.util.function.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

// one class needs to have a main() method
public class HelloWorld
{
	public int funChallenge(String[] input) {
		  int a = 10;
		  a = 50 + 3;

		  for (int i = 0; i < input.length; i++) {
		    anotherFunction();
		    boolean stranger = true;
		    a++;
		  }
		  return a;
	}
	
	public void anotherFunction() {
		FileReader fileReader = null;
		Scanner scanner = null;
		try {
			File source = new File("resources/meta.csv");
			fileReader = new FileReader(source);
			scanner = new Scanner(source).useDelimiter("\\|");
			while ( scanner.hasNext() ) {
				System.out.println("Scanner next val: " + scanner.next());
			}
			fileReader.close();
			scanner.close();
			/*CSVFormat format = CSVFormat.
			CSVParser csvParser = new CSVParser(fileReader, format);*/
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			//scanner.close();
			
		}
		
	}
	
	// What is the Big O of the below function? (Hint, you may want to go line by line)
	//O(4 + 7n)
	public void anotherFunChallenge(int input) {
	  int a = 5;	//O(1) 
	  int b = 10;	//O(1)
	  int c = 50;	//O(1)
	  for (int i = 0; i < input; i++) {	//O(n)
	    int x = i + 1;	//O(n)
	    int y = i + 2;	//O(n)
	    int z = i + 3;	//O(n)

	  }
	  for (int j = 0; j < input; j++) {	//O(n)
	    int p = j * 2;	//O(n)
	    int q = j * 2;	//O(n)
	  }
	  String whoAmI = "I don't know";	//O(1)
	}
	
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    HelloWorld myObject = new HelloWorld("Hello World!");
    //System.out.print(myObject);
    String [] input = new String[100];
    System.out.println(myObject.funChallenge(input));
    myObject.anotherFunction();
    /*Consumer<String> c = x -> System.out.println(x.toUpperCase());
    c.accept("Hello World");
    Function<HelloWorld,String> f = HelloWorld::getMessage;
    System.out.println("Other class Message: " + f.apply(new HelloWorld("Hello There! How are you?")));
    BiFunction<String,String,String> f1 = (x,y) -> x.concat(y);//String::concat;
    System.out.println(f1.apply("Hello ", "Hi"));
    BiFunction<String,Integer,String> f2 = (x,y) -> x.substring(y);
    System.out.println(f2.apply("Hello World!!!!", 5));
    */
    
  }
//you can add other public classes to this editor in any order
 private String message;
 private boolean answer = false;
 public HelloWorld(String input)
 {
   message = "Why, " + input + " Isn't this something?";
 }
 public String toString()
 {
   return message;
 }
 
 public String getMessage() {
   return message;
 }
}


