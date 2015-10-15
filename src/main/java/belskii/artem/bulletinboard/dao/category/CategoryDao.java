package belskii.artem.bulletinboard.dao.category;

import antlr.collections.List;

public interface CategoryDao {
	public List getAllCategorues();
	public void AddCategorues(String title);
	public void removeCategories(Long id);
}
