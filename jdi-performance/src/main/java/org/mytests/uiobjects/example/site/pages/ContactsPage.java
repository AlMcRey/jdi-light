package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;

@Url("/contacts.html") @Title("Contact Form")
public class ContactsPage extends WebPage {
	public TextField name;
	public TextField lastName;
	public TextField position;
	public TextField passportNumber;
	public TextField passportSerial;

	DropdownSelect gender;
	IsCombobox religion;
	MultiDropdown weather;

	public Checkbox passport;
	public Checkbox acceptConditions;
	TextArea description;

	@UI("['Submit']") public Button submit;
}