package br.com.popoto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestSequence {

	public List<Integer> calculate(List<String> tags, List<String> availableTags) {
		List<List<Integer>> sequences = buildCartesianProduct(findSequences(tags, availableTags));
		return findShortestPath(sequences);
	}

	private List<List<Integer>> findSequences(List<String> tags, List<String> availableTags) {

		List<List<Integer>> sequences = new ArrayList<List<Integer>>();

		for (String tag : tags) {

			List<Integer> sequence = new ArrayList<Integer>();

			for (int i = 0; i < availableTags.size(); i++) {

				if (tag.equalsIgnoreCase(availableTags.get(i))) {

					sequence.add(i);

				}

			}

			sequences.add(sequence);

		}

		return sequences;

	}

	private List<List<Integer>> buildCartesianProduct(List<List<Integer>> sequences) {

		List<List<Integer>> resultLists = new ArrayList<List<Integer>>();
		
		if (sequences.size() == 0) {
			
			resultLists.add(new ArrayList<Integer>());
			return resultLists;
			
		} else {
			
			List<Integer> firstList = sequences.get(0);
			List<List<Integer>> remainingLists = buildCartesianProduct(sequences.subList(1, sequences.size()));
			
			for (int condition : firstList) {
				
				for (List<Integer> remainingList : remainingLists) {
					
					ArrayList<Integer> resultList = new ArrayList<Integer>();
					resultList.add(condition);
					resultList.addAll(remainingList);
					Collections.sort(resultList);
					resultLists.add(resultList);
					
				}
				
			}
			
		}
		
		return resultLists;

	}

	private List<Integer> findShortestPath(List<List<Integer>> sequences) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if (sequences.isEmpty()) {
			return result;
		}
		
		int shortestPathSize = 0;
		int currentPathSize = 0;
		int firstIndex = 0;
		int lastIndex = 0;
		
		for (List<Integer> sequence : sequences) {
		
			currentPathSize = sequence.get(sequence.size()-1) - sequence.get(0);

			if (currentPathSize < shortestPathSize || shortestPathSize == 0) {
				shortestPathSize = currentPathSize;
				firstIndex = sequence.get(0);
				lastIndex = sequence.get(sequence.size()-1);
			}
				
		}
		
		result.add(firstIndex);
		result.add(lastIndex);
		
		return result;
		
	}

}
