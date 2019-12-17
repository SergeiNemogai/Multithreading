import java.io.*;
import java.math.BigInteger;

public class MultiplyWithThreads {
    public synchronized void run() {
        long time = System.currentTimeMillis();
        BigInteger mul = BigInteger.ONE;
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mul = mul.multiply(mulOfArray(line.split("\t")));
            }
            result = mul.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out1.txt"))) {
            if (result != null) {
                writer.write(result + "\n" + (double) (System.currentTimeMillis() - time) / 1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BigInteger mulOfArray(String[] array) {
            BigInteger mul = BigInteger.ONE;
            synchronized (this) {
                for (String element : array) {
                    mul = mul.multiply(BigInteger.valueOf(Long.parseLong(element)));
                }
            }
            return mul;
    }
}