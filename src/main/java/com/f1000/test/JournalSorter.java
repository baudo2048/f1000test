package com.f1000.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class JournalSorter {
	
	/**
	 * Given a set of journals returns all journals ordered by rank.
	 * 
	 * @param journals - Unordered set of journals
	 * @return
	 */
	public static List<Journal> toOrderedList(Set<Journal> journals){
		return toOrderedList(journals, (j)->true);
	}
	
	
	/**
	 * Given a set of journals returns all no-review journals ordered by rank.
	 * 
	 * @param journals - Unordered set of journals
	 * @param ecludeReview - 
	 * @return
	 */
	public static List<Journal> toOrderedListNoReview(Set<Journal> journals){
		return toOrderedList(journals, (j)->!j.isReview());
	}
	
	
	/**
	 * Given a set of journals returns all journals ordered by rank.
	 * 
	 * @param journals - Unordered set of journals
	 * @param filter - A predicate indicating which journals to include in the final report.
	 * @return
	 */
	public static List<Journal> toOrderedList(Set<Journal> journals, Predicate<Journal> filter){
		List<Journal> res = new ArrayList<Journal>();
		
		if (journals == null)
			return res;
		
		journals.stream()
			.filter(filter)
			.forEach((j)->res.add(j));;
		
		res.sort((j1,j2)->{
			if(j1.getScore()<j2.getScore())
				return 1;
			else if (j1.getScore()>j2.getScore())
				return -1;
			else return (j1.getName()).compareTo(j2.getName());
		});
		
		if (res.size()>0) {
			res.get(0).setRank(1);
			for (int i=1;i<res.size();i++) {
				if(res.get(i).getScore()==res.get(i-1).getScore()) {
					res.get(i).setRank(res.get(i-1).getRank());
				} else {
					res.get(i).setRank(i+1);
				}
			}
		}
		return res;
	}
}
