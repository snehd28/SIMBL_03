import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hangman
 */
public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("********** W E L C O M E  T O  T H E  H A N G M A N  G A M E ************");
        File dictionary = new File("C:\\Users\\91708\\Desktop\\Simpl-03\\Hangman game\\dictionary.txt");
        String word;
        Scanner sc = new Scanner(dictionary);
        ArrayList<String> words = new ArrayList<>();
        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }
        Random r = new Random();
        word = words.get(r.nextInt(words.size()));
        final List<Character> guess = new ArrayList<>();
        char[] text = word.toCharArray();
        char[] ans = new char[text.length];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < text.length; i++) {
            ans[i] = '?';

        }
        display_current_status(input, text, ans, word, guess);
    }

    /** To check the current status of the game **/
    private static void display_current_status(Scanner input, char[] text, char[] ans, String word,
            List<Character> guess) {
        boolean finished = false;
        int lives = 6;
        while (finished == false) {
            System.out.println("------------------");
            String letter = input.next().toLowerCase();
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error input-Try Again");
                letter = input.next();
            }
            boolean found = false;
            for (int i = 0; i < text.length; i++) {
                if (letter.charAt(0) == text[i]) {
                    ans[i] = text[i];
                    found = true;
                }
            }
            if (!found) {
                lives--;
                System.out.println("Oops! Wrong letter.");
            }
            boolean done = true;
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print("" + ans[i]);
                }
            }
            display(finished, done, lives, word);
        }
    }

    // to check for the winner of the game
    public static void display(boolean finished, boolean done, int lives, String word) {
        System.out.println("\n" + "Number of Lives left: " + lives);
        hanging_man(lives);
        if (done) {
            System.out.println("Congo!! You found the right word.");
            finished = true;
        }
        if (lives <= 0) {
            System.out.println("You are dead! Better luck next time");
            System.out.println("The correct word is :" + word);
            finished = true;
        }

    }

    // to draw the hangman
    public static void hanging_man(int lives) {
        if (lives == 6) {
            System.out.println("|------------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (lives == 5) {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (lives == 4) {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (lives == 3) {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|    -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (lives == 2) {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (lives == 1) {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|    /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|------------");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|    /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}// program ends here