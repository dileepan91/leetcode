
//leetcode url : https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
public class HIndex {

    // Processing from the highest paper count to the lowest, iterate through the citation list and retrieve citations that are greater than or equal to the current paper count. Then, check if the paper count matches the number of such citations.
    public int hIndex(int[] citations) {
        for (int i = citations.length; i > 0; i--) {
            int hIndex = 0;
            for (int ref : citations) {
                if ( i <= ref) {
                    hIndex++;
                }
                if (hIndex == i) {
                    return hIndex;
                }
            }
        }
        return 0;
    }
}
