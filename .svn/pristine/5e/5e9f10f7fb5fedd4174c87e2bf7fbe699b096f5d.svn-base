package commands;


import java.lang.reflect.Method;
import java.util.Hashtable;

import fileSystem.FileSystem;

/**
 * Class for Man command
 * Returns information for other commands for user help as a string
 * @author Manan
 */

public class Man { 
  // create instances of obj's to call each commands' manual method
  FileSystem fileSys = FileSystem.getFileSystemFp();
  History HistoryCommand = new History();
  Cat CatCommand = new Cat();
  Cd CdCommand = new Cd();
  Cp CpCommand = new Cp();
  Curl CurlCommand = new Curl();
  Echo EchoCommand = new Echo();
  Exclamation ExclamationCommand = new Exclamation();
  Exit ExitCommand = new Exit();
  Grep GrepCommand = new Grep();
  Ls LsCommand = new Ls();
  Mkdir MkdirCommand = new Mkdir();
  Mv MvCommand = new Mv();
  Pwd PwdCommand = new Pwd();
  PushD PushdCommand = new PushD();
  Popd PopdCommand = new Popd();
  Redirection RedirCommand = new Redirection();
  
  /**
   * Default constructor doesnt do anything.
   */
  public Man(){}
  /**
   * Check what command is entered and call its respective manual method
   * that prints the information for that command
   * @param command
   * @return none, but prints to the console
   */
  public void execute(String command){
    //check what command it is and call that command's manual method
    if (command.equals("cd")){ CdCommand.manual(); }
    else if (command.equals("cat")){ CatCommand.manual(); }
    else if (command.equals("curl")){ CurlCommand.manual(); }
    else if (command.equals("echo")){ EchoCommand.manual(); }
    else if (command.equals("!")){ ExclamationCommand.manual(); }
    else if (command.equals("exit")){ ExitCommand.manual(); }
    else if (command.equals("grep")){ GrepCommand.manual(); }
    else if (command.equals("history")){ HistoryCommand.manual(); }
    else if (command.equals("ls")){ LsCommand.manual(); }
    else if (command.equals("man")){
      Man ManCommand = new Man();
      ManCommand.manual();
    }
    else if (command.equals("mkdir")){ MkdirCommand.manual(); }
    else if (command.equals("mv")){ MvCommand.manual(); }
    else if (command.equals("pushd")){ PushdCommand.manual(); }
    else if (command.equals("popd")){ PopdCommand.manual(); }
    else if (command.equals("pwd")){  PwdCommand.manual(); }
    else { System.out.println("Please enter a valid command."); }
  }
  
  /**
   * A method to return the manual for man. Will be called by Man command.
   * @param none
   * @return none
   */  
  public void manual()
  {
    System.out.println("Returns the information about the command "
        + "and how each is used.\n" + "usage: man " + "COMMAND\n");
  }

}