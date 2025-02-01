public class ElevatorChet extends AbstractElevator {

    public ElevatorChet(ElevatorState state, int currentFloor) {
        super(state, currentFloor);
    }

    @Override
    public boolean canGoTo(int floor) {
        return floor % 2 == 0;  // Лифт может поехать только на чётные этажи
    }
}
