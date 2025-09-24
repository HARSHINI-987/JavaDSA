package collections;
import java.util.Map;
import java.util.HashMap;
public class ListCollections {
	public static void main(String[] args) {
		String st="engineering";
		Map<Character,Integer> map=new HashMap<>();
		for(char c:st.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		System.out.println(map);
		String res="";
		char ch='\0';
		boolean chk=true;
		while(chk) {
			int max=0;
			chk=false;
			for(char c:map.keySet()) {
				if(map.get(c)>max) {
					max=map.get(c);
					ch=c;
					chk=true;
				}
			}
			for(int i=0;i<max;i++ ) {
				res+=ch;
			}
			map.remove(ch);
		}
		System.out.println(res);
			
	}
}
