package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import driver.Validator;
import exceptions.InvalidDirectoryPath;

/**
 * ! class that takes an index in the history and executes that command
 * @author Manan
 *
 */
public class Exclamation {
  
  Cat CatCommand = new Cat();
  Cd CdCommand = new Cd();
  Curl CurlCommand = new Curl();
  Cp CpCommand = new Cp();
  Echo EchoCommand = new Echo();
  //Exclamation ExclamationCommand = new Exclamation();
  Grep GrepCommand = new Grep();
  History HistoryCommand = new History();
  Ls LsCommand = new Ls();
  LsRecursive LsRecCommand = new LsRecursive();
  Mkdir MkdirCommand = new Mkdir();
  Mv MvCommand = new Mv();
  Pwd PwdCommand = new Pwd();
  PushD PushdCommand = new PushD();
  Popd PopdCommand = new Popd();
  Redirection RedirCommand = new Redirection();

  /**
   * Default constructor for exclamation class
   */
  public Exclamation () {}
  
  /**
   * Helper for cat command that is called by main to run the command
   * @param isValid
   */
  public void catHelper(String[] isValid){
    String[] path = Arrays.copyOfRange(isValid, 2, isValid.length);
    List<String> listPath = new ArrayList<String>(Arrays.asList(path));
    CatCommand.execute(listPath);  }
  
  /**
   * Helper for cd command that is called by main to run the command
   * @param isValid
   */
  public void cdHelper(String[] isValid) {
    CdCommand.execute(isValid[2]);  }
  
  /**
   * Helper for cp command that is called by main to run the command
   * @param isValid
   */
  public void cpHelper(String[] isValid) {
    try {
      CpCommand.execute(isValid[2], isValid[3]);
    } catch (InvalidDirectoryPath e) {
        System.out.println("Invalid directory path, try again");
    }
  }
  
  /**
   * Helper for curl command that is called by main to run the command
   * @param isValid
   */
  public void curlHelper(String[] isValid) {
    CurlCommand.execute(isValid[2]);
  }
  
  /**
   * Helper for echo command that is called by main to run the command
   * @param isValid
   */
  public void echoHelper(String[] isValid) {
    String[] path = Arrays.copyOfRange(isValid, 2, isValid.length);
    List<String> listPath = new ArrayList<String>(Arrays.asList(path));
    EchoCommand.execute(listPath);
  }
  
  /**
   * Helper for grep command that is called by main to run the command
   * @param isValid
   */
  public void grepHelper(String[] isValid) {
    String[] grepList = Arrays.copyOfRange(isValid, 2, isValid.length);
    List<String> grepList1 = 
        new ArrayList<String>(Arrays.asList(grepList));
    GrepCommand.execute(grepList1); 
  }
  
  /**
   * Helper for history command that is called by main to run the command
   * @param isValid
   */
  public void historyHelper(String[] isValid){
    if (isValid[1].equals("history") && isValid[2] == null) {
      HistoryCommand.execute();
    }
    // if the command is history and a number, convert that string to an
    // int and pass it to the executeUpto method
    else if (isValid[1].equals("history") && isValid.length == 3) {
      int historyIndex = 0;
      try {
        historyIndex = Integer.parseInt(isValid[2]);
      } 
      //if the history index is not an int
      catch (NumberFormatException e) {
        System.out.println("Index for history is invalid");
      }
      HistoryCommand.executeUpto(historyIndex);
    }
  }
  
  /**
   * Helper for ls command that is called by main to run the command
   * @param isValid
   */
  public void lsHelper(String[] isValid){
    if (isValid[2].equals("-r") || isValid[2].equals("-R")){
      try{
        String[] path = Arrays.copyOfRange(isValid, 3, isValid.length);
        LsRecCommand.execute(path);
      }
      catch (InvalidDirectoryPath e){
        System.out.println("Folder doesnt exist in path, try again");
      }
    }
    else {
      try{
      String[] path = Arrays.copyOfRange(isValid, 2, isValid.length);
      LsCommand.execute(path);
      }
      catch (InvalidDirectoryPath e){
        System.out.println("Folder doesnt exist in path, try again");
      }
    }
  }
  
  /**
   * Helper for man command that is called by main to run the command
   * @param isValid
   */
  public void manHelper(String[] isValid){
    try {
      Man ManCommand = new Man();
      ManCommand.execute(isValid[2]);
      }
      catch (NullPointerException e) {
        System.out.println("Man lacks Command input\n"
            + "Usage: Man Command");
      }
  }
  
  /**
   * Helper for mv command that is called by main to run the command
   * @param isValid
   */
  public void mvHelper(String[] isValid){
    try {
      MvCommand.execute(isValid[2], isValid[3]);
    } catch (InvalidDirectoryPath e) {
      System.out.println("Invalid paths, try again");
    }
  }
  
  public void mkdirHelper(String[] isValid){
    String[] path = Arrays.copyOfRange(isValid, 2, isValid.length);
    List<String> listPath = new ArrayList<String>(Arrays.asList(path));
    MkdirCommand.execute(listPath);
  }
  
  public void popdHelper(String[] isValid){
    PopdCommand.execute();
  }
  
  public void pushdHelper(String[] isValid){
    PushdCommand.execute(isValid[2]);
  }
  
  public void pwdHelper(String[] isValid){
    PwdCommand.execute();
  }
  /**
   * Main funtion for ! command that gets the history input at numberInput
   * index, passes it to validator, reads the validator output and calls the 
   * appropriate helper method that executes that command
   * @param numberInput
   */
  public void execute(int numberInput) {
    int HistoryIndex = numberInput - 1; 
    String Command = History.history_array.get(HistoryIndex);
    Validator validator = new Validator();
    String[] validatorCommand = validator.ValidateCommand(Command);
    
    if (validatorCommand[1].equals("cat")){ catHelper(validatorCommand); }
    else if (validatorCommand[1].equals("cd")){ cdHelper(validatorCommand); }
    else if (validatorCommand[1].equals("cp")){ cpHelper(validatorCommand); }
    else if (validatorCommand[1].equals("curl")){ curlHelper(validatorCommand);}
    else if (validatorCommand[1].equals("echo")){ echoHelper(validatorCommand);}
    /* Assuming cant have 'exit' as a possbile input for ! because then it
    *  would turn off the shell
    */
    else if (validatorCommand[1].equals("grep")){ grepHelper(validatorCommand);}
    else if (validatorCommand[1].equals("history")){
      historyHelper(validatorCommand); }
    else if (validatorCommand[1].equals("ls")){ lsHelper(validatorCommand); }
    else if (validatorCommand[1].equals("man")){ manHelper(validatorCommand); }
    else if (validatorCommand[1].equals("mkdir")){
      mkdirHelper(validatorCommand);
    }
    else if (validatorCommand[1].equals("mv")){ mvHelper(validatorCommand); }
    else if (validatorCommand[1].equals("popd")){ popdHelper(validatorCommand);}
    else if (validatorCommand[1].equals("pushd")){
      pushdHelper(validatorCommand); }
    else if (validatorCommand[1].equals("pwd")){ pwdHelper(validatorCommand); }
    else {
      System.out.println("The command at that index was invalid, cant execute");
    }
  }

  public void manual() {
    System.out.println("! command gets the history input at number index,\n"
        + "passes it to validator, reads the validator output and calls the\n"
        + "appropriate helper method that executes that command.\n"
        + "Usage: !number");
  }
}

