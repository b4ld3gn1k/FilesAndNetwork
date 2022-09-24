package Encapsulation;

public class Elevator {
    int currentFloor;
    int maxFloor;
    int minFloor;

    public Elevator(int minFloor, int maxFloor){
        currentFloor = 1;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor){

        if (minFloor <= floor && floor <= maxFloor){
        } else {
            System.out.println("ERROR!");
            floor = currentFloor;
        }

        while (currentFloor < floor) {

            moveUp();
            System.out.println("Текущий этаж: " + currentFloor);
        }

        while (currentFloor > floor) {

            moveDown();
            System.out.println("Текущий этаж: " + currentFloor);
        }

    }

}
