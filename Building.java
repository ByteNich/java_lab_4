import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Elevator> elevators;
    private final int numFloors;

    public Building(int numFloors, int numElevators) {
        this.numFloors = numFloors;
        this.elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i + 1));  // лифт получает ID
        }
    }

    public void requestElevator(int targetFloor) {
        Elevator closestElevator = getClosestElevator(targetFloor);
        closestElevator.setTargetFloor(targetFloor);
    }

    public int requestedElevatorCurrentFloor(int targetFloor) {
        Elevator closestElevator = getClosestElevator(targetFloor);
        return closestElevator.getCurrentFloor();
    }

    private Elevator getClosestElevator(int floor) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }
        return closestElevator;
    }

    public void moveElevators() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }

    public void display() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = numFloors - 1; i >= 0; i--) {
            StringBuilder floorDisplay = new StringBuilder("|");
            for (Elevator elevator : elevators) {
                char elevChar = elevator.getCurrentFloor() == i ? (char) ('0' + elevator.getId()) : ' ';
                floorDisplay.append(elevChar).append(' ');
            }
            floorDisplay.append('|');
            System.out.println(floorDisplay);
        }
        System.out.println("=====");
    }
}
