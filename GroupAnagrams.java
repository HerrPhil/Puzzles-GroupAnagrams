import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class GroupAnagrams {

    public static void main(String [] args) {
        System.out.printf("Hello Group Anagrams Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GroupAnagrams%n");
            return;
        }

        List<String> input = new ArrayList<>(
            Arrays.asList(
                "cat",
                "tac",
                "bat",
                "tab",
                "bag",
                "gab",
                "state",
                "taste"
            )
        );
        
        GroupAnagrams groupAnagrams = new GroupAnagrams(input);

        List<List<String>> result = groupAnagrams.solution();

        System.out.printf("the group anagrams are%n");
        for (List<String> anagrams : result) {
            System.out.printf("List:%n");
            for (String anagram : anagrams) {
                System.out.printf("Anagram: %s%n", anagram);
            }
        }
    }

    private List<String> input;

    public GroupAnagrams(List<String> input) {
        this.input = input;
    }

    public List<List<String>> solution() {


        char letterA = 'a';

        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();

        // for every input string
        for (String value : input) {

            // makes its letter frequency
            int [] letterFrequency = new int [26];
            char [] letters = value.toCharArray();
            for (int i = 0; i < letters.length; i++) {

                int letterIndex = Character.compare(letters[i], letterA);

                letterFrequency[letterIndex] += 1;

            }

            // keyify the letter frequency
            String letterFrequencyKey = Arrays.stream(letterFrequency)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("|"));

            // append value to list for this letter frequency key
            List<String> anagramsOfLetterFrequencyKey = anagramMap.get(letterFrequencyKey);
            if (anagramsOfLetterFrequencyKey == null) {

                List<String> nextAnagrams = new ArrayList<>();
                nextAnagrams.add(value);
                anagramMap.put(letterFrequencyKey, nextAnagrams);

            } else {

                anagramMap.get(letterFrequencyKey).add(value);

            }

        }

        List<List<String>> solution = new ArrayList<>(anagramMap.values());

        return solution;
    }

}
