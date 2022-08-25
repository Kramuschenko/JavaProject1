
public
    class Brygadzista
        extends Kopacz
        implements IPracownik{
    String pseudonim;
    long dlugoscZmiany;
    Brygada brygada;


    public Brygadzista(String imie, String nazwisko, String pesel, String nrTelefonu, double waga, String pseudonim, long dlugoscZmiany, Brygada b) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga);
        this.pseudonim = pseudonim;
        this.dlugoscZmiany = dlugoscZmiany;
        this.brygada = b;

    }

    public void sprawdzCzyBrygadaNiezdolnaDoPracy() throws BrygadaNiezdolnaDoPracy{
        if (super.czyZdolnyDoPracy) {
            if (brygada.BrygadaNiezdolnaDoPracy())
                System.err.println("Brygada zdolna do pracy" + '\n' + "Zrobiono " + Brygada.getIloscMachniecLopataBrygady() + " kopów!");
            else if(Kopacz.TMP >= Kopacz.TMPiloscKopowWSumme){
                throw new BrygadaNiezdolnaDoPracy("Brygada nie zdolna do pracy");
            }else if(Kopacz.counter == Kopacz.counterKopaczej){
                Kopacz.TMP += 21;
                throw new BrygadaNiezdolnaDoPracy("Brygada nie zdolna do pracy");
            }


        }
    }

    @Override
    public int pobierzPensje() {
        super.pensja = super.iloscMachniecLopata*100;
        return super.pensja;
    }

    @Override
    public String powiedzIleRazyKopales() {
        return "Brygadzista " + pseudonim + " machnal lopata " + super.iloscMachniecLopata + " razy";
    }

    @Override
    public String powiedzCoRobisz() {
        return "Brygadzista " + pseudonim + " kieruje brygada nr " + brygada.nrBrygady;
    }

    @Override
    public void zakonczDzialanie() {
        super.czyZdolnyDoPracy = false;
    }

    @Override
    public String kimJest() {
        return "Brygadzista";
    }

    @Override
    public String toString() {
        return "Brygadzista{" +
                ", imie='" + imie +
                ", nazwisko='" + nazwisko +
                "pseudonim='" + pseudonim +
                ", dlugoscZmiany=" + dlugoscZmiany +
                ", brygada=" + brygada +
                ", pensja=" + pensja +
                '}' + '\n';
    }

    @Override
    public boolean czyPracownikZdolenDoPracy() {
        return super.czyZdolnyDoPracy;
    }

    @Override
    public void dodajSieDoBrygady(Brygada b) {
        b.dodajPracownika(this);
    }

}
