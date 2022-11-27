package machine.model;

import java.util.function.IntFunction;

public enum Resource implements IntFunction<String> {
    WATER("water", "%d ml of water"),
    MILK("milk", "%d ml of milk"),
    COFFEE_BEANS("coffee beans", "%d g of coffee beans"),
    DISPOSABLE_CUPS("disposable cups", "%d disposable cups"),
    CASH("money", "$%d of money");

    private final String resourceName;
    private final String template;

    Resource(String resourceName, String template) {
        this.resourceName = resourceName;
        this.template = template;
    }

    public String getResourceName() {
        return resourceName;
    }

    @Override
    public String apply(int value) {
        return template.formatted(value);
    }
}
