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
		
		  String[][] tickets = { {"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"},
		  {"B", "A"} };
		 

		
		/*
		 * String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
		 */

		String[] answer = solution(tickets);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static boolean dfs(String startingPlace, String targetPlace, String[][] tickets, List<String> aList,
			int count) {
		Boolean stop = false; // !!

		List<String> temp = new ArrayList<>(Arrays.asList(startingPlace, targetPlace));

		if (mainTravelMap.get(new ArrayList<>(Arrays.asList(startingPlace, targetPlace)))) {
			stop = true;
			return stop;
		}
			 

		if (count == tickets.length) {
			aList.add(startingPlace);
			aList.add(targetPlace);
			mainTravelMap.put(new ArrayList<>(Arrays.asList(startingPlace, targetPlace)), true);
			answerList = new ArrayList<>();
			for (int i = 0; i < aList.size(); i++) {
				answerList.add(aList.get(i));
			}
			stop = true;
			return stop;
		}
		aList.add(startingPlace);
		mainTravelMap.put(new ArrayList<>(Arrays.asList(startingPlace, targetPlace)), true);
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals(targetPlace)) {
				stop = dfs(tickets[i][0], tickets[i][1], tickets, aList, count + 1);
			}
		}
		if (!stop) { // 잘못된 여행경로면 원복시켜야 함
			aList.remove(aList.size() - 1);
			mainTravelMap.put(new ArrayList<>(Arrays.asList(startingPlace, targetPlace)), false);
			stop = false;
		}
		return stop;
	}

	public static String[] solution(String[][] tickets) {
		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {

				if (o1[0].compareTo(o2[0]) > 0)
					return 1;
				else if (o1[0].compareTo(o2[0]) == 0) {

					if (o1[1].compareTo(o2[1]) >= 0)
						return 1;

					else
						return -1;
				} else
					return -1;
			}
		});

		String startingPlace = "ICN";
		String targetPlace = "";

		List<List<String>> listString = new ArrayList<List<String>>();

		for (int i = 0; i < tickets.length; i++) {
			List<String> aList = new ArrayList<>(Arrays.asList(tickets[i][0], tickets[i][1]));
			listString.add(aList);
		}

		for (int i = 0; i < listString.size(); i++) {
			mainTravelMap.put(new ArrayList<>(Arrays.asList(listString.get(i).get(0), listString.get(i).get(1))),
					false);
		}

		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals(startingPlace)) {
				targetPlace = tickets[i][1];
				answerList = new ArrayList<>();
				var smth = answerList;
				if (dfs(startingPlace, targetPlace, tickets, smth, 1)) {
					break;
				}
			}
		}

		String[] answer = new String[answerList.size()];

		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}
}