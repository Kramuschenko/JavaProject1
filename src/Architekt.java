public
    class Architekt
        extends Osoba
        implements IPracownik{

    private Specjalizacja specjalizacja;
    boolean czyZdolnyDoPracy = true;

    public Architekt(String imie, String nazwisko, String pesel, String nrTelefonu, double waga,String spec ) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga);
        specjalizacja = new Specjalizacja(spec);

    }

    @Override
    public int pobierzPensje() {
        return 10000;
    }

    @Override
    public String powiedzIleRazyKopales() {
        return "Architekt "+ imie + " nie kopaje";
    }

    @Override
    public String powiedzCoRobisz() {


        if (czyZdolnyDoPracy)
            return "Architekt "+ imie + " " + specjalizacja;
        else
            return "Architekt "+ imie + " nie zdolny do pracy";
    }

    @Override
    public void zakonczDzialanie() {
        czyZdolnyDoPracy = false;
    }

    @Override
    public String kimJest() {
        return "Architekt";
    }

    @Override
    public String toString() {
        return "Architekt{" +
                ", imie='" + imie +
                ", nazwisko='" + nazwisko +
                "' specjalizacja='" + specjalizacja +
                '}' + '\n';
    }

    @Override
    public boolean czyPracownikZdolenDoPracy() {
        return czyZdolnyDoPracy;
    }

    @Override
    public void dodajSieDoBrygady(Brygada b) {
        b.dodajPracownika(this);
    }

}
