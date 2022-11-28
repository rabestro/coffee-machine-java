package machine.model;

public enum ControlState {
    MAIN_MENU("Write action (buy, fill, take, remaining, exit): "),
    BUY_COFFEE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
    FILL_WATER("Write how many ml of water you want to add:"),
    FILL_MILK("Write how many ml of milk you want to add:"),
    FILL_BEANS("Write how many grams of coffee beans you want to add:"),
    FILL_CUPS("Write how many disposable cups you want to add:"),
    SHUTDOWN("");

    private final String prompt;

    ControlState(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
