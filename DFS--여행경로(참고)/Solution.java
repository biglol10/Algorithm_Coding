import java.util.*;

public class Solution {
	static List<String> answerList = new ArrayList<>();
	static Map<List<String>, Boolean> mainTravelMap = new HashMap<>();

	public static void main(String[] args) {

		/*
		 * String[][] tickets = { {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"} };
		 * 
		 */

		/*
		 * String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
		 * { "ATL", "ICN" }, { "ATL", "SFO" } };
		 */
		
		 /* String[][] tickets = { {"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"},
		  {"B", "A"} };
		 */

		
		
		  String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
		 
		  
		/*
		 * String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}};
		 * 
		 * String[][] tickets = {{"ICN","BOO"}, {"ICN", "COO"}, { "COO", "DOO" },
		 * {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO",
		 * "BOO"}};
		 */
		String[] answer = solution(tickets);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	public static String[] solution(String[][] tickets) {
		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++) {
			nodeList.add(new Node(tickets[i][0], tickets[i][1]));
		}
		
		Collections.sort(nodeList, ((o1, o2) -> o1.departure.compareTo((o2.departure)) !=0 
				         ? o1.departure.compareTo((o2.departure)) : o1.destination.compareTo(o2.destination)));
		
		List<Node> departures = new ArrayList<>();
		for (Node node : nodeList) {
			if(node.departure.equals("ICN")) {
				departures.add(node);
			}
		}
		
		for (Node node : departures) {
			node.index = 0;
			if(dfs(nodeList, node, 1)) break;
		}
		String[] answer = createArray(nodeList);

		return answer;
	}
	public static boolean dfs(List<Node> tickets, Node departure, int idx) {
		boolean stop = false;
		if(idx == tickets.size()) {
			return true;
		}
		for (Node ticket : tickets) {
			if(ticket.index < 0 && departure.isAdjacent(ticket)) {
				ticket.index = idx;
				stop = dfs(tickets, ticket, idx + 1);
				if(stop) break;
			}
		}
		
		if(!stop) {
			departure.index = -1;
		}
		return stop;
	}
	public static String[] createArray(List<Node> nodeList) {
		Collections.sort(nodeList, (o1, o2) -> o1.index > o2.index ? 1: -1);
		
		String[] answer = new String[nodeList.size() + 1];
		answer[0] = nodeList.get(0).departure;
		answer[1] = nodeList.get(1).destination;
		for (int i = 1; i < nodeList.size(); i++) {
			answer[i + 1] = nodeList.get(i).destination;
		}
		return answer;
	}
	public static class Node{
		public String departure;
		public String destination;
		public int index = 1;
		
		public Node(String departure, String destination) {
			this.departure = departure;
			this.destination = destination;
		}
		
		public boolean isAdjacent(Node other) {
			return this.destination.equals(other.departure);
		}
	}
}