package pl.olaf_barela;

import java.util.*;

public class ParkingSpace implements addOrRemove {

    List<Integer> parkingPlaces = new ArrayList<>();
    HashMap<List<Integer>,Person> parkingNubersAndPlace = new HashMap<List<Integer>,Person>();


            idCreate create = new idCreate() {
                @Override
                public void add(Person test) {
                    for (int c = 0;c>=miejscaParkingowe;c++){
                        if (parkingPlaces.get(c)==null){
                            parkingNubersAndPlace.put(Collections.singletonList(parkingPlaces.get(c)),test);
                        }
                    }
                }

                @Override
                public void remove(Person test1) {
                }
            };




    public ParkingSpace(){
        int a= create.idCreate();
        a++;

        parkingPlaces.add(a);
        if (parkingPlaces.size()<=miejscaParkingowe){
            try {
                throw new allParkingPlacesAreTaken();
            } catch (pl.olaf_barela.allParkingPlacesAreTaken allParkingPlacesAreTaken) {
                allParkingPlacesAreTaken.printStackTrace();
            }
        }

    }



    // Ma pokazywac nr miejsca i osobe do niego przypisana
    public void showHashMapOffParkingWithUsers(){
        for (Map.Entry<List<Integer>,Person> tdsa : parkingNubersAndPlace.entrySet()){
            System.out.println(tdsa.getValue());

        }


    }

    @Override
    public void add(Person test) {

    }

    @Override
    public void remove(Person test1) {

    }
}
