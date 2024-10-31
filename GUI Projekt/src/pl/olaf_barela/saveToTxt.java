package pl.olaf_barela;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class saveToTxt extends ConsumerWarehouse{

    //Inspiracja z https://www.javacodeexamples.com/write-hashmap-to-text-file-in-java-example/2353

    final static String output="E:/warehouse.txt";


    File file = new File(output);

   public saveToTxt(HashMap<List<Integer>,List<String>> a){
       BufferedWriter adsa = null;
       try {
           adsa = new BufferedWriter(new FileWriter(file));

           for (Map.Entry<List<Integer>,List<String>> t :a.entrySet()) {
                adsa.write(t.getKey() + " : " + t.getValue());
                adsa.newLine();
           }
           //close stream
           adsa.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
       try{
           adsa.close();
       } catch (IOException e) {
       }


       //Nigdzie nie zaimplementowane jeszcze


   }
}
