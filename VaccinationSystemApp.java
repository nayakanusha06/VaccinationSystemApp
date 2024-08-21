import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Child {
    String name;
    int age;
    ArrayList<String> vaccinationRecords;
    
    Child(String name, int age) {
        this.name = name;
        this.age = age;
        this.vaccinationRecords = new ArrayList<>();
    }
    
    void addVaccination(String vaccine) {
        vaccinationRecords.add(vaccine);
    }
    
    void viewVaccinationRecords() {
        System.out.println("Vaccination Records for " + name + ":");
        if (vaccinationRecords.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (String record : vaccinationRecords) {
                System.out.println("- " + record);
            }
        }
    }
}

class VaccinationSystem {
    HashMap<String, Child> childrenRecords;
    
    VaccinationSystem() {
        childrenRecords = new HashMap<>();
    }
    
    void registerChild(String name, int age) {
        if (!childrenRecords.containsKey(name)) {
            Child newChild = new Child(name, age);
            childrenRecords.put(name, newChild);
            System.out.println("Child registered successfully.");
        } else {
            System.out.println("Child is already registered.");
        }
    }
    
    void addVaccinationRecord(String name, String vaccine) {
        Child child = childrenRecords.get(name);
        if (child != null) {
            child.addVaccination(vaccine);
            System.out.println("Vaccination record added successfully.");
        } else {
            System.out.println("Child not found.");
        }
    }
    
    void viewChildRecords(String name) {
        Child child = childrenRecords.get(name);
        if (child != null) {
            child.viewVaccinationRecords();
        } else {
            System.out.println("Child not found.");
        }
    }
    
    void scheduleVaccination(String name) {
        if (childrenRecords.containsKey(name)) {
            System.out.println("Vaccination appointment scheduled for " + name);
        } else {
            System.out.println("Child not found. Please register first.");
        }
    }
    
    // Method to view all vaccination records of one child
    void viewAllVaccinationRecords(String name) {
        Child child = childrenRecords.get(name);
        if (child != null) {
            System.out.println("\n--- Vaccination Records for " + name + " ---");
            child.viewVaccinationRecords();
        } else {
            System.out.println("Child not found.");
        }
    }
}

public class VaccinationSystemApp {
    public static void main(String[] args) {
        VaccinationSystem system = new VaccinationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- Child Vaccination System ---");
            System.out.println("1. Register Child");
            System.out.println("2. Add Vaccination Record");
            System.out.println("3. View Vaccination Records");
            System.out.println("4. Schedule Vaccination");
            System.out.println("5. View All Vaccination Records of a Child");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter child name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter child age: ");
                    int age = scanner.nextInt();
                    system.registerChild(name, age);
                    break;
                case 2:
                    System.out.print("Enter child name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter vaccine name: ");
                    String vaccine = scanner.nextLine();
                    system.addVaccinationRecord(name, vaccine);
                    break;
                case 3:
                    System.out.print("Enter child name: ");
                    name = scanner.nextLine();
                    system.viewChildRecords(name);
                    break;
                case 4:
                    System.out.print("Enter child name: ");
                    name = scanner.nextLine();
                    system.scheduleVaccination(name);
                    break;
                case 5:
                    System.out.print("Enter child name: ");
                    name = scanner.nextLine();
                    system.viewAllVaccinationRecords(name);
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}
