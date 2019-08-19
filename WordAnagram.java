import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordAnagram {
    int[] count;
    String filepath;
    String input;
    int[] copy;

    public WordAnagram(String filepath) {
        this.filepath = filepath;
    }

    public void init(String input) {
        this.input = input;

        count = new int[128];
        for (char c : input.toCharArray()) count[c]++;

        copy = new int[128];
    }

    public List<String> findAnagram(String input) throws Exception {
        init(input);

        ArrayList<String> words = new ArrayList<>();

        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String word;
        while ((word = br.readLine()) != null) {
            word = word.trim();
            if (isAnagram(word)) words.add(word);
        }

        return words;
    }

    public boolean isAnagram(String word) {
        if (word.length() != input.length()) return false;
        System.arraycopy(count, 0, copy, 0, 128);
        for (char c : word.toCharArray()) {
            if (--copy[c] < 0) return false;
        }
        return true;
    }
}
