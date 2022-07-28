/*
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
*/

// Approach use tortoise method 
// process slow one time and fast two time 
// until you reach at conclusion.

class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        do{
            slow=findSquareSum(slow);
            fast=findSquareSum(fast);
            fast=findSquareSum(fast);
        }while(slow!=fast);
        return slow==1;
    }
    private int findSquareSum(int n){
        int sum=0;
        while(n>0){
            int temp=n%10;
            sum+=temp*temp;
            n/=10;
        }
        return sum;
    }
}