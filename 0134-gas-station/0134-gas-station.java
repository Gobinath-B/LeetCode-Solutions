class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas =0;
        int total_cost =0;
        int currentgas =0;
        int startindex = 0;
        for(int i=0;i<gas.length;i++){
            total_gas += gas[i];
            total_cost += cost[i];
            currentgas += gas[i] -cost[i];

            if(currentgas <0){
              startindex =i+1;
              currentgas =0;
            }
        }
        if(total_gas<total_cost){
            return -1;
        }else{
            return startindex;
        }
    }
}