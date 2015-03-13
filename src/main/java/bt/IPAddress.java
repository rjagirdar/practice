package bt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;



public class IPAddress implements Iterable<Character>{
	
	private final String hostName;
	private final String ipAddress;
	
	private IPAddress(){
		this.hostName = null;
		this.ipAddress = null;
	}
	
	private IPAddress(final String ipAddress, final String hostName){
		this.ipAddress = ipAddress;
		this.hostName = hostName;
	}
	
	public static IPAddressBuilder builder(){
		return new IPAddressBuilder();
	}
	
	@Override
	public String toString() {
		
		return this.ipAddress+" - "+this.hostName;
	}
	
	
	public static class IPAddressBuilder {
		
		private String hostName;
		private String ipAddress;
		
		private IPAddressBuilder(){
			this.hostName = null;
			this.ipAddress = null;
		}
			
		public IPAddressBuilder hostName(String hostName){
			this.hostName = hostName;
			return this;
		}
		
		public IPAddressBuilder ipAddress(String ipAddress){
			this.ipAddress = ipAddress;
			return this;
		}
		
		public IPAddress build(){
			return new IPAddress(this.ipAddress, this.hostName);
		}
	}


	@Override
	public Iterator<Character> iterator() {
		return new IPAddressIterator();
	}
	
	private class IPAddressIterator implements Iterator<Character>{
		
		private Queue<Character> queue;
		
		public  IPAddressIterator() {
			List<Character> list =Lists.charactersOf(ipAddress);
			this.queue = new LinkedList<Character>(list);
		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public Character next() {
			return queue.poll();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
