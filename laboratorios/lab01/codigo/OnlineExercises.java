/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

/**
 *
 * @author Isabella Quintero, Sofia Vega
 * Vr 1.0
 */
public class OnlineExercises {

    //Recursion 1

    

    public int factorial(int n) {
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1); 
    }

    
    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return bunnies;
        }
        return 2 + bunnyEars(bunnies-1);
    }

    
    public int fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    
    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        return  rows + triangle(rows-1);
    }

    
    public int powerN(int base, int n) {
        if(n<=1) return base;
        return base*powerN(base,n-1);
    }

    //Recursion 2

    

    public static boolean groupSum6(int start, int[] nums, int target) {
        if(start==nums.length)return target==0;
        if(nums[start]==6){
            target-=6;
        }
        if(groupSum6(start+1,nums,target-nums[start])) return true;
        if(groupSum6(start+1,nums,target)) return true;
        return false;
    }

    
    public static boolean groupSumClump(int start, int[] nums, int target) {
        if(start>=nums.length) return target == 0;
        if(start<nums.length-1 && nums[start]==nums[start+1]) { 
            int i = nums[start] + nums[start+1];
            target += i;
        }
        return groupSumClump(start+1,nums,target-nums[start]) || groupSumClump(start+1,nums,target);

    }

    
    public static boolean groupSum5(int start, int[] nums, int target) {
        if(start==nums.length)return target==0;
        if(nums[start]%5==0){
            if(start<nums.length-1 && nums[start+1] == 1){
                return groupSum5(start+2,nums,target-nums[start]);
            } 
            target -= nums[start];
        }
        return groupSum5(start+1,nums,target-nums[start]) ||
        groupSum5(start+1,nums,target);
    }

   
    public boolean splitArray(int[] nums) {
        return splitArrayAux(0,nums,0,0);
    }

    
    public boolean splitArrayAux(int start, int[] nums, int a, int b){
        if(start>=nums.length){
            return a == b;
        }
        return splitArrayAux(start+1,nums,a+nums[start],b) ||
        splitArrayAux(start+1,nums,a,b+nums[start]);
    }

    
    public boolean split53(int[] nums) {
        return split53Aux(0,nums,0,0);
    }

    
    public boolean split53Aux(int start,int[] nums, int n, int m){
        if(start>=nums.length){
            return n == m;
        }
        if(nums[start]%3==0 && nums[start]%5!=0){
            return split53Aux(start+1,nums,n,m+nums[start]);
        } 
        if(nums[start]%5==0){
            return split53Aux(start+1,nums,n+nums[start],m);
        }
        return split53Aux(start+1,nums,n+nums[start],m) || 
        split53Aux(start+1,nums,n,m+nums[start]);
    }

}
