public class Elevator {
    private int currentFloor;
    private int targetFloor;
    private boolean movingUp;
    private int id;  // уникальный идентификатор лифта

    public Elevator(int id) {
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.movingUp = true;
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
        this.movingUp = targetFloor > currentFloor;
    }

    public void move() {
        if (currentFloor < targetFloor) {
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            currentFloor--;
        }
    }

    public boolean isIdle() {
        return currentFloor == targetFloor;
    }

    public int getId() {
        return id;
    }
}
