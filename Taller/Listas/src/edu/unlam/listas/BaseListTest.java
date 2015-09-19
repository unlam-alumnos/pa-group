package edu.unlam.listas;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class BaseListTest {
	protected List<Integer> list;
	
	@Before
	public void setUp() {
		buildDummyList(10);
	}
	
	@Test
	public void assertAgregar() {
		// When
		list.add(100);
		
		// Then
		Assert.assertEquals(11, list.size());
	}

	@Test
	public void assertRemover() {
		// When
		list.remove(1);
		
		// Then
		Assert.assertEquals(9, list.size());
	}
	
	@Test
	public void assertObtener() {
		// Given
		Integer expected = 0;
				
		// When
		Integer element = list.get(0);
		
		// Then
		Assert.assertEquals(expected, element);
	}
	
	@Test
	public void assertMostrar() {
		// When
		String output = list.toString();
		
		// Then
		Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", output);
	}
	
	@Test
	public void assertRecorrer() {
		// When
		StringBuffer output = generateOutput();
		
		// Then
		Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", output.toString());
	}
	
	@Test
	public void assertRecorrerComoIterator() {
		// When
		StringBuffer output = generateIteratorOutput();
		
		// Then
		Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", output.toString());
	}
	
	protected StringBuffer generateOutput() {
		StringBuffer output = new StringBuffer("[");
		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i));
			if (i < list.size() - 1) {
				output.append(", ");
			}
		}
		output.append("]");
		return output;
	}
	
	protected StringBuffer generateIteratorOutput() {
		StringBuffer output = new StringBuffer("[");
		while (list.iterator().hasNext()) {
			output.append(list.iterator().next());
			if (list.iterator().hasNext()) {
				output.append(", ");
			}
		}
		output.append("]");
		return output;
	}
	
	protected abstract void buildDummyList(int amount);
}
