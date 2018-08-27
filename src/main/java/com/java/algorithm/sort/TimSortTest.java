package com.java.algorithm.sort;

import java.util.Comparator;

import com.java.algorithm.common.CommonUtils;

public class TimSortTest {

	private static final int MIN_MERGE = 32;

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,12,9,5,3};
		Comparator<Integer> c=(o1,o2)->o1.compareTo(o2);
		sort(arr, 0, arr.length,c, null,0,0);
		CommonUtils.print(arr);
	}
	static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c, T[] work, int workBase, int workLen) {
		assert c != null && a != null && lo >= 0 && lo <= hi && hi <= a.length;

		int nRemaining = hi - lo;
		if (nRemaining < 2)
			return; // Arrays of size 0 and 1 are always sorted

		// If array is small, do a "mini-TimSort" with no merges
		if (nRemaining < MIN_MERGE) {
			int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
			binarySort(a, lo, hi, lo + initRunLen, c);
			return;
		}

		/**
		 * March over the array once, left to right, finding natural runs,
		 * extending short natural runs to minRun elements, and merging runs to
		 * maintain stack invariant.
		 */
		TimSort<T> ts = new TimSort<T>(a, c, work, workBase, workLen);
		int minRun = minRunLength(nRemaining);
		do {
			// Identify next run
			int runLen = countRunAndMakeAscending(a, lo, hi, c);

			// If run is short, extend to min(minRun, nRemaining)
			if (runLen < minRun) {
				int force = nRemaining <= minRun ? nRemaining : minRun;
				binarySort(a, lo, lo + force, lo + runLen, c);
				runLen = force;
			}

			// Push run onto pending-run stack, and maybe merge
			ts.pushRun(lo, runLen);
			ts.mergeCollapse();

			// Advance to find next run
			lo += runLen;
			nRemaining -= runLen;
		} while (nRemaining != 0);

		// Merge all remaining runs to complete sort
		assert lo == hi;
		ts.mergeForceCollapse();
		assert ts.stackSize == 1;
	}

	private static <T> int countRunAndMakeAscending(T[] a, int lo, int hi, Comparator<? super T> c) {
		assert lo < hi;
		int runHi = lo + 1;
		if (runHi == hi)
			return 1;

		// Find end of run, and reverse range if descending
		if (c.compare(a[runHi++], a[lo]) < 0) { // Descending
			while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) < 0)
				runHi++;
			reverseRange(a, lo, runHi);
		} else { // Ascending
			while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) >= 0)
				runHi++;
		}

		return runHi - lo;
	}
	
	@SuppressWarnings("fallthrough")
    private static <T> void binarySort(T[] a, int lo, int hi, int start,
                                       Comparator<? super T> c) {
        assert lo <= start && start <= hi;
        if (start == lo)
            start++;
        for ( ; start < hi; start++) {
            T pivot = a[start];

            // Set left (and right) to the index where a[start] (pivot) belongs
            int left = lo;
            int right = start;
            assert left <= right;
            /*
             * Invariants:
             *   pivot >= all in [lo, left).
             *   pivot <  all in [right, start).
             */
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (c.compare(pivot, a[mid]) < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            assert left == right;

            /*
             * The invariants still hold: pivot >= all in [lo, left) and
             * pivot < all in [left, start), so pivot belongs at left.  Note
             * that if there are elements equal to pivot, left points to the
             * first slot after them -- that's why this sort is stable.
             * Slide elements over to make room for pivot.
             */
            int n = start - left;  // The number of elements to move
            // Switch is just an optimization for arraycopy in default case
            switch (n) {
                case 2:  a[left + 2] = a[left + 1];
                case 1:  a[left + 1] = a[left];
                         break;
                default: System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = pivot;
        }
    }
	
	private static void reverseRange(Object[] a, int lo, int hi) {
        hi--;
        while (lo < hi) {
            Object t = a[lo];
            a[lo++] = a[hi];
            a[hi--] = t;
        }
    }
	
	private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
}
