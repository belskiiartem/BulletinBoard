package belskii.artem.bulletinboard.dao.advert;

import antlr.collections.List;
import belskii.artem.bulletinboard.dao.category.CategoryDao;
import belskii.artem.bulletinboard.dao.category.CategoryDaoHiberImpl;

public class AdvertisementDaoHiberImpl implements AdvertisementDao{

	public Long addAdvertisement(String title, String body, String categoryTitle) {
		CategoryDao category = new CategoryDaoHiberImpl();
		Long categoryId=category.findCategory(categoryTitle);
		return null;
	}

	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List getFiltered(String usermail) {
		// TODO Auto-generated method stub
		return null;
	}

}
