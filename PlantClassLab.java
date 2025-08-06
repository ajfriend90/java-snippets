import java.util.Scanner;
import java.util.ArrayList;
/*Take in input for plant/flower until terminal input and then print report.
 * This was a nice little simple lab to learn classes, inheritence, and arraylists.
 * One obstacle I had was after I had pretty much the whole thing written out,
 * it would run but produce no output. I kept thinking I was failing in my understanding
 * of classes, or inheritence, or how to manipulate arraylists. But nothing I tried worked.
 * Eventually I realized it was because I was using 'input == "plant"' in the conditional
 * in the loop, but it should be input.equals("plant"). So I realized I need to really
 * hammer in the syntax fundamentals, especially ones differing from python. 
 */
class Plant {
   protected String plantName;
   protected String plantCost;

   public void setPlantName(String userPlantName) {
      plantName = userPlantName;
   }

   public String getPlantName() {
      return plantName;
   }

   public void setPlantCost(String userPlantCost) {
      plantCost = userPlantCost;
   }

   public String getPlantCost() {
      return plantCost;
   }

   public void printInfo() {
      System.out.println("   Plant name: " + plantName);
      System.out.println("   Cost: " + plantCost);
   }
}

class Flower extends Plant {

   private boolean isAnnual;
   private String colorOfFlowers;

   public void setPlantType(boolean userIsAnnual) {
      isAnnual = userIsAnnual;
   }

   public boolean getPlantType(){
      return isAnnual;
   }

   public void setColorOfFlowers(String userColorOfFlowers) {
      colorOfFlowers = userColorOfFlowers;
   }

   public String getColorOfFlowers(){
      return colorOfFlowers;
   }
   
   @Override
   public void printInfo(){
      System.out.println("   Plant name: " + plantName);
      System.out.println("   Cost: " + plantCost);
      System.out.println("   Annual: " + isAnnual);
      System.out.println("   Color of flowers: " + colorOfFlowers);
   }
}

public class PlantClassLab {

   public static void printArrayList(ArrayList<Plant> userArrayList) {
      int plantCount = 1;
      for (Plant p : userArrayList) {
         System.out.println("Plant " + plantCount + " Information: ");
         p.printInfo();
         System.out.println();
         plantCount++;
      }
   }                                                       
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String input;
      ArrayList<Plant> myGarden = new ArrayList<Plant>();

      String plantName, plantCost, flowerName, flowerCost, colorOfFlowers;
      boolean isAnnual;
      
      System.out.print("Enter plant or flower in format\n" + 
                        "'plant plantName plantCost' or\n" + 
                        "'flower flowerName flowerCost isAnnual?(t/f) flowerColor" +
                        "Enter -1 to stop:\n");
      input = scnr.next();
      while(!input.equals("-1")){
         if (input.equals("plant")) {
            plantName = scnr.next();
            plantCost = scnr.next();
            Plant myPlant = new Plant();
            myPlant.setPlantName(plantName);
            myPlant.setPlantCost(plantCost);
            myGarden.add(myPlant);
            scnr.nextLine();
         } else if (input.equals("flower")) {
            flowerName = scnr.next();
            flowerCost = scnr.next();
            isAnnual = scnr.nextBoolean();
            colorOfFlowers = scnr.next();
            Flower myFlower = new Flower();
            myFlower.setPlantName(flowerName);
            myFlower.setPlantCost(flowerCost);
            myFlower.setPlantType(isAnnual);
            myFlower.setColorOfFlowers(colorOfFlowers);
            myGarden.add(myFlower);
            scnr.nextLine();
         }
         System.out.print("Enter plant or flower in format\n" + 
                        "'plant plantName plantCost' or\n" + 
                        "'flower flowerName flowerCost isAnnual?(t/f) flowerColor" +
                        "Enter -1 to stop:\n");
         input = scnr.next();
      }
      printArrayList(myGarden);
      scnr.close();
   }
}
