package pl.olaf_barela;

import java.util.Scanner;

public class start {

    Person person;
    Person user;


    public void start(){
        menuStart();


    }


    private void startText(){
        System.out.println();
        System.out.println("Witaj ");
        System.out.println("Wybierz 1 by wybrac osobe ktora jestes" );
        System.out.println("Wybierz 2 by wynajac nowe pomieszczenie");
        System.out.println( "Wybierz 3 by Sprawdzic wolne pomieszczenia");
        System.out.println("Wybierz 4 by sprawdzic kto wynajmuje jakie pomieszczenie oraz jego zawartosc");
        System.out.println( "Wybierz 5 by wlozyc nowy przedmiot");
        System.out.println("Wybierz 6 by zaparkowac");
        System.out.println("Wybierz 7 by wyjac przedmiot");
        System.out.println("Wybierz 8 by odebrac pojazd");
        System.out.println("Wybierz 9 by rozpoczac naprawe");
        System.out.println("Wybierz 10 by zapisac");
        System.out.println("Wybierz 11 by zamknac program");
        System.out.println("Wybierz 12 by wrocic do poczatowego menu");
        System.out.println("Wybierz 13 by zapisac do pliku tekstowego");
    }



    private void menuStart() {
        startText();
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int go = s1.nextInt();
        int error = 0;
        switch (go) {
            case 1:
                Scanner e = new Scanner(System.in);
                if (error==0) {
                    System.out.println("Wybierz liczbe ktora odpowiada twojemu imieniu");
                    for (int c = 0; c < person.sizeOffListOfPeople(); c++) {
                        System.out.println(c + 1 + ". " + person.listWithPeopleWhoHaveAcces().get(c));
                    }
                    System.out.println(">>");



                    error++;
                    //menuStart();
                    //Działa az to tego momenty

                }else {
                System.out.println("Wybrano juz uztkownika");
                System.out.println("Jezeli zle wybrales napisz :");
                System.out.println("PROSZE O ZMIANE UZTKOWNIKA");
                String a = e.nextLine();
                if (a.toUpperCase() == "PROSZE O ZMIANE UZTKOWNIAK") {
                    error = 0;
                }else {
                    System.out.println("Prosze sprobowac ponownie");
                    String a1 = e.nextLine();
                }
            }

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:
                break;
            case 12:
                menuStart();

            case 13:

                //saveToTxt();


        }
    }



    public Person test(Person person){
        return person;
    }


    @Override
    public String toString() {
        return String.valueOf(this.person);
    }

    public void getAdmin(Person person){
        this.person=person;

    }






}
