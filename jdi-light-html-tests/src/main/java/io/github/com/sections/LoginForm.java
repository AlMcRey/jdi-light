package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.User;

import static io.github.com.pages.Header.*;

public class LoginForm extends Form<User> {
	@UI("#name") TextField name;
	TextField password;
	Button loginButton;

	public void shouldBeOpened() {
		if (isHidden())
			userIcon.click();
	}
	@Override
	public boolean isDisplayed() {
		return name.isDisplayed();
	}
}