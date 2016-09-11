package test;

import commands.Cp;
import commands.Man;
import commands.Mkdir;

public class ManTest {
  
  public static void main(String args[]) {
    // test creation of object
    Man ManCommand1 = new Man();
    // should print out type of class as History
    System.out.println("Class is of type: " + ManCommand1.getClass() + "\n");
    
    /* All the commands have a manual method that describes the usage
     * To test, we will simply call a couple of the commands
     */
    Cp CpCommand = new Cp();
    Mkdir MkdirCommand = new Mkdir();

    System.out.println("Printing Cp manual:\n");
    CpCommand.manual();
    System.out.println("\n");
    
    System.out.println("Printing Mkdir manual:\n");
    MkdirCommand.manual();
    System.out.println("\n");

    // Test the man command object with some strings
    ManCommand1.execute("cd");
    System.out.println("\n");
    }
  }

