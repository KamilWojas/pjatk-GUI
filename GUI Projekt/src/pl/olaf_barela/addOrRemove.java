package pl.olaf_barela;

import java.util.Random;

interface addOrRemove {

    //ParkingSpace
    final int miejscaParkingowe = 15 ;
    final int dlugosc = 5;
    final int szczerokosc = 3;
    final int powierzchnia = 2500;

    //ConsumerWarehouse
    final int iloscMagazynow = 10;



    //ServiceWarehouse
     final int iloscStacji = 3;



    public abstract void add(Person test);

   public abstract void remove(Person test1);



        //Zrobic z tego interfdejs ktory ma wywolanie metody z klasy zyx z metoda createID

         //Raczej prawidlowa kontrukcja




}
