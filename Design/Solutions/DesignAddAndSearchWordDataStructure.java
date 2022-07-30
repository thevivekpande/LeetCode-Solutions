// Using HashMap
class TrieNode{
    public TrieNode[] links;
    private final int size=26;
    private boolean isEnd;
    public TrieNode(){
        links=new TrieNode[size];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node){
        links[ch-'a']=node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode());
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        return find(word.toCharArray(), node, 0);
    }
    
    private boolean find(char[] word,TrieNode node, int ind) {
        if(node == null) return false;
        if(ind == word.length) return node.isEnd();
        char ch = word[ind];
        if(ch == '.') {
            for(int i = 0; i< 26 ; i++) {
                if (node.links[i] != null && find(word, node.links[i], ind+1)) {
                    return true;
                }
            }
             
        } else {
            return node.links[ch - 'a'] != null && find(word, node.links[ch - 'a'], ind+1);
        }
        return false;
    }
}

// Using Trie
class TrieNode{
    public TrieNode[] links;
    private final int size=26;
    private boolean isEnd;
    public TrieNode(){
        links=new TrieNode[size];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node){
        links[ch-'a']=node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode());
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        return find(word.toCharArray(), node, 0);
    }
    
    private boolean find(char[] word,TrieNode node, int ind) {
        if(node == null) return false;
        if(ind == word.length) return node.isEnd();
        char ch = word[ind];
        if(ch == '.') {
            for(int i = 0; i< 26 ; i++) {
                if (node.links[i] != null && find(word, node.links[i], ind+1)) {
                    return true;
                }
            }
             
        } else {
            return node.links[ch - 'a'] != null && find(word, node.links[ch - 'a'], ind+1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */