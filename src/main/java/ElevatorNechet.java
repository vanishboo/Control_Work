public class ElevatorNechet extends AbstractElevator {
    public ElevatorNechet(ElevatorState state, int currentFloor) {
        super(state, currentFloor);
    }

    @Override
    public boolean canGoTo(int floor) {
        return floor % 2 != 0;  // Лифт может поехать только на нечётные этажи
    }
}
