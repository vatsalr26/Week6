import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    String type;
    String manufacturer;
    String model;
    int maxSpeed;

    Vehicle(String type, String manufacturer, String model, int maxSpeed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return type + ": " + manufacturer + " " + model + "\n";
    }
}

class Engine {
    String name;
    int power;

    Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }
}

class Car extends Vehicle {
    Engine engine;

    Car(String manufacturer, String model, int maxSpeed) {
        super("Car", manufacturer, model, maxSpeed);
        this.engine = new Engine("V8", 300);
    }

    void drive() {
        System.out.println(manufacturer + " " + model + " blazing the way forward!");
    }

    @Override
    public String toString() {
        return super.toString() + "Engine: " + engine.name + " " + engine.power + "kW\n";
    }
}

class Plane extends Vehicle {
    Engine engine;

    Plane(String manufacturer, String model, int maxSpeed) {
        super("Plane", manufacturer, model, maxSpeed);
        this.engine = new Engine("Jet engine", 500);
    }

    void fly() {
        System.out.println(manufacturer + " " + model + " flying to the destination!");
    }

    @Override
    public String toString() {
        return super.toString() + "Engine: " + engine.name + " " + engine.power + "kW\n";
    }
}

class Ship extends Vehicle {
    Engine engine;

    Ship(String manufacturer, String model, int maxSpeed) {
        super("Ship", manufacturer, model, maxSpeed);
        this.engine = new Engine("Wärtsilä Super", 1000);
    }

    void sail() {
        System.out.println(manufacturer + " " + model + " sail to the ends of the seas!");
    }

    @Override
    public String toString() {
        return super.toString() + "Engine: " + engine.name + " " + engine.power + "kW\n";
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Create new vehicle, 2) List vehicles 3) Drive cars, 4) Fly planes, 5) Sail the ships, 0) End the program");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Thank you for using the program.");
                    return;
                case 1:
                    System.out.println("Which vehicle do you want to build? 1) car, 2) plane, 3) ship");
                    int vehicleChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Who is the manufacturer?");
                    String manufacturer = scanner.nextLine();
                    System.out.println("What is the model of the vehicle?");
                    String model = scanner.nextLine();
                    System.out.println("What is the top speed?");
                    int maxSpeed = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (vehicleChoice) {
                        case 1:
                            vehicles.add(new Car(manufacturer, model, maxSpeed));
                            break;
                        case 2:
                            vehicles.add(new Plane(manufacturer, model, maxSpeed));
                            break;
                        case 3:
                            vehicles.add(new Ship(manufacturer, model, maxSpeed));
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;
                case 2:
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }
                    break;
                case 3:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Car) {
                            ((Car) vehicle).drive();
                        }
                    }
                    break;
                case 4:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Plane) {
                            ((Plane) vehicle).fly();
                        }
                    }
                    break;
                case 5:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Ship) {
                            ((Ship) vehicle).sail();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
