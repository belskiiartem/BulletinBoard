package belskii.artem.bulletinboard.dao.category;

import java.util.ArrayList;

public interface CategoryDao {
	public ArrayList<Category> getAllCategories();
	public Long AddCategories(String title);
	public String removeCategories(Long id);
}
