package belskii.artem.bulletinboard.dao.advert;

import java.util.ArrayList;

public interface AdvertisementDao {
	public Long addAdvertisement(Long userId, String title, String body, String categoryTitle);
	public ArrayList<Advert> getAll();
	public void delete(Long id);
	public ArrayList<Advert> getFiltered(String usermail);
}
