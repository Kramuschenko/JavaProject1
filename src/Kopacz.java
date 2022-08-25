public
    class Kopacz
        extends Osoba
        implements IPracownik, Comparable<Kopacz>{

    int iloscMachniecLopata;
    boolean czyZdolnyDoPracy = true;
    int pensja;
    static int TMPiloscKopow = 0;
    static int TMPiloscKopowWSumme = 0;
    static int TMP = 1;
    static int counterKopaczej = 0, counter = 0;

    public Kopacz(String imie, String nazwisko, String pesel, String nrTelefonu, double waga) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga);
        counterKopaczej++;
    }

    @Override
    public String toString() {
        return "Kopacz{" +
                ", imie='" + imie +
                ", nazwisko='" + nazwisko +
                ", pesel='" + pesel +
                ", waga=" + waga +
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

    public void kop() throws zlamanaLopataException{

        int iloscKopow = (int)(Math.random()*15 + 5);
        TMPiloscKopow = iloscKopow;
        TMPiloscKopowWSumme+=TMPiloscKopow;

        for (int i = 0; i < iloscKopow; i++, TMP++) {

            if(czyZdolnyDoPracy) {

                int rand = (int) (Math.random() * 99 + 1);

                if (i == 15) {
                    czyZdolnyDoPracy = false;
                    counter++;
                    throw new zlamanaLopataException("Łopata zużyła się i pękła");

                } else if (rand == 11) {
                    czyZdolnyDoPracy = false;
                    TMP += Kopacz.TMPiloscKopow-Kopacz.TMP;
                    counter++;
                    throw new zlamanaLopataException("Łopata była wadliwa i złamała się niespodziewanie w trakcie użytkowania");
                }

                if (czyZdolnyDoPracy) {
                    System.out.println("Kopacz " + imie + " machnął łopatą");
                    Brygada.iloscMachniecLopataBrygady++;
                    iloscMachniecLopata++;
                }else
                    System.out.println("Kopacz " + imie + " JUZ NIE ZDOLNY DO PRACY");


                try {
                    Thread.sleep((int) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void stopKopanie(){
        czyZdolnyDoPracy = false;
    }

    @Override
    public int pobierzPensje() {
        return pensja = iloscMachniecLopata*100;
    }

    @Override
    public String powiedzIleRazyKopales() {
        return "Kopacz " + imie + " machnal lopata " + iloscMachniecLopata + " razy";
    }

    @Override
    public String powiedzCoRobisz() {
        return "Kopacz " + imie + " kopaje";
    }

    @Override
    public void zakonczDzialanie() {
        stopKopanie();
    }

    @Override
    public String kimJest() {
        return "Kopacz";
    }

    @Override
    public int compareTo(Kopacz o) {
        return (int) (o.waga - waga);
    }
}
