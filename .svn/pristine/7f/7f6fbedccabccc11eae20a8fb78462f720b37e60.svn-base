package test;

import commands.Exclamation;
import commands.History;

/**
 * Testing for exclamation command using integration testing
 * @author Manan
 *
 */
public class ExclamationTest {
  // Testing for exclamation command using integration testing
  public static void main(String[] args){
 // test creation of object
    Exclamation ExclamationCommand = new Exclamation();
    // should print out type of class as History
    System.out.println("Class is of type: " + ExclamationCommand.getClass()+
        "\n");
    
    // create a history with some commands to call from
    History HistoryCommand = new History();
    HistoryCommand.add("cat a1");
    HistoryCommand.add("cd pls");
    HistoryCommand.add("history");
    HistoryCommand.execute();
    System.out.println("\n");
    
    // test executing the 2nd entry which was cd pls
    ExclamationCommand.execute(2);
    
    /* Test the man page method for History
     */
    ExclamationCommand.manual();
    System.out.println("\n");
  }
}
