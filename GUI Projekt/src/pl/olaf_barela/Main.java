package pl.olaf_barela;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        //  Dzień Dobry
        // Niestety nie udało mi sie czasowo spiac projektu
        // Ma on spore braki w funkcjonalnosciach oraz zalozeniach
        // Ale mam nadzieje za dostane za niego chociaz pare punktow
        //  Pozdrawiam Olaf Bareła

         Map<Person,Integer> allPerson = new HashMap();

        //Tworzenie osob
        Person admin = new Person("Admin");
        Person p1 = new Person("Kamil");
        Person p2 = new Person("Karol");
        Person p3 = new Person("Iza");
        Person p4 = new Person("Olaf");
        Person p5 = new Person("Kasia");



        //dodawanie dostepu osobom
        admin.addAccess(p1);
        admin.addAccess(p2);
        admin.addAccess(p3);
        admin.addAccess(p4);
        admin.addAccess(p5);

        System.out.println();




        //Tworzenie magazynow
        ConsumerWarehouse o1 = new ConsumerWarehouse();
        ConsumerWarehouse o2 = new ConsumerWarehouse();
        ConsumerWarehouse o3 = new ConsumerWarehouse();
        ConsumerWarehouse o4 = new ConsumerWarehouse();

        //Dodawanie przedmioto do magazynow
        o2.addToWarehouse(1,"Rower");
        o1.addToWarehouse(1,"Auto");
        o3.addToWarehouse(1,"Kajak");
        o4.addToWarehouse(2,"Motor");





        //Tworzenie stacji naprawczych
        ServiceWarehouse s1 = new ServiceWarehouse();
        ServiceWarehouse s2 = new ServiceWarehouse();
        ServiceWarehouse s3 = new ServiceWarehouse();


        //Tworzenie miejsc parkingowych
        ParkingSpace park1 = new ParkingSpace();
        ParkingSpace park2 = new ParkingSpace();
        ParkingSpace park3 = new ParkingSpace();
        ParkingSpace park4 = new ParkingSpace();
        ParkingSpace park5 = new ParkingSpace();
        ParkingSpace park6 = new ParkingSpace();
        ParkingSpace park7 = new ParkingSpace();
        ParkingSpace park8 = new ParkingSpace();
        ParkingSpace park9 = new ParkingSpace();
        ParkingSpace park10 = new ParkingSpace();
        ParkingSpace park11 = new ParkingSpace();
        ParkingSpace park12 = new ParkingSpace();
        ParkingSpace park13 = new ParkingSpace();
        ParkingSpace park14 = new ParkingSpace();
        ParkingSpace park15 = new ParkingSpace();



        //Interfejs
        start go = new start();
        go.getAdmin(admin);
        go.start();




        }



        }





