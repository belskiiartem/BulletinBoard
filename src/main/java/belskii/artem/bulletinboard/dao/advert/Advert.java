package belskii.artem.bulletinboard.dao.advert;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Advert {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String AuthorFirstName;
	private String authorLastname;
	private Date publishDate=new Date();
	@Size(min = 10, max = 30)
	private String advertTitle;
	@Size(min = 20, max = 400)
	private String advertText;
	private Long categoryId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthorFirstName() {
		return AuthorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		AuthorFirstName = authorFirstName;
	}
	public String getAuthorLastname() {
		return authorLastname;
	}
	public void setAuthorLastname(String authorLastname) {
		this.authorLastname = authorLastname;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getAdvertTitle() {
		return advertTitle;
	}
	public void setAdvertTitle(String advertTitle) {
		this.advertTitle = advertTitle;
	}
	public String getAdvertText() {
		return advertText;
	}
	public void setAdvertText(String advertText) {
		this.advertText = advertText;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
