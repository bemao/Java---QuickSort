import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class QuickSort {
    long comps;
	
	QuickSort() {
		comps = 0;  //initialize comparison counter
	}
	
  private void swap(int i, int k, Integer[] array_in){
    // helper function - swaps elements i and k in array_in
		int tmp = array_in[i];
		array_in[i] = array_in[k];
		array_in[k] = tmp;
    }
	
	int partition(int pivot_position, int beg, int end, Integer[] nums){
		comps += end - beg - 1;  //number of comparisons to the pivot are added to the comparison counter
		
		int i = 1; // points to left-most element > pivot
		
		//move pivot to position "beg" in array
        if (nums[beg] != nums[pivot_position]){
        	swap(beg, pivot_position, nums);
        }
		
		for (int j = 1; j<end; j++){
			if (nums[j] <= nums[beg]){
				swap(j,i, nums);
				i++;
			}
		}
		swap(i-1, beg, nums);
		return i-1;
	}
	
	
	public void sort(Integer[] nums){
		int len = nums.length;
		sort(0, len, nums);
	}
	
	public void sort(int beg, int end, Integer[] nums){
		if (end-beg < 1){
			return;
		}
		
		//choose pivot and partition
		Random rand = new Random();
		int pivot = rand.nextInt(end - beg) + beg;
		pivot = partition(pivot, beg, end, nums);
		
		//sort left and right halves;
		sort(beg, pivot, nums);
		sort(pivot+1, end, nums); 
	}
	
	public long get_comps(){
		return comps;
	}
}
