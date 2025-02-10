import java.util.ArrayList;

public class AllModelWorkshop<T extends VehicleFunctionality> implements Workshop<T> {
    private final int maxCapacity;
    private final ArrayList<T> checkedInCars;

    public AllModelWorkshop(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.checkedInCars  = new ArrayList<>(maxCapacity);
    }
    public void checkInCar(T car) {
        if (checkedInCars.contains(car)){
            throw new IllegalArgumentException("Denna bil är redan inlämnad till verkstaden");
        }
        else if (checkedInCars.size() >= this.maxCapacity){
            throw new IllegalArgumentException("Verkstaden är full");
        }
        else checkedInCars.add(car);
    }

    public void checkOutCar(T car){
        if (!checkedInCars.contains(car)){
            throw new IllegalArgumentException("Bilen är inte i denna verkstaden");
        }
        else checkedInCars.remove(car);
    }

    public ArrayList<T> getCheckedInCars(){
        return checkedInCars;
    }

    public static void main(String[] args){
        AllModelWorkshop<VehicleFunctionality> workshop = new AllModelWorkshop<>(20);
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        VolvoFM7 fm7 = new VolvoFM7();
        workshop.checkInCar(volvo);
        workshop.checkInCar(saab);
        //workshop.checkInCar(fm7);
        workshop.checkOutCar(volvo);
        workshop.checkOutCar(saab);
    }
}
