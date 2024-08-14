
// https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, diff = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            diff += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + i;
            }
        }
        return diff < 0 ? -1 : start;
    }
}
