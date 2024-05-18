import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_FLOORS = 10;
        final int NUM_ELEVATORS = 3;  // Добавим поддержку 3 лифтов
        Building building = new Building(NUM_FLOORS, NUM_ELEVATORS);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            building.display();
            System.out.print("Enter target floor (0-" + (NUM_FLOORS - 1) + ") or -1 to quit: ");
            int floor = scanner.nextInt();

            if (floor == -1) {
                break;
            } else if (floor >= 0 && floor < NUM_FLOORS) {
                building.requestElevator(floor);
                while (true) {
                    building.moveElevators();
                    building.display();
                    if (building.requestedElevatorCurrentFloor(floor) == floor) {
                        break;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Invalid floor. Please enter a number between 0 and " + (NUM_FLOORS - 1) + ".");
            }
        }
        scanner.close();
    }
}
