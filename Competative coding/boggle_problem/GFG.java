package boggle_problem;
import java.util.*;


//Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. 
//Find all possible words that can be formed by a sequence of adjacent characters. 
//Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell
//Example:
//Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
//       boggle[][]   = {{'G','I','Z'},
//                       {'U','E','K'},
//                       {'Q','S','E'}};
//Output:  Following words of dictionary are present
//         GEEKS, QUIZ
//Input:
//The first line of input contains an integer T denoting the no of test cases . 
//Then T test cases follow. Each test case contains an integer x denoting the no of words in the dictionary. 
//Then in the next line are x space separated strings denoting the contents of the dictinory. 
//In the next line are two integers N and M denoting the size of the boggle. 
//The last line of each test case contains NxM space separated values of the boggle.
//
//Output:
//For each test case in a new line print the space separated sorted distinct words of the dictionary which could be formed from the boggle. 
//If no word can be formed print -1.
//
//Constraints:
//1<=T<=10
//1<=x<=10
//1<=n,m<=7
//
//Example:
//Input:
//1
//4
//GEEKS FOR QUIZ GO
//3 3
//G I Z U E K Q S E
//
//Output:
//GEEKS QUIZ



class GFG
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int wordCount = sc.nextInt();
            String[] dic = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                dic[i] = sc.next();
            }
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            char board[][] = new char[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    board[row][col] = sc.next().charAt(0);
                }
            }

            WBNode dawg = buildDawg(dic);
            Set<String> words = findWords(board, rows, cols, dawg);
            if (words.size() > 0) {
                for (String word : words) {
                    System.out.print(word + " ");
                }
            } else {
                System.out.print(-1);
            }
            System.out.println();
        }
    }

    static final int deltas[][] = { {-1,-1}, {-1,0}, {-1,1}
        , {0,-1}, {0,1}
        , {1,-1}, {1,0}, {1,1}
    };

    static WBNode buildDawg(String[] dic) {
        WBNode root = new WBNode('\0', false); // root has no letter
        for (String word : dic) {
            root.addWord(word, 0);
        }
        return root;
    }

    static Set<String> findWords(char[][] board, int rows, int cols, WBNode dawg) {
        Set<String> words = new TreeSet<>();
        // Build simple DAWG from dic
        boolean visited[] = new boolean[rows * cols];
        StringBuilder sb = new StringBuilder();
        // check each cell for possible directions on the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = board[row][col];
                WBNode node = dawg.getChild(c);
                if (node != null) {
                    // there is a word starting with the letter
                    Arrays.fill(visited, false);
                    sb.setLength(0);
                    track(node, board, rows, cols, row, col, sb, words, visited);
                }
            }
        }
        return words;
    }

    static void track(WBNode node, char[][] board, int rows, int cols, int row, int col, StringBuilder sb, Set<String> words, boolean[] visited) {
        char c = board[row][col];
        sb.append(c);
        visited[row * cols + col] = true;
        if (node.word) {
            words.add(sb.toString()); // Duplicates should be prevented by the Set
        }
        for (int[] delta : deltas) {
            int y = row + delta[0];
            int x = col + delta[1];
            if (y >= 0 && y < rows && x >= 0 && x < cols && !visited[y * cols + x]) {
                c = board[y][x];
                WBNode child = node.getChild(c);
                if (child != null) {
                    track(child, board, rows, cols, y, x, sb, words, visited);
                }
            }
        }
        visited[row * cols + col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}


class WBNode {

    public char letter;
    public WBNode next;
    public WBNode child;
    public boolean word;

    public WBNode(char letter) {
        this.letter = letter;
    }

    public WBNode(char letter, boolean word) {
        this(letter);
        this.word = word;
    }

    public WBNode(char letter, boolean word, WBNode next) {
        this(letter, word);
        this.next = next;
    }

    public void addWord(String w, int from) {
        if (w == null || from >= w.length()) {
            return;
        }
        char c = w.charAt(from);
        WBNode letterNode = getChild(c);
        if (letterNode == null) {
            letterNode = new WBNode(c);
            letterNode.next = this.child;
            this.child = letterNode;
        }
        letterNode.word |= from == w.length() - 1;
        letterNode.addWord(w, from + 1);
    }

    public WBNode getNext(char c) {
        if (this.letter == c) {
            return this;
        } else if (next != null){
            return next.getNext(c);
        }
        return null;
    }

    public WBNode getChild(char c) {
        if (child != null) {
            return child.getNext(c);
        }
        return null;
    }

}
