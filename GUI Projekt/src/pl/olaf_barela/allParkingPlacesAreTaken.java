package pl.olaf_barela;

public class allParkingPlacesAreTaken extends Throwable implements addOrRemove {


    public allParkingPlacesAreTaken( ){
        System.out.println("Sorry we ony have only  " + miejscaParkingowe +" places to par car.");
        System.out.println("You have to wait to park car ");

    }

    @Override
    public void add(Person test) {

    }

    @Override
    public void remove(Person test1) {

    }


}
