import java.awt.*;

// Reason for choosing abstract(subclassing) instead of interfaces:
// To be able to implement variables that are common between the cars but don't have the same value
// (using interfaces the variables declared will be static and final)
public abstract class Cars implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car, needs to be protected in order for tests to work
    private Color color; // Color of the car
    private final double[] pos;
    private final int[] direction;


    public Cars(int nrDoors, Color color, double enginePower){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;

        // Always initialize pos and direction to default values
        this.pos = new double[]{0, 0};    // Initial position (x = 0, y = 0)
        this.direction = new int[]{0, 1}; // Initial direction (facing upward)

        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    public double[] getPos() {
        return pos;
    }

    public int[] getDirection() {
        return direction;
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Värdet måste ligga i intervallet 0 till 1");
        }
            else incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Värdet måste ligga i intervallet 0 till 1");
        }
            else decrementSpeed(amount);
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void move() {
        pos[0] += getCurrentSpeed() * direction[0];
        pos[1] += getCurrentSpeed() * direction[1];
    }

    @Override
    public void turnLeft() {
        int newX = -direction[1];
        int newY = direction[0];
        direction[0] = newX;
        direction[1] = newY;
    }

    @Override
    public void turnRight() {
        int newX = direction[1];
        int newY = -direction[0];
        direction[0] = newX;
        direction[1] = newY;
    }
}

