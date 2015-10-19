package belskii.artem.bulletinboard.dao.advert;

import java.util.ArrayList;

public interface AdvertisementDao {
	public Long addAdvertisement(Long userId, String title, String body, Long categoryId);
	public ArrayList<Advert> getAll();
	public boolean delete(Long id);
	public ArrayList<Advert> getFiltered(String usermail);
	public Advert getById(Long advertId);
}
