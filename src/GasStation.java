
// https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int tank = 0;
        for(int n = 0;n < Integer.MAX_VALUE;n++) {
            for (int i = 0; i < gas.length;) {
                tank = tank + gas[i];
                if (tank >= cost[i]) {
                    if(start == -1) {
                        start = i;
                    }
                    tank = tank - cost[i];
                    i++;
                } else if(start != -1) {
                    // this means we have started at a gas station but we dont have enough to go next station, so reset the start gas startion to the next station
                    i = start +1;
                    start = -1;
                    tank = 0;
                } else {
                    // still the starting gas station is not found.
                    tank = 0;
                    i++;
                }
                if(i == start) {
                    return start;
                }
            }
            if(start == -1) {
                // we have visited all gas station and none of them have enough gas to start.
                return -1;
            }
            if(start == 0) {
                // if the start position is 0, and we have visited all station, coming through the loop again to visit 0th station.
                return start;
            }
        }
        return start;
    }
}
