public class ToyBox {
    volatile boolean flag = false;
    final int OFF_TIME = 3000;
    // включить тумблер
    public void switchOn() {
        while(flag);
        if(!flag) {
            flag = true;
            System.out.println("Тумблер вкл.");
        }
    }
    // выключить тумблер
    public void switchOff() {
        while(true) {
            // проверка на прерывание
            if(Thread.interrupted()) {
                System.out.println("Игрушка выключена");
                return;
            }
            // тумблер включен
            if(flag) {
                // выключаем
                try {
                    Thread.sleep(OFF_TIME);
                } catch (InterruptedException e) {
                    System.out.println("Игрушка выключена sleep InterruptedException");
                    return;
                    //e.printStackTrace();
                }
                flag = false;
                System.out.println("Тумблер выкл.");
            }
        }
    }

}
