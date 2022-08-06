import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MinDuplicateIndex {
	
	public static void main(String[] args) {
		Integer[] a = {3, 1, 4, 3, 4, 5};
//		Integer[] a = {3,4,4,3};
//		Integer[] a = {2, 2};
//		Integer[] a = {2, 4, 3, 5, 1};
//		Integer[] a = {2, 1,4, 3,4,5, 3,2};
		List<Integer> sampleList = Arrays.asList(a);
		Set<Integer> sampleSet = new HashSet<Integer>();
		sampleSet.addAll(sampleList);
		Iterator<Integer> it = sampleSet.iterator();
		int result = -1;
		int index = sampleList.size();
		while(it.hasNext()) {
			int sample = it.next();
			int indexLatest = sampleList.subList(sampleList.indexOf(sample)+1, sampleList.size()).indexOf(sample);
			if(indexLatest == -1 ) {
				continue;
			}
			else {
				int position = sampleList.indexOf(sample)+indexLatest+1;
				if(position < index) {
					index = position;
					result = sample;
				}
			}
		}
		
		System.out.println("The output is: "+ result);
	}

}
