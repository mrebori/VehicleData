import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle> {
    private String make;
    private String model;
    private double milesGallon;

    //parameterized Constructor
    public Vehicle(String make, String model, double milesGallon) {
        this.make = make;
        this.model = model;
        this.milesGallon = milesGallon;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getMilesGallon() {
        return milesGallon;
    }

    @Override
    public int compareTo(Vehicle other) {
        return Double.compare(this.milesGallon, other.milesGallon);
    }

    @Override
    public String toString() {
        return "Vehicle make: " + make + "; Model: " + model + "; MPG: " + milesGallon + ".";
    }

    static LinkedList<Vehicle> carList = new LinkedList<>();

    static Scanner scan = new Scanner(System.in);

    public static String addVehicle() {
        try {
            System.out.println("Please enter the new vehicle's information:");

            System.out.print("Make: ");        // Add Make
            String make = scan.nextLine();

            System.out.print("Model: ");      // Add Model
            String model = scan.nextLine();

            double milesGallon = 0.0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Miles per Gallon (MPG): ");
                String mpgInput = scan.nextLine();
                try {
                    milesGallon = Double.parseDouble(mpgInput);
                    if (milesGallon > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid Input: MPG must be greater than 0.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Invalid Input: MPG must be a numeric value.");
                }
            }
            carList.add(new Vehicle(make, model, milesGallon));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "Vehicle data added successfully to inventory.";
    }

    public static void printTxt() {
        // Sort the vehicles by miles per gallon
        Collections.sort(carList);

        // Write sorted vehicles to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt"))) {
            for (Vehicle vehicle : carList) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred, file could not be saved.");
        }
        System.out.println("Vehicle inventory (sorted by MPG) is now available on vehicles.txt");
    }
}
