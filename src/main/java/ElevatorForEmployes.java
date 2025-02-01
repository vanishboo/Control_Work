public class ElevatorForEmployes extends AbstractElevator {
    public ElevatorForEmployes(ElevatorState state, int currentFloor) {
        super(state, currentFloor);
    }

    @Override
    public boolean canGoTo(int floor) {
        return true;  // Лифт для сотрудников может поехать на любой этаж
    }
}
