package ObjectRepository;

import org.openqa.selenium.By;

public interface IElementRepo {

	By tab_HomePage_Movies = By.id("href_movies");
	String Txt_HomePage_MovieName = "//h5/following-sibling::ul/child::li/a[text()= 'Friendship']/parent::li/a";
}
