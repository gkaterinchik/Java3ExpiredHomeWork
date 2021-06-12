public class ABC {
    volatile static char currenChar = 'A';
    private static final Object mon = new Object();

    public static void printA() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 10; i++) {
                while(currenChar!='A')
                {
                   mon.wait();
                }
                if (currenChar=='A') {
                    System.out.println(currenChar);
                    currenChar='B';
                    mon.notifyAll();
                }
            }

        }
    }
    public static void printB() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 10; i++) {
                while(currenChar!='B')
                {
                    mon.wait();
                }
                if (currenChar=='B') {
                    System.out.println(currenChar);
                    currenChar='C';
                    mon.notifyAll();
                }
            }

        }
    }
    public static void printC() throws InterruptedException {
        synchronized (mon) {
            for (int i = 0; i < 10; i++) {
                while(currenChar!='C')
                {
                    mon.wait();
                }
                if (currenChar=='C') {
                    System.out.println(currenChar);
                    currenChar='A';
                    mon.notifyAll();
                }
            }

        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ABC.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                ABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                ABC.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
