import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filepath = "/usr/share/dict/words";
        if (args.length == 1) filepath = args[0].trim();

        WordAnagram wordAnagram = new WordAnagram(filepath);

        List<String> res;
        String input;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter the characters");
            input = scan.nextLine().trim();
            System.out.println("Searching...");
            try {

                res = wordAnagram.findAnagram(input);
                for (String s : res) System.out.println(s);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println("Searching completed...");
            }
        }

    }
}
