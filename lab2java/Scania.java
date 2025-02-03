import java.awt.*;

public class Scania extends Cars implements Movable {
    private int truckBed;
    private int maxTilt;
    private boolean truckBedDown;


    public Scania (){
        super(2, Color.white, 90,8);
        this.truckBed = 0;
        this.maxTilt = 70;
        this.truckBedDown = true;
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
        if (truckBed != 0) this.truckBedDown = false;

        return this.truckBed;
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if (this.truckBedDown) {
            this.getPos()[0] += getCurrentSpeed() * this.getDirection()[0];
            this.getPos()[1] += getCurrentSpeed() * this.getDirection()[1];
        } else throw new IllegalArgumentException("Du kan inte röra dig när flaket är uppe");
    }
}
