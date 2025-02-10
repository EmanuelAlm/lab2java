import java.awt.*;

public class Scania extends Cars implements Movable {
    private int truckBed;
    private final int maxTilt;
    private boolean truckBedExtended;

    public VehicleFunctionality parent;

    public Scania (){
        super(2, Color.white, 90,8);
        this.truckBed = 0;
        this.maxTilt = 70;
        this.truckBedDown = true;
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

    public int getMaxTilt() {
        return maxTilt;
    }

    public boolean getTruckBedDown(){
        return this.truckBedDown;
    }

    public int getTruckBedAngle(){
        return this.truckBed;
    }

    public int tiltBed(int degrees) {
        if ((degrees > 70) || (degrees < -70)){
            throw new IllegalArgumentException("Ge ett värde mellan -70 och 70");
        }
        if (getCurrentSpeed() !=0) {
            throw new IllegalArgumentException("Får inte vinkla flaket när lastbilen är i rörelse");
        }
        if (((this.truckBed + degrees) > 70) || ((this.truckBed + degrees) < 0)){
            int maxTiltPossible = this.maxTilt - this.truckBed;
            int minTiltPossible = this.truckBed;
            throw new IllegalArgumentException("vinkeln får inte höjas mer än " + maxTiltPossible + " eller sänkas med mer än " + minTiltPossible);
        }
        else this.truckBed += degrees;

        if (this.truckBed != 0) this.truckBedExtended = true;
        else this.truckBedExtended = false;

    }


    protected double speedFactor(){
        return parent.speedFactor();
    }

    @Override
    public void move() {
        if (this.truckBedDown) {
            this.getPos()[0] += getCurrentSpeed() * this.getDirection()[0];
            this.getPos()[1] += getCurrentSpeed() * this.getDirection()[1];
        } else throw new IllegalArgumentException("Du kan inte röra dig när flaket är uppe");
    }
}
