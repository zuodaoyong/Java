package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;

/**
 * 归并排序
 * @author zdy48195
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,12,9,5,3,71,24};
		Integer[] dest=new Integer[]{1,12,9,5,3,71,24};
		//Integer[] arr=new Integer[]{1,21,15,85,31,14,51,65,6,96,78,55,30,66,17,90,48,72,17,43,48,56,50,7,39,38,34,69,14,95};
		//Integer[] dest=new Integer[]{1,21,15,85,31,14,51,65,6,96,78,55,30,66,17,90,48,72,17,43,48,56,50,7,39,38,34,69,14,95};
		mergeSort(arr, dest, 0, arr.length, 0);
		CommonUtils.print(dest);
	}
	
	private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
		int length = high - low;
		if (length < 7) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
					CommonUtils.swap(dest, j, j - 1);
			return;
		}
		// Recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		
		// If list is already sorted, just copy from src to dest. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
		
	}
}
