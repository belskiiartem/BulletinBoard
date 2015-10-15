package belskii.artem.bulletinboard.dao.category;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class CategoryDaoHiberImplTest {

	@Test
	public void testGetAllCategories() {
		CategoryDaoHiberImpl category = new CategoryDaoHiberImpl();
		assertTrue(category.getAllCategories().size()>0);
		assertTrue(!category.getAllCategories().get(0).getCategoryTitle().equals(""));
	}

	@Test
	public void testAddCategories() {
		CategoryDaoHiberImpl category = new CategoryDaoHiberImpl();
		Random random = new Random();
		
		assertTrue(category.AddCategories("category"+random.nextInt())>0);
		
	}

	@Test
	public void testRemoveCategories() {
		CategoryDaoHiberImpl category = new CategoryDaoHiberImpl();
		assertEquals(category.getAllCategories().get(0).getCategoryTitle(), category.removeCategories(1L));
	}

}
