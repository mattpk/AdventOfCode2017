import java.io.FileReader;
import java.util.*;

public class Day7 {

    public static class Program {
        public String name;
        public int weight;
        public List<String> children;

        public Program(String name, int weight, List<String> children) {
            this.name = name;
            this.weight = weight;
            this.children = children;
        }
    }

    public static String part1(Map<String, String> parentMap, String programName) {
        while (parentMap.containsKey(programName)) {
            programName = parentMap.get(programName);
        }
        return programName;
    }

    // return: the negative of the required weight change (small hack)
    // otherwise the weight of the program
    public static int part2(Map<String, Program> programMap, Program program) {
        List<Integer> weights = new ArrayList<>();
        for (String childName : program.children) {
            int weight = part2(programMap, programMap.get(childName));
            if (weight < 0) {
                return weight;
            }
            weights.add(weight);
        }

        // UGLY hack to get a working solution
        if (weights.stream().anyMatch(w -> !w.equals(weights.get(0)))) {
            if (weights.size() >= 3) {
                int mostCommonWeight;
                if (weights.get(1).equals(weights.get(2))) {
                    mostCommonWeight = weights.get(1);
                } else {
                    mostCommonWeight = weights.get(0);
                }
                for (int i = 0; i < weights.size(); i++) {
                    if (weights.get(i) != mostCommonWeight) {
                        return -(weights.get((i + 1) % weights.size()) - programMap.get(program.children.get(i)).children.stream().mapToInt(c -> part2(programMap, programMap.get(c))).sum());
                    }
                }
            } else {
                System.out.println("Impossible");
            }
        }
        return weights.stream().mapToInt(i -> i).sum() + program.weight;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day7.in"));

        Map<String, Program> programMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();

        String name = "";

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split(" ");
            name = split[0];
            int weight = Integer.parseInt(split[1].substring(1, split[1].length() - 1));
            List<String> children = new ArrayList<>();
            for (int i = 3; i < split.length; i++) {
                String child = split[i].contains(",") ? split[i].substring(0, split[i].length() - 1) : split[i];
                children.add(child);
                parentMap.put(child, name);
            }
            programMap.put(name, new Program(name, weight, children));
        }

        String bottomProgram = part1(parentMap, name);

        System.out.println(bottomProgram);
        System.out.println(-part2(programMap, programMap.get(bottomProgram)));
    }
}
