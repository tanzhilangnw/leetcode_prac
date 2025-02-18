package lc;
class Trie{
    private boolean isEnd;
    public Trie[] children;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie node = this;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new Trie();
            }
            node = node.children[ch-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix){
        Trie node = this;
        for(int i = 0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a'] == null){
                return null;
            }
            node = node.children[c-'a'];
        }
        return node;
    }

}

public class lc208 {
    public static void main(String[] args) {
        // 创建 Trie 树
        Trie trie = new Trie();

        // 测试 insert 和 search 方法
        System.out.println("=== Test Insert and Search ===");
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 输出: true
        System.out.println(trie.search("app"));     // 输出: false
        System.out.println(trie.startsWith("app")); // 输出: true

        // 插入新单词
        trie.insert("app");
        System.out.println(trie.search("app"));     // 输出: true

        // 测试不存在的单词
        System.out.println("=== Test Non-Existent Words ===");
        System.out.println(trie.search("banana"));  // 输出: false
        System.out.println(trie.startsWith("ban")); // 输出: false

        // 测试 startsWith 方法
        System.out.println("=== Test StartsWith ===");
        trie.insert("banana");
        trie.insert("band");
        trie.insert("bat");
        System.out.println(trie.startsWith("ban")); // 输出: true
        System.out.println(trie.startsWith("ba"));  // 输出: true
        System.out.println(trie.startsWith("cat")); // 输出: false

        // 测试空字符串
        System.out.println("=== Test Empty String ===");
        System.out.println(trie.search(""));        // 输出: false
        System.out.println(trie.startsWith(""));    // 输出: true (空字符串是任何字符串的前缀)

        // 测试重复插入
        System.out.println("=== Test Duplicate Insertions ===");
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 输出: true
    }
}
