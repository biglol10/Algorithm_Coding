import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] duration = { 400, 100, 100, 100 };
        String[] user = { "Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor" };
        System.out.println(schedule(duration, user));
    }

    public static int[] schedule(int[] duration, String[] user) {
        int N = duration.length;

        HashMap<String, Long> jobTime = new HashMap<String, Long>();
        for (int n = 0; n < N; n++) {
            jobTime.put(user[n], 0L);
        }
        for (int n = 0; n < N; n++) {
            jobTime.put(user[n], jobTime.get(user[n]) + duration[n]);
        }
        boolean[] done = new boolean[N];
        int[] ans = new int[N];
        int ansCount = 0;
        while (ansCount < N) {
            String next = "";
            for (int n = 0; n < N; n++) {
                var smth = jobTime.get(user[n]);
                var qwer = jobTime.get(next);
                if (!done[n] && (next.equals("") || jobTime.get(user[n]) < jobTime.get(next))) {
                    next = user[n];
                }
            }
            for (int n = 0; n < N; n++) {
                if (user[n].equals(next)) {
                    done[n] = true;
                    ans[ansCount++] = n;
                }
            }
        }
        return ans;
    }

}