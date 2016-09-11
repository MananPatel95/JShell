package test;

import commands.Popd;
import commands.PushD;
import fileSystem.*;
/**
 * integration testing for Popd command with JShell, FileSystem, and MyStack
 * @author Manan
 *
 */
public class PopdTest {
  /** testing popd methods via integration testing
   * @param args
   */
  public static void main(String args[]) {
    // test creation of object
    Popd PopdCommand = new Popd();
    PushD PushdCommand = new PushD();
    // should print out type of class as History
    System.out.println("Class is of type: " + PopdCommand.getClass()+ "\n");
    
    /* test adding a bunch of files to fileSystem, then trying to push a DIR
     * onto the stack
     */
    FileSystem fs = FileSystem.getFileSystemFp();
    Directory dir = new Directory("new");
    Directory a1 = new Directory("a1");
    Directory a2 = new Directory("a2");
    Directory a3 = new Directory("a3");
    File file1 = new File("story of Baskin Robbins", "file1");
    File file2 = new File("story of Ben and Jerrys", "file2");
    dir.addDir(a1);
    a1.addDir(a2);
    dir.addDir(a3);
    a1.setParent(dir);
    a2.setParent(a1);
    a3.setParent(dir);
    a2.addFile(file2);
    dir.addFile(file1);
    fs.getCurrentWorkingDirectory().addDir(dir);
    fs.setCurrentWorkingDirectory(a1);
    System.out.println("Current working Dir is A1, executing pushd a2"
          + "\nSucess!\n");
    PushdCommand.execute("a2");
    System.out.println("Current working Dir is A2, executing popd, should"
        + " return the top entry from\nthe stack (A1) and change the "
        + "working dir to A1");
    PopdCommand.execute();
    System.out.println(fs.getCurrentWorkingDirectory() + " Sucess!\n");
    System.out.println();
    
    /* Test the man page method for PushD
     */
    PopdCommand.manual();
  }
  
}
