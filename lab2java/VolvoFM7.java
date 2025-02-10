import java.awt.*;

public class VolvoFM7 implements Movable, TruckBed, Vehicle{
    private boolean truckBedExtended;
    private int maxSlots;
    private Cars[] slots;

    public VolvoFM7 (){
        this.parent = new VehicleFunctionality(2, Color.white, 90,10);
        this.truckBedExtended = false; // initieras till att rampen är uppfälld (dvs går ej att lasta)
        this.maxSlots = 4;
        this.slots = new Cars[maxSlots];
    }

    public int getNrDoors(){
        return parent.getNrDoors();
    }

    public double getEnginePower(){
        return parent.getEnginePower();
    }

    public double getCurrentSpeed(){
        return parent.getCurrentSpeed();
    }

    public Color getColor(){
        return parent.getColor();
    }

    public double getWeight(){
        return parent.getWeight();
    }

    public void setColor(Color clr){
        parent.setColor(clr);
    }

    public void startEngine(){
        parent.startEngine();
    }

    public void stopEngine(){
        parent.stopEngine();
    }

    public double[] getPos(){
        return parent.getPos();
    }

    public int[] getDirection(){
        return parent.getDirection();
    }

    public void gas(double amount){
        parent.gas(amount);
    }

    public void brake(double amount){
        parent.brake(amount);
    }

    public void turnLeft(){
        parent.turnLeft();
    }

    public void turnRight(){
        parent.turnRight();
    }

    public void loadCars(VehicleFunctionality car) {
        double deltaX = this.getPos()[0]-car.getPos()[0];
        double deltaY = this.getPos()[1]-car.getPos()[1];
        double distance = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
        if (!this.truckBedExtended) {
            throw new IllegalArgumentException("Rampen måste vara nedfälld (truckBedExtended = true) för att lasta en bil");
        }
        else if (slots.length >= maxSlots){
            throw new IllegalArgumentException("Flaket är fullt");
        }
        else if (car.getWeight() > 3.5) {
            throw new IllegalArgumentException("Bilen du försöker lasta är för stor");
        }
        else if (distance > 1){
            throw new IllegalArgumentException("Avståndet är för långt för att lasta");
        }
        else this.slots.push(car);
    }
    private void offloadCars(Cars car) {
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}



