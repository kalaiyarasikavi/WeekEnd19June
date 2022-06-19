package pages;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage extends BaseClass {
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement btnCreate;
	
	@FindBy(name="firstname")
	private WebElement txtFirstname;
	
	@FindBy(name="lastname")
	private WebElement txtLastname;
	
	@FindBy(name="websubmit")
	private WebElement btnSignup;

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtLastname() {
		return txtLastname;
	}

	public WebElement getBtnSignup() {
		return btnSignup;
	}
}
