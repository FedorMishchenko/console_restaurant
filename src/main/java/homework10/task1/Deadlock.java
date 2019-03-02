package homework10.task1;


import org.apache.log4j.Logger;

public class Deadlock implements Runnable {
    private static final Logger log = Logger.getLogger(Deadlock.class);
    private X x = new X();
    private Y y = new Y();

    private Deadlock() {
        new Thread(this).start();
        log.info("try doX");
        x.doX(y);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ignore){
            /*NOP*/
        }
        log.info("done doX");
    }
    public static void main(String[] args) {
        new Deadlock();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("additional");
        log.info("try doY");
        y.doY(x);
        log.info("done doY");
    }

    class X {
        synchronized void doX(Y y) {
            log.info("in doX thread "
                    + Thread.currentThread().getName()
                    + " blocked");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ignore){
                /*NOP*/
            }
            y.doY(x);
            /*unreachable code*/
            log.info("out doY");
        }
    }

    class Y {
        synchronized void doY(X x) {
            log.info("in doY thread "
                    + Thread.currentThread().getName()
                    + " blocked");
            x.doX(y);
            /*unreachable code*/
            log.info("out doX");
        }
    }
}
