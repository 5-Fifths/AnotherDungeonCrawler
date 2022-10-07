import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class Menu {
   private static final String[] playableClasses = {"Rogue", "Warrior", "Wizard", "Ranger"};

   public static void main(String[] args) throws FileNotFoundException {
      /*
         mainMenu(); // new save, load, exit
             new 
                 -> createCharacter(); // determine class, name, save into file
             load 
                 -> pullCharacter(); // load in class, stats, name
             exit 
                 -> quit();
      */
      
      Scanner console = new Scanner(System.in);
      PrintStream playerSave = new PrintStream(new File("playerData.txt")); // move to new character creation only
      
      createCharacter(console, playerSave);
      System("cls");
      quit();
   }
   
   // public static void printMenu();
   
   private static void createCharacter(Scanner console, PrintStream playerSave) {
      String name = "name";
      String charClass = "class";
      
      System.out.print("Name: ");
      name = console.nextLine();
      
      System.out.println("Classes: ");
      for (String playable : playableClasses)
         System.out.println('\t' + playable);
      System.out.println();
      
      while (
               !charClass.toLowerCase().equals("rogue") &&
               !charClass.toLowerCase().equals("wizard") &&
               !charClass.toLowerCase().equals("warrior") &&
               !charClass.toLowerCase().equals("ranger")
      ) {
         System.out.print("Select a class: ");
         charClass = console.next();
      }
      
      playerSave.println(name);
      playerSave.println(charClass);
   }
   
   private static void pullCharacter() {}
   
   private static void quit() {
      System.out.println("Farewell, traveler.");
      System.exit(0);
   }
}