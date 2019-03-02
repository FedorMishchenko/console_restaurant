package homework10.task3;


import java.io.*;

public class StringCopy implements Runnable {
    private String line = "";
    private File inFile = new File("E:/example.txt");
    private File outFile = new File("E:/example2.txt");

    @Override
    public void run() {
        {
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(outFile.getAbsoluteFile(), true));
                 BufferedReader br = new BufferedReader(new FileReader(inFile))) {
                while ((line = br.readLine()) != null) {
                    synchronized (this) {
                        bw.write(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}