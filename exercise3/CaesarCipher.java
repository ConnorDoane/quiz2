import java.util.Scanner;

public class CaesarCipher {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your message:");
        String input = scan.nextLine();

        System.out.println("Key?");
        String key = scan.nextLine();

        String output = "";

        int shift;

        for (int i = 0; i < input.length(); i++) {
            shift = ((int) key.charAt(i % key.length())) - 96;
            char chr = input.charAt(i);

            int asciiValue = ((int) chr);
            asciiValue += shift;
            chr = ((char) asciiValue);

            output += chr;
        }

        System.out.println(output);
    }
}