package homework10.task3;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;


 class ByteBuffCopy {
    private int index;
    private int count;
    private final int oneByte = 1;
    private File source = new File("E:/example.txt");
    private File dest = new File("E:/example2.txt");
    private long size = source.getAbsoluteFile().length();
    private volatile byte[] buffer = new byte[Math.toIntExact(size)];
    private ReentrantLock lock = new ReentrantLock(true);

     ByteBuffCopy(int readersCount, int writersCount) {
        while (readersCount > 0) {
            new Thread(() -> {
                try (FileInputStream in = new FileInputStream(source)) {
                    try {
                        while (true) {
                            synchronized (this) {
                                if (count == 0) {
                                    read(in);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        count = -1;
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            readersCount--;
        }
        while (writersCount > 0) {
            new Thread(() -> {
                try (FileOutputStream out = new FileOutputStream(dest)) {
                    try {
                        while (true) {
                            synchronized (this) {
                                if (count > 0) {
                                    write(out);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        count = -1;
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            writersCount--;
        }
    }

    private void read(FileInputStream in) throws IOException {
        lock.lock();
        print(": lock");
        try {
            count = in.read(buffer);
            print(": read bytes: " + count);
        } finally {
            print(": unlock");
            lock.unlock();
        }
    }

    private void write(FileOutputStream out) throws IOException {
        lock.lock();
        print(": lock");
        try {
            if(index < buffer.length){
                out.write(buffer, index, oneByte);
                index++;
                print(": write bytes: " + index);
            }else {
                System.exit(0);
            }
        } finally {
            print(": unlock");
            lock.unlock();

        }
    }

    private void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

}
