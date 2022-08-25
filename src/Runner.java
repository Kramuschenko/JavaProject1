public class Runner extends Thread{

    private Kopacz kopacz;

    public Runner(Kopacz k){
        this.kopacz = k;
    }

    public void run(){
        if (kopacz != null){
            synchronized (Runner.class){
                try {
                    kopacz.kop();
                } catch (zlamanaLopataException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
