import java.util.*;

public class Solution {
    static ArrayList<String> permvalues = new ArrayList<String>();

    public static void main(String[] args) {
        String[][] test = { { "A", "B" }, { "D", "F" }, { "K", "C" }, { "A", "A" } };

        Arrays.sort(test, new Comparator<String[]>() {

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
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][0] + "  " + test[i][1]);
            }
            System.out.println();
        }
    }
}