package pl.olaf_barela;

abstract class typeOfVehicle implements vehicleParametrs {


    int pojemnoscSilnika;
    String typeOfEngine;


    enum Vehicle{
        samododTerenowy,
        samododMiejski,
        motocykl,
        amfibia
    }
    Vehicle vehicle;




    public typeOfVehicle(String typeOfEngine,int pojemnoscSilnika,Vehicle vehicle){
        this.typeOfEngine=typeOfEngine;
        this.pojemnoscSilnika=pojemnoscSilnika;
        this.vehicle=vehicle;

    }




    //Nie jestem pewien czy enum czy abstract zrobic
    //Raczej enum

}
