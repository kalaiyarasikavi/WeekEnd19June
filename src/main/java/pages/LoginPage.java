package pages;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(id = "email")
	private WebElement Txtusername;
	@FindAll({ @FindBy(id = "pass"), @FindBy(xpath = "//input[@name='pass']") })
	private WebElement Txtpass;
	@FindBy(name = "login")
	private WebElement btnlogin;
	public WebElement getTxtusername() {
		return Txtusername;
	}
	public WebElement getTxtpass() {
		return Txtpass;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	public void login(String name,String pass) {

		sendkeys(getTxtusername(),name);

		sendkeys(getTxtpass(),pass);

		btnclick(getBtnlogin());

	}

}
