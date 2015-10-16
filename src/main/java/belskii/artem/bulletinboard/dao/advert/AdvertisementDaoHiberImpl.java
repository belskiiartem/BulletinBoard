package belskii.artem.bulletinboard.dao.advert;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import belskii.artem.bulletinboard.dao.category.Category;
import belskii.artem.bulletinboard.dao.category.CategoryDao;
import belskii.artem.bulletinboard.dao.category.CategoryDaoHiberImpl;
import belskii.artem.bulletinboard.dao.user.UserDao;
import belskii.artem.bulletinboard.dao.user.UserDaoImplHiber;

public class AdvertisementDaoHiberImpl implements AdvertisementDao{
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public Long addAdvertisement(Long userId, String title, String body, String categoryTitle) {
		CategoryDao category = new CategoryDaoHiberImpl();
		Long categoryId=category.findCategory(categoryTitle);
		Transaction transaction = null;
		Session session = null;
		Long id=-1L;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Advert advert = new Advert();
			advert.setCategoryId(categoryId);
			advert.setAdvertText(body);
			advert.setAdvertTitle(title);
			advert.setUserId(userId);
			
			System.out.println(advert.getAdvertText());
			id=(Long) session.save(advert);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return id;
	}

	public ArrayList<Advert> getAll() {
		Transaction transaction = null;
		Session session = null;
		ArrayList<Advert> advertList =new ArrayList<Advert>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			advertList= (ArrayList<Advert>) session.createCriteria(Advert.class).list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return advertList;

	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Advert> getFiltered(String usermail) {
		UserDao user = new UserDaoImplHiber();
		Long userId=user.findUser(usermail).getId();
		
		return null;
	}

}
