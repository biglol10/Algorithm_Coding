import java.util.*;

public class Solution {
    static long[] salaries;

    public static void main(String[] args) {
        String[] relations = { "NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN" };
        System.out.println(totalSalary(relations));
    }

    public static long totalSalary(String[] relations) {
        salaries = new long[relations.length];
        long total = 0;
        for (int i = 0; i < relations.length; i++) {
            total += getSalary(i, relations);
        }
        return total;
    }

    public static long getSalary(int i, String[] relations) {
        if (salaries[i] == 0) {
            long salary = 0;
            String relation = relations[i];
            for (int j = 0; j < relations.length; j++) {
                if (relation.charAt(j) == 'Y') {
                    salary = salary + getSalary(j, relations);
                }
            }
            if (salary == 0)
                salary = 1;
            salaries[i] = salary;
        }
        return salaries[i];
    }
}