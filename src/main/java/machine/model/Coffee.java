package machine.model;

import java.util.Map;

import static machine.model.Resource.*;

public enum Coffee {
    ESPRESSO(Map.of(WATER, 250, COFFEE_BEANS, 16), 4),
    LATTE(Map.of(WATER, 350, MILK, 75, COFFEE_BEANS, 20), 7),
    CAPPUCCINO(Map.of(WATER, 200, MILK, 100, COFFEE_BEANS, 12), 6);

    private final Map<Resource, Integer> recipe;
    private final int price;

    Coffee(Map<Resource, Integer> recipe, int price) {
        this.recipe = recipe;
        this.price = price;
    }

    public Map<Resource, Integer> getRecipe() {
        return recipe;
    }

    public int getPrice() {
        return price;
    }
}
