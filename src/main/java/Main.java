public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int ON_TIME = 2000;
        final int CNT_ROUNDS = 5;
        Thread player;
        ToyBox toyBox = new ToyBox();
        // поток-игрушка
        Thread toy = new Thread(null, toyBox::switchOff);
        toy.start();
        // потоки-игрока
        for(int i = 0; i < CNT_ROUNDS; i++) {
            player = new Thread(null, toyBox::switchOn);
            player.start();
            Thread.sleep(ON_TIME);
            player.join();
        }
        // прерывание потока-игрушка
        toy.interrupt();
    }
}
