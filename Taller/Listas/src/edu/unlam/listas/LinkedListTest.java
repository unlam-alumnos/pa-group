package edu.unlam.listas;

import java.util.LinkedList;

public class LinkedListTest extends BaseListTest {
	@Override
	public void buildDummyList(int amount) {
		list = new LinkedList<Integer>();
		for (int i = 0; i < amount; i++) {
			list.add(i);
		}
	}
}
