package com.coding.test;
import java.util.Arrays;

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		DeDup de = new DeDup();

		System.out.println(Arrays.toString(de.randomIntegers));
		System.out.println(Arrays.toString(de.getDistinctIntegers()));
		
		//System.out.println(Arrays.toString(de.getDistinctIntegersUsingJavaAPI()));
		
		//System.out.println(Arrays.toString(de.getDistinctOrderedIntegers()));
	}

	
	/**
	 * This method will return the distinct elements from given integer array without changing  
	 * the order of the Array
	 * Remove the duplicate values
	 * 
	 * @return Int[] Distinct integers
	 */
	public int[] getDistinctIntegers() {
		if (randomIntegers.length == 0) {
			return randomIntegers;
		}

		return removeDuplicatesUnOrderedArray(randomIntegers);
	}

	
	/**
	 * This method used to get the distinct elements from given integer array in 2 steps 
	 * Sort the integers using efficient QuickSort 
	 * Remove the duplicate values
	 * 
	 * @return Int[] Distinct integers
	 */
	public int[] getDistinctOrderedIntegers() {
		if (randomIntegers.length == 0) {
			return randomIntegers;
		}

		quicksort(randomIntegers, 0, randomIntegers.length - 1);
		return removeDuplicatesOrderedArray(randomIntegers);
	}
	
	/**
	 * This method does use the the JAVA API Arrays Sort method to sort.
	 * 
	 * @return
	 */
	public int[] getDistinctIntegersUsingJavaAPI() {
		if (randomIntegers.length == 0) {
			return randomIntegers;
		}

		Arrays.sort(randomIntegers);
		return removeDuplicatesOrderedArray(randomIntegers);
	}


	private int[] removeDuplicatesOrderedArray(final int[] values) {
		if (values.length == 0) {
			return values;
		}

		int[] temp = new int[values.length];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			int current = values[i];

			if (count > 0)
				if (temp[count - 1] == current)
					continue;

			temp[count] = current;
			count++;
		}
		int[] whitelist = new int[count];
		System.arraycopy(temp, 0, whitelist, 0, count);
		return whitelist;
	}

	private void quicksort(final int[] values, final int low, final int high) {
		int i = low, j = high;
		int pivot = values[low + (high - low) / 2];
		while (i <= j) {
			while (values[i] < pivot) {
				i++;
			}
			while (values[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(values, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			quicksort(values, low, j);
		}
		if (i < high) {
			quicksort(values, i, high);
		}
	}

	private void swap(final int[] values, final int i, final int j) {
		final int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
	
	
	private  int[] removeDuplicatesUnOrderedArray(int[] values) {
		
		if (values.length == 0) {
			return values;
		}
		
	    int[] filterdArray = new int[values.length];
	    int j = 0;
	    int count = 0;
	    for (int i : values) {
	        if (!isExist(filterdArray, i)) {
	        	filterdArray[j++] = i;
	            count++;
	        }
	    }
	    int[] result = new int[count];
	    System.arraycopy(filterdArray, 0, result, 0, count);
        return result;
	}

	private static boolean isExist(int[] result, int i) {
	    for (int j : result) {
	        if (j == i) {
	            return true;
	        }
	    }
	    return false;
	}

}
