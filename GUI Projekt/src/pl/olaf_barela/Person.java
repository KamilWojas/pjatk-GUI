package pl.olaf_barela;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private List<Person> personWithAcces = new ArrayList<>();

    private String name;


    public Person(String name) {
        this.name = name;
    }
        //Działa xddd
    public void allNamesWithAcces() {
        for (Person test : personWithAcces){
            System.out.println(test);
        }
    }

    public Person paymentMethod() {
        System.out.println("Osoba odpowiedzialna za opłaty to :");
        Person test = personWithAcces.get(0);
        return test;
    }

    //Działa
    public void addAccess(Person name) {
        personWithAcces.add(name);
        System.out.println("Dodano dostep " + name);
        System.out.println();

    }

    //Działa
    public void removeAccess(Person t){
        /*
        Person a = t;
            for (int c = 0;c<personWithAcces.size();c++) {
                if (a==personWithAcces.get(c)){
                    personWithAcces.remove(t);
                    System.out.println("Odebrano dostep " + t);
                } else if (c+1==personWithAcces.size()){
                    System.out.println();
                    System.out.println("Podano błędne imie ");
                    System.out.println("Podona osoba nie jest klientem serwisu ");
                    System.out.println("Prosze podac osobe z listy ");
                    System.out.println(personWithAcces);
                    System.out.println();
                }
            }
         */
        personWithAcces.remove(t);

    }


    public List listWithPeopleWhoHaveAcces(){
        return personWithAcces;
    }

    public int sizeOffListOfPeople(){
        return personWithAcces.size();
    }



    @Override
    public String toString() {
        return this.name;
    }
}


