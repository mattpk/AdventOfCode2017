import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    public static int part1(List<String> input) {
        int count = 0;
        for (String pass : input) {
            List<String> tokens = Arrays.asList(pass.split(" "));
            Set<String> uniques = new HashSet<>(tokens);
            if (uniques.size() == tokens.size()) {
                count++;
            }
        }
        return count;
    }

    public static int part2(List<String> input) {
        int count = 0;
        for (String pass : input) {
            List<String> tokens = Arrays.asList(pass.split(" "));
            Set<String> sortedUniques = tokens.stream().map(s -> {
                char[] wordArray = s.toCharArray();
                Arrays.sort(wordArray);
                return String.valueOf(wordArray);
            }).collect(Collectors.toSet());
            if (sortedUniques.size() == tokens.size()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day4.in"));
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {
            input.add(in.nextLine());
        }

        System.out.println(part1(input));
        System.out.println(part2(input));
    }

}
