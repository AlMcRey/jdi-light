package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.DropdownMenu;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class DropdownMenuAssert<A extends DropdownMenuAssert, E extends DropdownMenu> {//extends BootstrapDropdownAssert<A, E> {
    @JDIAction("Assert that '{name}' items values {0}")
    public A itemValues(Matcher<Iterable<String>> condition) {
        //jdiAssert(element.itemValues(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' items values are {0}")
    public A itemValues(String... values) {
        //jdiAssert(element.itemValues(), Matchers.is(Arrays.asList(values)));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' items values are {0}")
    public A hasItems(String... values) {
        itemValues(Matchers.hasItems(values));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' item is active")
    public A active(int itemIndex) {
        //jdiAssert(element.list().get(itemIndex).core().getAttribute("class"), Matchers.is("dropdown-item active"));
        return (A) this;
    }
}
