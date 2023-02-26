package Qnum5;

/*

Assume an electric vehicle must go from source city s to destination city d. You can locate many service centers along the journey that allow for the replacement of batteries; however, each service center provides batteries with a specific capacity. You are given a 2D array in which servicecenter[i]=[xi,yj] indicates that the ith service center is xi miles from the source city and offers yj miles after the automobile can travel after replacing batteries at specific service centers. Return the number of times the car's batteries need to be replaced before arriving at the destination.
Input: serviceCenters = [{10,60},{20,30},{30,30},{60,40}], targetMiles= 100, startChargeCapacity = 10
Output: 2
Explanation: The car can go 10 miles on its initial capacity; after 10 miles, the car replaces batteries with a capacity of 60 miles; and after travelling 50 miles, at position 60 we change batteries with a capacity of 40 miles; and ultimately, we may arrive at our destination.

 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



class Anum5b {

    public int batteryReplacement(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
        int replacements = 0;
        int remainingMiles = startChargeCapacity;

        for(int i = 0; i < serviceCenters.length; ++i) {
            int milesToService = i > 0 ? serviceCenters[i][0] - serviceCenters[i - 1][0] : serviceCenters[i][0];
            if (remainingMiles < milesToService) {
                ++replacements;
                remainingMiles = serviceCenters[i][1];
            }

            remainingMiles -= milesToService;
            if (remainingMiles >= targetMiles - serviceCenters[i][0]) {
                return replacements;
            }
        }

        return replacements;
    }

    public static void main(String[] args) {
        int[][] serviceCenters = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int targetMiles = 100;
        int startChargeCapacity = 10;
        Anum5b solution = new Anum5b();
        int result = solution.batteryReplacement(serviceCenters, targetMiles, startChargeCapacity);
        System.out.println("Result: " + result);
    }
}