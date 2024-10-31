package pl.olaf_barela;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsumerWarehouse extends idCreate {
    //Magazyn Osoby wynajmujacej

    HashMap<Integer, List<String>> objectInWarehouse = new HashMap<>();
    public List items = new ArrayList<String>();
    public List number = new ArrayList<Integer>();


    final int a =idCreate();


    public ConsumerWarehouse() {
        int c = 0;
        c++;
    number.add(a+c);



    }


    public void addToWarehouse(int c, String a) {
        items.add(a);
        objectInWarehouse.put(c, items);

    }

    public void removeFromWarehouse(int c, String a) {
        objectInWarehouse.remove(c, items);
    }


    public HashMap<Integer,List<String>> getList(){
        return objectInWarehouse;
    }








    @Override
    public void add(Person test) {
    }

    @Override
    public void remove(Person test1) {
    }


}


