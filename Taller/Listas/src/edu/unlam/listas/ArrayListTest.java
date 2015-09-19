package edu.unlam.listas;

import java.util.ArrayList;

public class ArrayListTest extends BaseListTest {
	@Override
	public void buildDummyList(int amount) {
		list = new ArrayList<Integer>();
		for (int i = 0; i < amount; i++) {
			list.add(i);
		}
	}
}
