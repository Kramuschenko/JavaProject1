public interface IPracownik {
    int pobierzPensje();
    String powiedzIleRazyKopales();
    String powiedzCoRobisz();
    void zakonczDzialanie();
    String kimJest();
    String toString();
    boolean czyPracownikZdolenDoPracy();
    void dodajSieDoBrygady(Brygada b);
}
