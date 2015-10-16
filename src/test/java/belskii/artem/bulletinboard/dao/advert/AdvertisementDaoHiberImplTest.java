package belskii.artem.bulletinboard.dao.advert;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.bind.annotation.ExceptionHandler;

import belskii.artem.bulletinboard.dao.category.Category;

public class AdvertisementDaoHiberImplTest {
	private Category category  = new Category();
	@Test
	public void testAddAdvertisement() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		assertTrue(advertisement.addAdvertisement(Long.valueOf(1), "pink elephant", "Buy new pink elephant, with low price!", "one")>0);
	}
	
	@Test(expected=java.lang.NoSuchMethodError.class)
	public void testaddTooSmoolValue() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		advertisement.addAdvertisement(Long.valueOf(1), "smool", "too smool!", "one");
	}

	@Test
	public void testGetAll() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		assertTrue(advertisement.getAll().size()>0);
	}

	@Test
	public void testDelete() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		assertTrue(advertisement.delete(23L));	
	}

	@Test
	public void testGetFiltered() {
		AdvertisementDaoHiberImpl advertisement = new AdvertisementDaoHiberImpl ();
		assertTrue(advertisement.getFiltered("belskiiartem@gmail.com").size()>0);
	}

}
