import java.awt.*;

public class VolvoFM7 extends Cars implements Movable{
    private boolean truckBedDown;
    private int maxSlots;
    private Cars[] slots;

    public VolvoFM7 (){
        super(2, Color.white, 90,10);
        this.truckBedDown = true;
        this.maxSlots = 4;
        this.slots = new Cars[maxSlots];
    }

    private void loadCars(Cars car) {
        double deltaX = this.getPos()[0]-car.getPos()[0];
        double deltaY = this.getPos()[1]-car.getPos()[1];
        double distance = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
        if (!truckBedDown) {
            throw new IllegalArgumentException("Flaket måste vara uppe för att lasta");
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
    }
    private void offloadCars(Cars car) {
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}



