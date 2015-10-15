package belskii.artem.bulletinboard.dao.advert;

import antlr.collections.List;

public interface AdvertisementDao {
	public void addAdvertisement(String title, String body, Long categoryId);
	public List getAll();
	public void delete(Long id);
	public List getFiltered(String usermail);
}
