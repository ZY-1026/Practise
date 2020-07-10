package thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipe {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
            in.close();
        }
    }

    public static class Print implements Runnable {
        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int recieve;
            try {
                while ((recieve = reader.read()) != -1) {
                    System.out.println((char) recieve);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
