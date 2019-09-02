package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.map.MapArray;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;

public class FormSteps {
	public static Safe<String> lastForm = new Safe<>(() -> null);
	@When("^(?:I |)fill form \"([^\"]*)\" with data:$")
	public void fillForm(String name, DataTable data) {
		Form fm = getForm(name);
		fm.fill(getMapFromTable(data));
	}

	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form \"([^\"]*)\" with data:$")
	public void submitDataForm(String name, DataTable data) {
		Form fm = getForm(name);
		fm.submit(getMapFromTable(data));
	}
	@When("^(?:I |)((?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search)) form$")
	public void submitForm(String buttonName) {
		Form fm = getForm(lastForm.get());
		fm.pressButton(buttonName);
	}
	@Then("^the form \"([^\"]*)\" data equals to:$")
    public void dataEquals(String name, DataTable data) {
		Form fm = getForm(name);
        fm.check(getMapFromTable(data));
    }

	private MapArray<String, String> getMapFromTable(DataTable table) {
		return new MapArray<>(table.getGherkinRows(),
				r -> r.getCells().get(0), r -> r.getCells().get(1));
	}
	private static Form getForm(String name) {
		Form form = getUI(name, Form.class);
		lastForm.set(name);
		return form;
	}
}