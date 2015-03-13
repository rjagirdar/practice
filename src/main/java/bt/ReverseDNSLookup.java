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
		
	private static class Trie<T extends Iterable<?>>{
		private TrieNode<T> root;
		
		public Trie(){
			this.root = new TrieNode<T>();
		}
		
		
		
	}
	
	private static class TrieNode<K>{
		private K k;
		private TreeMap<K, TrieNode<K>> map = new TreeMap<K, ReverseDNSLookup.TrieNode<K>>();
		
		public TrieNode(){
			k= null;
			this.map = new TreeMap<K, ReverseDNSLookup.TrieNode<K>>();
		}
		
		public void addChild(K val){
			
		}
	}

}
