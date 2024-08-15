import java.util.Arrays;

//https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] ratings = {1, 6, 10, 8, 7, 3, 2};
        System.out.println(c.candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] extra = new int[ratings.length];
        Arrays.fill(extra, 1);

        // loop from left to right and increment right by left's candy +1, if left is smaller than right
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                extra[i + 1] = extra[i] + 1;
            }
        }

        // loop from right to left and increment left by right's candy +1, if right is smaller than left
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                if (extra[i - 1] <= extra[i]) {
                    extra[i - 1] = extra[i] + 1;
                }
            }
        }
        return Arrays.stream(extra).sum();
    }
}
