import java.util.*;

class ThreadVowel1 extends Thread {
    String v;

    ThreadVowel1(String k) {
        v = k;
    }

    public void run() {
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < v.length(); i++) {
            char ch = Character.toLowerCase(v.charAt(i));
            if (vowels.contains(Character.toString(ch))) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String n = sc.next();
        sc.close(); // Close the Scanner
        ThreadVowel1 tv = new ThreadVowel1(n);
        tv.start();
    }
}
