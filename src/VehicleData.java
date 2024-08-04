import java.util.Scanner;

public class VehicleData {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Inventory");

        try {
            while (true) {
                System.out.println();
                System.out.print("Add a new vehicle? (Y/N): ");
                Scanner scn = new Scanner(System.in);
                String answer = scn.nextLine();

                if (answer.equalsIgnoreCase("Y")){
                    Vehicle.addVehicle();
                } else if (answer.equalsIgnoreCase("N")){
                    System.out.println("Current vehicle inventory will be printed to a text file.");
                    System.out.println();
                    Vehicle.printTxt();
                    break;
                } else {
                    System.out.println("Please enter 'Y' or 'N'");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

