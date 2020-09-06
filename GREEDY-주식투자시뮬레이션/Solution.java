import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	int initialInvestment = 100;
    	int monthlyContribution = 20;
    	String[] stockPrices = {
    			"40 50 60",
    			"37 48 55",
    			"100 48 50",
    			"105 48 47",
    			"110 50 52",
    			"110 50 52",
    			"110 51 54",
    			"109 49 53"
    	};
    	System.out.print(maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
    }
    public static int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
    	int money = initialInvestment;
    	int month = stockPrices.length;
    	int corp = stockPrices[0].split(" ").length;
    	
    	int[][] prices = new int[month][corp];
    	double max = 0, profit = 0;
    	double[] proportion = new double[month-1];
    	boolean[] buy = new boolean[month - 1];
    	
    	// 처리하기 쉽게 숫자 배열로 변환
    	for (int i = 0; i < month; i++) {
			String[] s = stockPrices[i].split(" ");
			
			for (int j = 0; j < corp; j++) {
				prices[i][j] = Integer.valueOf(s[j]);
			}
		}
    	
    	// 반복문을 역으로 돌려 거슬러 올라가면서
    	// 각 월까지의 최대 증가율을 사야 하는지 기록함
    	for (int i = month-2; i >= 0; i--) {
			for (int j = 0; j < corp; j++) {
				int a = prices[month - 1][j];
				int b = prices[i][j];
				double p = 1.0 * prices[month - 1][j] / prices[i][j] - 1;
				if(0< p && max < p) {
					buy[i] = true;
					max = p;
					proportion[i] = p;
				}
			}
		}
    	
    	// 처음부터 시작해서 사야 하는 달이 오면 모든 자금을 투자함
    	for (int i = 0; i < buy.length; i++) {
			if(buy[i]) {
				profit+=money*proportion[i];
				money = 0;
			}
			money+=monthlyContribution;
		}
    	return (int)Math.round(profit);
    }
}
