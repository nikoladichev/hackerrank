package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

abstract class FrequencyNode implements Comparable<FrequencyNode> {
    public int frequency; // the frequency of this tree
    public char data;
    public FrequencyNode left, right;

    public FrequencyNode(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(FrequencyNode tree) {
        return frequency - tree.frequency;
    }
}

public class HuffmanTree {

    public static void main(String[] args) {
        Solution.test("ABACA");
    }

    void decode(String s, FrequencyNode root) {

        if (root.data != 0) {
            System.out.println(root.data);
        }

        System.out.println(s);

    }

}

class Solution {

    // input is an array of frequencies, indexed by character code
    public static FrequencyNode buildTree(int[] charFreqs) {

        PriorityQueue<FrequencyNode> trees = new PriorityQueue<FrequencyNode>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            FrequencyNode a = trees.poll();
            FrequencyNode b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanFrequencyNode(a, b));
        }

        return trees.poll();
    }

    public static Map<Character,String> mapA=new HashMap<Character ,String>();

    public static void printCodes(FrequencyNode tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanFrequencyNode) {
            HuffmanFrequencyNode node = (HuffmanFrequencyNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void test(String test) {

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        FrequencyNode tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for(int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        HuffmanTree d = new HuffmanTree();
        d.decode(s.toString(), tree);
    }
}

class HuffmanLeaf extends FrequencyNode {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanFrequencyNode extends FrequencyNode {

    public HuffmanFrequencyNode(FrequencyNode l, FrequencyNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}