package example.fails

import machine.model.Coffee
import spock.lang.Specification
import static machine.model.Resource.*

class CoffeeRecipeSpec extends Specification {

    def 'should have the proper recipe for the coffee'() {

        expect:
        coffee.recipe == properRecipe

        where:
        coffee = Coffee.ESPRESSO
        properRecipe = [(WATER): 250, (COFFEE_BEANS): 16]
    }
}
