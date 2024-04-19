package slips;
import java.util.concurrent.TimeUnit;
public class Q1a {
	 public static void main(String[] args) throws InterruptedException {
	        String text = "This is a scrolling text. ";
	        while (true) {
	            for (int i = 0; i < text.length() * 2; i++) {
	                System.out.print("\r" + getShiftedText(text, i));
	                TimeUnit.MILLISECONDS.sleep(100); // Adjust the speed here (milliseconds)
	            }
	        }
	    }

	    private static String getShiftedText(String text, int shift) {
	        int length = text.length();
	        int offset = shift % length;
	        String shiftedText = text.substring(length - offset) + text.substring(0, length - offset);
	        return shiftedText;
	    }
}
