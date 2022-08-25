public class CzyZdolnaThread extends Thread{
    private Brygadzista brygadzista;

    public CzyZdolnaThread(Brygadzista brygadzista) {
        this.brygadzista = brygadzista;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while((Kopacz.TMP != Kopacz.TMPiloscKopowWSumme )) {
            if (Kopacz.TMP >= Kopacz.TMPiloscKopowWSumme)
                break;
            try {
                brygadzista.sprawdzCzyBrygadaNiezdolnaDoPracy();
            } catch (BrygadaNiezdolnaDoPracy e) {
                e.printStackTrace();
            }
        }
    }
}
