public abstract class AbstractElevator implements ElevatorStatus {
    protected ElevatorState state;  // Текущее состояние лифта
    protected int currentFloor;     // Текущий этаж лифта
    protected Integer finishFloor;  // Этаж назначения (null, если не назначен)

    public AbstractElevator(ElevatorState state, int currentFloor) {
        this.state = state;
        this.currentFloor = currentFloor;
        this.finishFloor = null;
    }

    // Назначить лифту этаж
    public void assign(int floor) {
        if (state != ElevatorState.stop) {
            throw new IllegalStateException("Лифт уже занят!");
        }
        finishFloor = floor;
        if (currentFloor < finishFloor) {
            state = ElevatorState.goUp;
        } else {
            state = ElevatorState.goDown;
        }
    }

    // Метод для выполнения движения лифта
    public void move() {
        if (finishFloor == null) {
            return;
        }

        if (state == ElevatorState.goUp) {
            currentFloor++;
        } else if (state == ElevatorState.goDown) {
            currentFloor--;
        }

        if (currentFloor == finishFloor) {
            state = ElevatorState.stop;
            finishFloor = null;
        }
    }

    // Проверка, может ли лифт поехать на заданный этаж
    public abstract boolean canGoTo(int floor);

    @Override
    public ElevatorState state() {
        return state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
