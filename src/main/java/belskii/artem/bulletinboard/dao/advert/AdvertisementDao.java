package belskii.artem.bulletinboard.dao.advert;

import antlr.collections.List;

public interface AdvertisementDao {
	public Long addAdvertisement(String title, String body, String categoryTitle);
	public List getAll();
	public void delete(Long id);
	public List getFiltered(String usermail);
}
