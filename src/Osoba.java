import java.util.ArrayList;
import java.util.List;

abstract
    class Osoba extends nieUnikalnyPeselException {
    String imie, nazwisko;
    String pesel;
    String nrTelefonu;
    double waga;
    static List<String> peseles = new ArrayList<>();

    public Osoba(String imie,String nazwisko, String pesel,String nrTelefonu, double waga ) throws nieUnikalnyPeselException{

        if (peseles.contains(pesel)){
            throw new nieUnikalnyPeselException("Taki pesel juz istnieje. Imie: " + imie + "("+ pesel + ")");
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        peseles.add(pesel);
        this.nrTelefonu = nrTelefonu;
        this.waga = waga;
    }

    public String toString(){
        return "Imie: " + imie + " ; Nazwisko: " + nazwisko + " ; Pesel: " + pesel;
    }
}
