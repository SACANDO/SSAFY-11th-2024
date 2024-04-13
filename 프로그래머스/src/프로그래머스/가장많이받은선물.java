package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장많이받은선물 {

	static int[][] Gifts;
	static int[] jisu;
	static int[] nextMonth;

	public int solution(String[] friends, String[] gifts) {

		int fNum = friends.length;
		jisu = new int[fNum];
		nextMonth = new int[fNum];
		List<String> fList = new ArrayList<>(Arrays.asList(friends));

		Gifts = new int[fNum][fNum];
		for (int i = 0; i < gifts.length; i++) {
			String[] line = gifts[i].split(" ");
			// 준사람 row
			// 받은사람 column
			Gifts[fList.indexOf(line[0])][fList.indexOf(line[1])]++;
			jisu[fList.indexOf(line[0])]++;
			jisu[fList.indexOf(line[1])]--;
		}

		for (int i = 0; i < fNum; i++) {
			for (int j = i + 1; j < fNum; j++) {

				int win = 0;

				if (Gifts[i][j] == Gifts[j][i]) {
					if (jisu[i] != jisu[j]) {
						win = jisu[i] > jisu[j] ? i : j;
						nextMonth[win]++;
					}
				} else {
					win = Gifts[i][j] > Gifts[j][i] ? i : j;
					nextMonth[win]++;
				}

			}
		}

		int answer = 0;

		for (int i = 0; i < fNum; i++) {
			answer = nextMonth[i] > answer ? nextMonth[i] : answer;
		}
		return answer;
	}

}
