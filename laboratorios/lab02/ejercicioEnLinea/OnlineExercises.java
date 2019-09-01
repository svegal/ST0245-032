/*
 */
package laboratorios;

/**
 *
 * @author Isabella Quintero, Sofia Vega
 */
public class OnlineExercises {
    //Array 2
    public int countEvens(int[] nums) {
  int cont = 0;
  for(int i = 0 ; i< nums.length ; i++){
    if(nums[i] % 2 == 0){
      cont += 1;
    }
  }
  return cont;
}
    
    public int centeredAverage(int[] nums) {
  int sum = 0;
  int max = 0;
  int min = 10000;
  for(int i = 0 ; i < nums.length ; i++){
    max = Math.max(max,nums[i]);
    min = Math.min(min,nums[i]);
    sum += nums[i];
  }
  return (sum-max-min)/(nums.length-2);
}
    
    public boolean lucky13(int[] nums) {
  for(int i = 0 ; i < nums.length ; i++){
    if(nums[i] == 1 || nums[i] == 3){
      return false;
    }
  }
  return true;
}
    
    public int matchUp(int[] nums1, int[] nums2) {
  int cont = 0;
  for(int i = 0 ; i < nums1.length ; i++){
    if(nums1[i] > nums2[i]){
      if((nums1[i]-nums2[i]) <= 2 && (nums1[i]-nums2[i]) > 0){
      cont++;
      }
    }else{
      if((nums2[i]-nums1[i]) <= 2 && (nums2[i]-nums1[i]) > 0){
      cont++;
      }
    }
  }
  return cont;
}
    
    public String[] fizzArray2(int n) {
  String [] arr = new String [n];
  for(int i = 0 ; i < arr.length ; i++){
    arr[i] = String.valueOf(i);
  }
  return arr;
}
    
    //Array 3
    public int maxSpan(int[] nums) {
  int maxSpan = 0;
  int span = 0;
  if(nums.length==1) maxSpan = 1;
  for (int i = 0 ; i <  nums.length ; i++){
    for (int j = nums.length-1 ; j > 0 ; j--){
      if(nums[i]==nums[j]){
        span = j-i+1;
        break;
      }
    }
    if(span > maxSpan) maxSpan = span;
  }
  return maxSpan;
}
    
    public int[] fix34(int[] nums) {
  int aux = 0;
  for(int i = 0; i<nums.length-1; i++){
    if(nums[i]==3 && nums[i+1]!=4)
      for(int j = 0; j<nums.length; j++){
        if(nums[j]==4 && nums[j-1]!=3){
          aux = nums[i+1];
          nums[i+1] = nums[j];
          nums[j] = aux;
        }
      }
  }
  return nums;
}
    
    public int[] fix45(int[] nums) {
  int aux = 0;
  for(int i = 0; i<nums.length-1; i++){
    if(nums[i]==4)
      for(int j = 0; j<nums.length; j++){
          if(nums[j] == 5 && j == 0 ){
          aux = nums[i+1];
          nums[i+1] = nums[j];
          nums[j] = aux;
          }
          if(j != 0 && nums[j] == 5 && nums[j-1] != 4){
          aux = nums[i+1];
          nums[i+1] = nums[j];
          nums[j] = aux;
          }
      }
  }
  return nums;
}
    
    public int[] seriesUp(int n) {
  int [] nums = new int [n*(n+1)/2];
  int aux = n;
  for (int i = nums.length-1 ; i >= 0 ; i--){
    nums[i] = aux;
    aux-=1;
    if(aux == 0){
    aux = n-1;
    n--;
    }
  }
  return nums;
}

    public int[] squareUp(int n) {
  int[] aux = new int[n * n];
  int x = n-1;
  int contar = 1;
  int inicio = 0;
  if(n == 0) { return aux; }
  for(int i = n-1; i < aux.length; i+=n) {
     
     inicio = i;
     for(int k = 1; k <= contar; k++) {
       aux[inicio] = k;
       inicio--;
     }
     contar++;
  }    
  return aux;
}
    
}
