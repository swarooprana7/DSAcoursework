package Qnum6;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class HuffmanNode implements Comparable<HuffmanNode> {
    char c;
    int freq;
    HuffmanNode left, right;

    public int compareTo(HuffmanNode node) {
        return freq - node.freq;
    }
}

public class HuffmanEncoding {
    public static Map<Character, String> encode(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.c = entry.getKey();
            node.freq = entry.getValue();
            pq.offer(node);
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode();
            parent.freq = left.freq + right.freq;
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        Map<Character, String> codeMap = new HashMap<>();
        StringBuilder codeBuilder = new StringBuilder();
        HuffmanNode root = pq.poll();
        generateCodes(root, codeMap, codeBuilder);

        return codeMap;
    }

    private static void generateCodes(HuffmanNode node, Map<Character, String> codeMap, StringBuilder codeBuilder) {
        if (node.left == null && node.right == null) {
            codeMap.put(node.c, codeBuilder.toString());
            return;
        }

        codeBuilder.append('0');
        generateCodes(node.left, codeMap, codeBuilder);
        codeBuilder.deleteCharAt(codeBuilder.length() - 1);

        codeBuilder.append('1');
        generateCodes(node.right, codeMap, codeBuilder);
        codeBuilder.deleteCharAt(codeBuilder.length() - 1);
    }

    public static String decode(String encodedString, Map<Character, String> codeMap) {
        StringBuilder decodedBuilder = new StringBuilder();
        StringBuilder codeBuilder = new StringBuilder();
        for (char c : encodedString.toCharArray()) {
            codeBuilder.append(c);
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                if (entry.getValue().equals(codeBuilder.toString())) {
                    decodedBuilder.append(entry.getKey());
                    codeBuilder.setLength(0);
                    break;
                }
            }
        }

        return decodedBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "Hi i am swaroop";
        Map<Character, String> codeMap = encode(input);
        String encodedString = "";
        for (char c : input.toCharArray()) {
            encodedString += codeMap.get(c);
        }
        String decodedString = decode(encodedString, codeMap);
        System.out.println("Original String: " + input);
        System.out.println("Encoded String: " + encodedString);
        System.out.println("Decoded String: " + decodedString);
    }
}
