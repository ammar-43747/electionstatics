package election;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Electionstatistics
{
public static <K> void increment(Map<K, Integer>map,K key) {
	map.putIfAbsent(key, 0);
	map.put(key, map.get(key)+1);
}
	public static void main(String[] args) 
	{
		HashMap<String,Integer> candidate=new HashMap<String,Integer>();
		Scanner s1=new Scanner(System.in);
		int count=0;
		String command;
		int vote=0;
		int value;
		String key;
		for(int i=0;i<1000;i++){
			String Name = "";
		System.out.print("Enter the command :");
		command=s1.nextLine();
		switch(command)
		{
		case "entercandidate":
			Name=s1.nextLine();
			candidate.put(Name,count);
			System.out.println("the candidate name has been entered as :"+Name);
			break;
		case "castvote":
				String canName=s1.nextLine();
				if(candidate.containsKey(canName)) {
					increment(candidate, canName);
			}
				else {
					System.out.println("there is no candidate with this name");
				}
				break;
		case "countvote":
			String countVote=s1.nextLine();
			int nofVotes=candidate.getOrDefault(countVote, 0);
			System.out.println("the candidate :"+countVote +", has got :"+nofVotes+"votes");
			break;
		case "listvote":
			for(Map.Entry m:candidate.entrySet()){
				System.out.println(m.getKey()+" "+m.getValue());  
			 }
			break;
		case "getwinner":
			int winner=(Collections.max(candidate.values()));
			for(java.util.Map.Entry<String, Integer> entry:candidate.entrySet()){
				if(entry.getValue()==winner) {
					System.out.println("The winner is :"+entry.getKey());
				}
					}
			break;
		case "exit":
			i=1100;
			break;
		default:
			System.out.println("you have entered the wrong command");
		}
		}
	}

}
