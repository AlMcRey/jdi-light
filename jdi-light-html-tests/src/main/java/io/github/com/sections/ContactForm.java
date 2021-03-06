package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.github.com.entities.Contacts;

public class ContactForm extends Form<Contacts> {
	TextField name, lastName, position, passportNumber, passportSeria;

	Dropdown gender;
	IsCombobox religion;

	Checkbox passport, acceptConditions;
	public TextArea description;

	@UI("['Submit']") public Button submit;
}