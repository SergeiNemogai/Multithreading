public class Test {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.run();
        MultiplyWithThreads multiplyWithThreads = new MultiplyWithThreads();
        Thread thread1 = new Thread(multiplyWithThreads::run);
        Thread thread2= new Thread(multiplyWithThreads::run);
        Thread thread3 = new Thread(multiplyWithThreads::run);
        Thread thread4 = new Thread(multiplyWithThreads::run);
        Thread thread5 = new Thread(multiplyWithThreads::run);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}