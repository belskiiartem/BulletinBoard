package belskii.artem.bulletinboard.dao.advert;

import static org.junit.Assert.*;

import org.junit.Test;

import belskii.artem.bulletinboard.dao.category.Category;

public class AdvertisementDaoHiberImplTest {
	private Category category  = new Category();
	@Test
	public void testAddAdvertisement() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		assertTrue(advertisement.addAdvertisement("pink elephant", "Buy new pink elephant, with low price!", "Покупка")>0);
		
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFiltered() {
		fail("Not yet implemented");
	}

}
