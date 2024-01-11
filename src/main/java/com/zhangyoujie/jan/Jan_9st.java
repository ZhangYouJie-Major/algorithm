package com.zhangyoujie.jan;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2024/1/9
 */
public class Jan_9st {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    boolean[][] visited = new boolean[12][12];

    Set<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();

    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        int row = board.length;
        int col = board[0].length;

        //维护到字典树中
        for (String word : words) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                visited[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }

    void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) {
            return;
        }
        if (trie.search(sb.toString()) && !set.contains(sb.toString())) {
            set.add(sb.toString());
            ans.add(sb.toString());
        }
        for (int[] dir : dirs) {
            int startX = i + dir[0];
            int startY = j + dir[1];
            if (startX >= 0 && startX < board.length && startY >= 0 && startY < board[0].length
                    && !visited[startX][startY]) {
                visited[startX][startY] = true;
                sb.append(board[startX][startY]);
                dfs(startX, startY, sb);
                visited[startX][startY] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (String s1 : dictionary) {
            trie.insert(s1);
        }
        String[] splits = sentence.split(" ");
        for (String split : splits) {
            int length = split.length();

            boolean a = false;
            for (int i = 0; i < length; i++) {
                String word = split.substring(0, i + 1);
                if (trie.search(word)) {
                    ans.add(word);
                    a = true;
                    break;
                }
            }
            if (!a) {
                ans.add(split);
            }
        }
        return ans.stream().collect(Collectors.joining(" "));

    }

    Map<Integer, Integer> cache = new HashMap<>();
    String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        this.set = set;
        this.s = s;
        int length = s.length();
        int i = dfs2(length - 1);
        return i == 0;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String s1 : dictionary) set.add(s1);
        // f[i] 表示前i个字符的子问题
        // f[i] = f[i-1] + 1
        this.s = s;
        this.set = set;
        return dfs2(s.length() - 1);
    }

    public int dfs2(int i) {
        if (i < 0) {
            return 0;
        }
        // 不选第i个字符
        int res = cache.containsKey(i - 1) ? cache.get(i - 1) : dfs2(i - 1) + 1;
        for (int j = 0; j <= i; j++) {
            if (set.contains(s.substring(j, i + 1))) {
                res = Math.min(res, cache.containsKey(j - 1) ? cache.get(j - 1) : dfs2(j - 1));
            }
        }
        if (!cache.containsKey(i)) cache.put(i, res);
        return res;
    }

    Map<Integer, Integer> cache1 = new HashMap<>();
    int[] nums;

    public int rob(int[] nums) {
        int length = nums.length;
        this.nums = nums;
        return dfs1(length - 1);
    }

    public int dfs1(int i) {
        if (i < 0) {
            return 0;
        }
        //选
        int res = cache1.containsKey(i) ? cache1.get(i) : dfs1(i - 2) + nums[i];
        //不选i
        res = Math.max(res, cache1.containsKey(i - 1) ? cache1.get(i - 1) : dfs1(i - 1));

        if (!cache1.containsKey(i)) {
            cache1.put(i, res);
        }
        return res;
    }


    public List<String> wordBreak1(String s, List<String> wordDict) {

        List<String> path = new ArrayList<>();
        dfs(s, path, wordDict);
        return ans;
    }

    private void dfs(String s, List<String> path, List<String> wordDict) {
        if (s.length() == 0) {
            ans.add(String.join(" ", path));
            return;
        }
        //遍历字典 然后截取 剩下的字符再递归
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                path.add(word);
                dfs(s.substring(word.length()), path, wordDict);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            trie.insert(words[i] + new StringBuilder(words[i]).reverse());
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (trie.search(words[i] + words[j])) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Jan_9st st = new Jan_9st();


        String[] wordDict = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(st.palindromePairs(wordDict));

    }
}
