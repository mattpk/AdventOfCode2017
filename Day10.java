import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    public static int part1(String input) {
        List<Integer> lengths = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int[] list = new int[256];
        int pos = 0;
        int skipSize = 0;
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        for (int length : lengths) {
            for (int i = 0; i < length / 2; i++) {
                int start = (pos + i) % list.length;
                int end = (pos + length - 1 - i) % list.length;
                int tmp = list[start];
                list[start] = list[end];
                list[end] = tmp;
            }
            pos += length + skipSize;
            skipSize++;
        }

        return list[0] * list[1];
    }

    public static String part2(String input) {
        List<Integer> lengths = input.chars().boxed().collect(Collectors.toList());
        lengths.addAll(Arrays.asList(17, 31, 73, 47, 23));

        int[] list = new int[256];
        int pos = 0;
        int skipSize = 0;
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        for (int round = 0; round < 64; round++) {
            for (int length : lengths) {
                for (int i = 0; i < length / 2; i++) {
                    int start = (pos + i) % list.length;
                    int end = (pos + length - 1 - i) % list.length;
                    int tmp = list[start];
                    list[start] = list[end];
                    list[end] = tmp;
                }
                pos += length + skipSize;
                skipSize++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.length; i += 16) {
            int xor = list[i] ^ list[i + 1];
            for (int j = i + 2; j < i + 16; j++) {
                xor = xor ^ list[j];
            }
            String hex = Integer.toHexString(xor);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            ans.append(hex);
        }
        return ans.toString();
    }

    public static void main(String[] args) throws Exception {
        String input = "102,255,99,252,200,24,219,57,103,2,226,254,1,0,69,216";
        System.out.println(part1(input));
        System.out.println(part2(input));
    }
}
