package slips;
class OddNumbers implements Runnable {
    private int n;

    public OddNumbers(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Odd numbers between 1 to " + n + " are: ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

class PrimeNumbers implements Runnable {
    private int n;

    public PrimeNumbers(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Prime numbers between 1 to " + n + " are: ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        int n = 100; // You can change this value to any positive integer

        OddNumbers oddNumbers = new OddNumbers(n);
        PrimeNumbers primeNumbers = new PrimeNumbers(n);

        Thread oddThread = new Thread(oddNumbers);
        Thread primeThread = new Thread(primeNumbers);

        oddThread.start();
        primeThread.start();
    }
}