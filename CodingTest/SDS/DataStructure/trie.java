
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Trie t = new Trie();
        t.checkWord("ABC");
        System.out.println(t.checkWord("ABC"));
        System.out.println(t.checkWord("ABD"));
        System.out.println(t.checkWord("AB"));
    }
}

class Trie {
	TrieNode root = new TrieNode();
	
	void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(current.hasChild(c) == false) {
				current.children[c - 'A'] = new TrieNode();
			}
			current = current.children[c];
		}
		current.isEnd = true;
	}
	
	boolean checkWord(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(current.hasChild(c)) {
				current = current.getChild(c);
			} else {
				return false;
			}
		}
		return current.isEnd;
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;	// 끝인가 지나가는 노드인가.
	boolean isHit;
	
	TrieNode getChild(char c) {
		return children[c - 'A'];
	}
	
	boolean hasChild(char c) {
		return children[c - 'A'] != null;
	}
}