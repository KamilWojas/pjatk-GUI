package pl.olaf_barela;

abstract class idCreate implements addOrRemove {

    public int idCreate(){
        int a;
        int b;
        int c;
        a = (int) (1 + Math.random() * 600);
        b = (int) (1 + Math.random() * 400);
        c = (int) (1 + Math.random() * 300);
        int d = a*b/c;
        return d;




    }



    //Fajny pomysl ale do dopracowania zwlaszcze odwolywanie sie do idCrate jak prawidlowo to robic
    //Przyklad w klasie Parking dwa razy implementuje sie metoda add remove
    //1 bo dziedziczy po addRemove i w idCreate i pytanie dlaczego


    //Przekminic timer //Filmik na teams

    //sprobowac dokonczyc service warehouse

    //Przeczytac apropo typow aut jak ma to wygladac chyba nie moze byc tak jak jest

    // zwrtocic uwage na brak  -> lambda wyrazen   //Trzeba dodac jakies


}
