package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.avltree.AvlTreeSet;

public class AvlTreeSetTest {
	
	@Test(expected = IllegalStateException.class)
	public void getMinException() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.getMin();
	}
	
	@Test(expected = IllegalStateException.class)
	public void getMaxException() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.getMax();
	}
	
	@Test(expected = IllegalStateException.class)
	public void removeException() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.remove(0);
	}
	
	@Test
	public void isEmpty() {
		AvlTreeSet tree = new AvlTreeSet();
		assertTrue(tree.isEmpty());
		
		tree.insert(1);
		tree.insert(10);
		tree.insert(11);
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void test1() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(20);
		tree.insert(4);
		tree.insert(15);
		tree.insert(15);
		assertEquals(3, tree.size());
		assertEquals(1,tree.getHeight());
		
		assertFalse(tree.contains(1));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(20));
	}
	
	@Test
	public void test2() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(20);
		tree.insert(4);
		tree.insert(26);
		tree.insert(3);
		tree.insert(9);
		assertEquals(2,tree.getHeight());
		
		tree.insert(15);
		assertEquals(2,tree.getHeight());
		
		assertEquals(26,tree.getMax());
		assertEquals(3,tree.getMin());
	}
	
	@Test
	public void test3() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(20);
		tree.insert(40);
		tree.insert(30);	
		tree.remove(20);
		
		assertEquals(2,tree.size());
		
	}
	
	@Test
	public void test4() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(100);
		tree.insert(90);
		tree.insert(30);
		
		assertTrue(tree.contains(30));
		assertFalse(tree.contains(40));
		
		tree.insert(10);
		tree.remove(30);
		
		tree.insert(1);
		tree.insert(15);
		tree.remove(10);
		assertEquals(2,tree.getHeight());

	}
	
	@Test
	public void test5() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(100);
		tree.insert(90);
		tree.insert(30);
		

		tree.insert(101);
		tree.insert(91);
		tree.remove(100);
		assertEquals(2,tree.getHeight());

		
	}

}
