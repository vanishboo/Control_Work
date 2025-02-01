public class ElevatorCall implements Call {

    private final CallType type;
    private final int finishFloor;

    public ElevatorCall(CallType type, int finishFloor) {
        this.type = type;
        this.finishFloor = finishFloor;
    }

    @Override
    public CallType getType() {
        return type;
    }

    @Override
    public int getFinishFloor() {
        return finishFloor;
    }
}
