/* Leetcode Problem 134.

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin 
the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int gasInCar = 0;
        int totalGas = 0;
        int totalCost = 0;
        
        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if(totalCost > totalGas)
            return -1;
        
        for(int i=0; i<gas.length; i++){
            gasInCar += gas[i] - cost[i];
            
            if(gasInCar >= 0)
                continue;
            else{
                if(i == gas.length-1)
                    start = -1;
                else{
                    gasInCar = 0;
                    start = i+1;
                }
            }
        }
        return start;
    }
}
