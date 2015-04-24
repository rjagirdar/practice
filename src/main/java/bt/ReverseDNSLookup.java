package bt;

import java.util.TreeMap;

import bt.IPAddress.IPAddressBuilder;

import com.google.common.collect.Maps;

public class ReverseDNSLookup {

	public static void main(String[] args) {
		IPAddress ip = IPAddress.builder().hostName("www.google.com").ipAddress("74.125.200.106").build();
		System.out.println(ip.toString());
		for (char ch : ip) {
			System.out.print(ch);
		}

	}
		
	private static class TrieNode{
		private char ch;
		private TreeMap<Character, TrieNode> map = null;
		private boolean isEnd;
		
		public TrieNode(){
			ch=' ';
			map = new TreeMap<Character, ReverseDNSLookup.TrieNode>();
			isEnd = false;
		}
		
		public TrieNode(char ch){
			this.ch = ch;
			map = new TreeMap<Character, ReverseDNSLookup.TrieNode>();
			isEnd = false;
		}
		
		public void insert(TrieNode node){
			if (!this.map.containsKey(node.ch)) {
				this.map.put(node.ch, node);
			}
		}
		
	}
	
	private static class Trie{
		private TrieNode root;
		
		public Trie(){
			this.root = new TrieNode();
		}
		
		public void insert(String str){
			
			TrieNode current = root;
			TrieNode newNode = null;
			for(int i=0; i<str.length(); i++){
				char ch = str.charAt(i);
				if(!current.map.containsKey(ch)){
					newNode = new TrieNode(ch);
					current.insert(newNode);
				}
				else{
					newNode = current.map.get(ch);
				}
				current = newNode;
				if(i==str.length()-1)
					newNode.isEnd = true;
				
			}
			
		}
	}
	
	

}
