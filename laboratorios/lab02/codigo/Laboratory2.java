/**
 *
 * @author Isabella Quintero, Sofia Vega
 * 
 * The class Laboratory2 has the solution of the point 1 of the proyect simulator.
 */
public class Laboratory2 {

    /**
     * This is the main method of the class, it runs the others and takes the times
     * of execution of each one.
     */
    public static void main(String[] args) {
        System.out.println("Insertion Sort");
        for(int i = 50000 ; i < 52000 ; i+=100){
            int [] arr = crearArreglo(i,0,100);
            long startTime = System.currentTimeMillis();
            insertionSort(arr);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        System.out.println("Merge Sort");
        for(int i = 50000 ; i < 52000 ; i+=100){
            int [] arr = crearArreglo(i,0,100);
            long startTime = System.currentTimeMillis();
            sort(arr,0,arr.length-1);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        
    }
    /**
     * This method print a given array.
     */
   
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    /**
     * This method creates and full an array with random numbers.
     */
     public static int[] crearArreglo(int tamaño,int limInf, int limSup){
        int[] array = new int[tamaño];
        for(int i = 0 ; i < tamaño ; i++){
           array[i] = (int) (Math.random() * (limInf-limSup)+limSup);
        }
        return array;
    }

    /**
     * This is the method that has as result the insertion sort algorithm.
     */
    public static void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }
    
    // Main function that sorts arr[l..r] using 
    // merge() 
    /**
     * This is the method that has as result the merge sort algorithm.
     */
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    /**
     * This method is an auxiliar method of sort(), it helps to complete the solution of the algorithm.
     */
    public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    
}