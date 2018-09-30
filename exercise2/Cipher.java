import java.util.Scanner;

public class Cipher {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your message:");
        String input = scan.nextLine();

        System.out.println("How much to shift?");
        int shift = scan.nextInt();

        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);

            int asciiValue = ((int) chr);
            asciiValue += shift;
            chr = ((char) asciiValue);

            output += chr;
        }

        System.out.println(output);
    }
}