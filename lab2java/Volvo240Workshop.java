

public class Volvo240Workshop extends AllModelWorkshop<Volvo240> {
    public Volvo240Workshop(int maxCapacity){
        super(maxCapacity);
    }
    public static void main(String[] args){
        Volvo240Workshop volvoWorkshop = new Volvo240Workshop(15);
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        VolvoFM7 fm7 = new VolvoFM7();
        volvoWorkshop.checkInCar(volvo);
        //volvoWorkshop.checkInCar(saab);
        //volvoWorkshop.checkInCar(fm7);
        volvoWorkshop.checkOutCar(volvo);
        //volvoWorkshop.checkOutCar(saab);
    }
}

