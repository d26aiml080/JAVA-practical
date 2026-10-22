import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        if (!sc.hasNextLine()) {
            System.out.println("No sentence entered.");
            sc.close();
            return;
        }
        String sentence = sc.nextLine().trim();

        System.out.print("Enter a keyword: ");
        if (!sc.hasNextLine()) {
            System.out.println("No keyword entered.");
            sc.close();
            return;
        }
        String keyword = sc.nextLine().trim();

        if (sentence.isEmpty()) {
            System.out.println("Sentence cannot be empty.");
            sc.close();
            return;
        }

        String[] words = sentence.split("\\s+");

        StringBuilder sb = new StringBuilder(sentence);
        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        String shortest = words[0].toLowerCase();
        int keywordCount = 0;

        for (String word : words) {
            String lowerWord = word.toLowerCase();

            if (lowerWord.length() < shortest.length()) {
                shortest = lowerWord;
            }

            if (lowerWord.equals(keyword.toLowerCase())) {
                keywordCount++;
            }
        }

        int vowelCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowelCount++;
            }
        }

        System.out.println("Sentence: " + sb);
        System.out.println("Words: " + words.length);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowelCount);

        sc.close();
    }
}