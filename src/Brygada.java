import java.util.ArrayList;
import java.util.List;

public class Brygada implements Comparable<IPracownik>{
    public static int iloscMachniecLopataBrygady = 0;
    boolean czyBrygadaZdilnaDoPracy;
    Brygadzista brygadzista;
    int nrBrygady;
    int maxPojemnoscBrygady;
    static int counter = 0;
    static List<IPracownik> pracownicy = new ArrayList<>();

    public Brygada(int nrBrygady, int maxPojemnoscBrygady){
        this.nrBrygady = nrBrygady;
        this.maxPojemnoscBrygady = maxPojemnoscBrygady;
    }


    public int ileArchitektow() {
        int ileArchitektow = 0;

        for (IPracownik pracownik : pracownicy){
            if (pracownik.kimJest() == "Architekt")
                ileArchitektow++;
        }
        return ileArchitektow;
    }

    public boolean czyPelnaBrygada(){
        if (pracownicy.size() == maxPojemnoscBrygady)
            return true;
        else
            return false;
    }

    public boolean BrygadaNiezdolnaDoPracy(){
        boolean tmp = false;
        try {
            Thread.sleep(brygadzista.dlugoscZmiany);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (IPracownik pracownik : pracownicy){
            if (!pracownik.kimJest().equals("Brygadzista")) {
                if (pracownik.czyPracownikZdolenDoPracy()) {
                    tmp = true;
                    break;
                } else
                    tmp = false;
            }
        }
        try {
            Thread.sleep(brygadzista.dlugoscZmiany);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public void dodajPracownika(IPracownik pracownik){
        if(counter <= maxPojemnoscBrygady) {
            pracownicy.add(pracownik);
            counter++;
        }else
            System.out.println("Brygada jest pelna!");
    }

    public void dodajPracownikow(List<IPracownik> pr){
        if((counter + pr.size()) <= maxPojemnoscBrygady) {
            for (IPracownik pracownik : pr ){
                pracownicy.add(pracownik);
                counter++;
            }

        }else
            System.out.println("Za duzo pracownikow!");
    }

    public void setBygadzista(Brygadzista b){

        int ileBrygadzistow = 0;

        for (IPracownik pracownik : pracownicy){
            if (pracownik.kimJest() == "Brygadzista")
                ileBrygadzistow++;
        }
        if (ileBrygadzistow == 0){
            this.brygadzista = b;
            pracownicy.add(b);
        }

    }


    @Override
    public int compareTo(IPracownik pracownik) {
        return 0;
    }

    public static List<IPracownik> getPracownicy() {
        return pracownicy;
    }

    public static int getIloscMachniecLopataBrygady() {
        return iloscMachniecLopataBrygady;
    }

    @Override
    public String toString() {
        return nrBrygady + "";
    }

}
