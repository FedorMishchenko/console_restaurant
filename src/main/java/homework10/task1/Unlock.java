package homework10.task1;

import org.apache.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class Unlock implements Runnable {
    private static final Logger log = Logger.getLogger(Unlock.class);
    private static X x = new X();
    private static Y y = new Y();
    private ReentrantLock lock;

    private Unlock(X x, Y y, ReentrantLock lock) {
        Unlock.x = x;
        Unlock.y = y;
        this.lock = lock;
        new Thread(this::run).start();
        new Thread(this::run2).start();
    }

    public static void main(String[] args) {
        new Unlock(x,y,new ReentrantLock());
        log.info(": Main finish");
    }

    @Override
    public void run() {
        lock.lock();
        try {
            x.doX(y);
            log.info(": lock run()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }
            y.doY(x);
            log.info(": out from doY");
        } finally {
            lock.unlock();
            log.info(": unlock run()");
        }
    }

    private void run2() {
        lock.lock();
        try {
            y.doY(x);
            log.info(": lock run2()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }

            x.doX(y);
            log.info(": out from doX");

        } finally {
            lock.unlock();
            log.info(": unlock run2()");
        }
    }

    static class X {
        synchronized void doX(Y y) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info(": inside doX");
        }
    }

    static class Y {
        synchronized void doY(X x) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(": inside doY");
        }
    }
}
