import java.util.Random;

public class ElevatorSystem {
    private AbstractElevator[] elevators;  // Массив лифтов
    private Random random = new Random();

    public ElevatorSystem(AbstractElevator[] elevators) {
        this.elevators = elevators;
    }

    // Запуск симуляции
    public void startSimulation() {
        for (int i = 1; i <= 10000; i++) {
            // Движение лифтов
            for (AbstractElevator elevator : elevators) {
                elevator.move();
            }

            // Каждый 20-й шаг генерируем вызов лифта
            if (i % 20 == 0) {
                int finishFloor = 2 + random.nextInt(15);  // Случайный этаж от 2 до 16
                CallType type = (finishFloor % 2 == 0) ? CallType.chet : CallType.nechet;
                Call call = new ElevatorCall(type, finishFloor);

                boolean found = false;
                for (AbstractElevator elevator : elevators) {
                    if (elevator.canGoTo(call.getFinishFloor()) && elevator.state() == ElevatorState.stop) {
                        elevator.assign(call.getFinishFloor());  // Назначаем лифту этаж, если он свободен
                        System.out.println("Лифт " + elevator.getClass().getSimpleName() + " едет на " + call.getFinishFloor() + " этаж");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Ошибка: Все лифты заняты!");
                }
            }
        }
    }
}
