package com.f1000.test;

import static com.f1000.test.JournalSorter.*;
import static com.f1000.test.JournalSorterTestUtils.*;

import static org.junit.Assert.*;

import org.junit.*;

public class JournalSorterTests {

	@Test
	public void testExists() {
		assertNotNull(toOrderedList(withDefaultDataset()));
		assertNotNull(toOrderedList(withDataset("dataset00.xml")));
		assertNotNull(toOrderedList(null));
	}
	
	@Test
	public void testSize() {
		assertEquals(toOrderedList(withDefaultDataset()).size(), 1);
		assertEquals(toOrderedList(withDataset("dataset02.xml")).size(), 1);

	}
	
	@Test
	public void testWithReview() {
		assertEquals(toOrderedListNoReview(withDataset("dataset02.xml")).size(), 1);
		assertEquals(toOrderedListNoReview(withDataset("dataset03.xml")).get(1).getRank(), 1);
	}
	
	/* ... other tests ... */
}
