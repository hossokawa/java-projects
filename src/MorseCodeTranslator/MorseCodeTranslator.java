package MorseCodeTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {

    private static final Map<Character, String> charToMorse = new HashMap<>();
    private static final Map<String, Character> morseToChar = new HashMap<>();

    static {
        charToMorse.put('A', ".-");
        charToMorse.put('B', "-...");
        charToMorse.put('C', "-.-.");
        charToMorse.put('D', "-..");
        charToMorse.put('E', ".");
        charToMorse.put('F', "..-.");
        charToMorse.put('G', "--.");
        charToMorse.put('H', "....");
        charToMorse.put('I', "..");
        charToMorse.put('J', ".---");
        charToMorse.put('K', "-.-");
        charToMorse.put('L', ".-..");
        charToMorse.put('M', "--");
        charToMorse.put('N', "-.");
        charToMorse.put('O', "---");
        charToMorse.put('P', ".--.");
        charToMorse.put('Q', "--.-");
        charToMorse.put('R', ".-.");
        charToMorse.put('S', "...");
        charToMorse.put('T', "-");
        charToMorse.put('U', "..-");
        charToMorse.put('V', "...-");
        charToMorse.put('W', ".--");
        charToMorse.put('X', "-..-");
        charToMorse.put('Y', "-.--");
        charToMorse.put('Z', "--..");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        charToMorse.put('0', "-----");

        for(Map.Entry<Character, String> entry : charToMorse.entrySet()) {
            morseToChar.put(entry.getValue(), entry.getKey());
        }
    }

    public static String textToMorse(String text) {
        text = text.toUpperCase();
        StringBuilder morse = new StringBuilder();
        for(char c : text.toCharArray()) {
            if(c == ' ') {
                morse.append(" ");
            } else if(charToMorse.containsKey(c)) {
                morse.append(charToMorse.get(c)).append(" ");
            }
        }
        return morse.toString();
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" ");
        for(String word : words) {
            if(word.equals("")) {
                text.append(" ");
            } else if(morseToChar.containsKey(word)) {
                text.append(morseToChar.get(word));
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Morse Code Translator");
        System.out.println("1. Text to morse");
        System.out.println("2. Morse to text");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1) {
            System.out.println("Enter the text you want to translate to morse code:");
            String text = scanner.nextLine();
            String morse = textToMorse(text);
            System.out.println("Morse code: " + morse);
        } else if(choice == 2) {
            System.out.println("Enter your morse code text:");
            String morse = scanner.nextLine();
            String text = morseToText(morse);
            System.out.println("Text: " + text);
        } else if(choice == 3) {
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Please choose a valid option");
        }

        scanner.close();

    }
    
}
