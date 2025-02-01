public class Main {
    public static void main(String[] args) {
        // Создание лифтов
        AbstractElevator[] elevators = {
                new ElevatorChet(ElevatorState.stop, 1),
                new ElevatorChet(ElevatorState.stop, 1),
                new ElevatorChet(ElevatorState.stop, 1),
                new ElevatorNechet(ElevatorState.stop, 1),
                new ElevatorNechet(ElevatorState.stop, 1),
                new ElevatorNechet(ElevatorState.stop, 1),
                new ElevatorForEmployes(ElevatorState.stop, 1)
        };


        ElevatorSystem system = new ElevatorSystem(elevators);
        system.startSimulation();
    }
}
