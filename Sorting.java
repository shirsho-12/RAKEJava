package src.rake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Sorting {

    public static <K, V extends Comparable> ArrayList<K> Sort(HashMap<K, V> results) {
		ArrayList<K> sortedUrls = new ArrayList<K>();
		sortedUrls.addAll(results.keySet());

		Sorting.quicksort(shuffle(sortedUrls), results, 0, sortedUrls.size() - 1);
    	return sortedUrls;
    }
	 private static <K, V extends Comparable> int partition(ArrayList<K> arr, HashMap<K, V> results, int low, int high){
		V pivot = results.get(arr.get(high));
		int i = low - 1;
		for (int j = low; j < high; j++){
			if (results.get(arr.get(j)).compareTo(pivot) >= 0){
				i++;
				K temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		K temp = arr.get(i+1);
		arr.set(i+1, arr.get(high));
		arr.set(high, temp);
		return (i+1);
	 }

	 private static <K, V extends Comparable> void quicksort(ArrayList<K> arr, HashMap<K, V> results, int low, int high){
		if (low < high){
			int idx = partition(arr, results, low, high);
			quicksort(arr, results, low, idx - 1);
			quicksort(arr, results, idx + 1, high);
		}

	 }

     private static <K, V extends Comparable> ArrayList<K> shuffle(ArrayList<K> array){

    	Random rand = new Random();
    	rand.setSeed(123456789);

		for (int i = 0; i < array.size(); i++) {
			int randomIndexToSwap = rand.nextInt(array.size());
			K temp = array.get(randomIndexToSwap);
			array.set(randomIndexToSwap, array.get(i));
			array.set(i, temp);
		}
		return array;
     }
}
