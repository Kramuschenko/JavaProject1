import java.util.*;

public
    class Main {

    public static void main(String[] args) {

        //listy

        List<Kopacz> kopaczy = new LinkedList<>();
        List<IPracownik> architekty = new LinkedList<>();
        Brygada brygada = new Brygada(1, 5);


        //dodajemy pracownikow

        Kopacz k1 = addKopacz("Sas", "Zieln", "1773412", "+2752953582", 55.5);
        if (k1 != null){
            kopaczy.add(k1);
        }
        Kopacz k2 = addKopacz("Kol", "ss", "17733412", "+375667820", 74.5);
        if (k2 != null){
            kopaczy.add(k2);
        }


        Architekt a1 = addArchitekt("Yana", "Sakowicz" , "817212", "+489990020", 55.5, "rysuje");
        if (a1 != null){
            architekty.add(a1);
        }
        Architekt a2 = addArchitekt("Yan", "Saicz" , "85517212", "+489990020", 55.5, "rysuje");
        if (a2 != null){
            architekty.add(a2);
        }

        Brygadzista b1 = addBrygadzista("Lyowa", "Sziszkin", "98012836", "+4838179183", 88.8, "baraba", 6000, brygada);



        //dodajemy pracownikow do brygady

        brygada.dodajPracownikow(architekty);
        if (k1 != null) {
            k1.dodajSieDoBrygady(brygada);
        }
        if (k2 != null)
            brygada.dodajPracownika(k2);
        brygada.setBygadzista(b1);


        // lokalna lista pracownikow
        List<IPracownik> pracownicy = Brygada.getPracownicy();


        // zestaw pracownikow
        System.out.println("Zestaw pracownikow: ");

        pracownicy
                // stream
                .stream()
                //lambda
                .map(pracownik ->
                    pracownik.kimJest()
                )
                .forEach(System.out::println);
        System.out.println();

        // metoda co robisz

        if (a1 != null)
            System.out.println(a1.powiedzCoRobisz() + '\n');

        // metoda co ile jest Architektow

        System.out.println("Ilosc architektow: " + brygada.ileArchitektow() + '\n');

        // metoda czy brygada jest pelna

        System.out.println("Czy brygada jest pelna: " + brygada.czyPelnaBrygada() + '\n');


        // metoda compare to

        Collections.sort(kopaczy);
        System.out.println("Gradacja najmocnejsze (po wadze): ");

        for(Kopacz k : kopaczy)
            System.out.println(k);

        //watek ktory sprawdza czy brygada zdolna do pracy

        new CzyZdolnaThread(b1).start();

        // watek ktory zaczyna kopanie

        System.out.println("Watek z kopaczami: ");
        new Runner(k1).start();
        new Runner(k2).start();


        try {
            Thread.sleep(10000);
            if (k1 != null) {
                k1.zakonczDzialanie();
            }
            Thread.sleep(30000);
            System.out.println();
            if (k2 != null) {
                k2.pobierzPensje();
            }
            if (k1 != null) {
                System.out.println(k1.powiedzIleRazyKopales());
            }
            if (k2 != null) {
                System.out.println(k2.powiedzIleRazyKopales());
            }
            if (k2 != null) {
                System.out.println("Pensja drugiego kopacza: " + k2.pensja);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Osoba add(String imie, String nazwisko, String pesel, String nrTelef, double waga){
        try {
            Osoba o = new Osoba (
                    imie, nazwisko,
                    pesel, nrTelef, waga ){
            };
            return o;
        } catch (nieUnikalnyPeselException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Kopacz addKopacz(String imie, String nazwisko, String pesel, String nrTelef, double waga){
        try {
            Kopacz k = new Kopacz(
                    imie, nazwisko,
                    pesel, nrTelef, waga);
            return k;
        } catch (nieUnikalnyPeselException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Brygadzista addBrygadzista(String imie, String nazwisko, String pesel, String nrTelefonu, double waga, String pseudonim, long dlugoscZmiany, Brygada b){
        try {
            Brygadzista br = new Brygadzista(
                    imie, nazwisko,
                    pesel, nrTelefonu, waga, pseudonim, dlugoscZmiany, b);
            return br;
        } catch (nieUnikalnyPeselException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Architekt addArchitekt(String imie, String nazwisko, String pesel, String nrTelefonu, double waga, String specjalizacja){
        try {
            Architekt a = new Architekt(
                    imie, nazwisko,
                    pesel, nrTelefonu, waga, specjalizacja);
            return a;
        } catch (nieUnikalnyPeselException e) {
            e.printStackTrace();
            return null;
        }
    }

}
