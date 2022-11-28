package example.simple

import machine.model.Coffee
import spock.lang.Specification

class CoffeePriceSpec extends Specification {

    def 'should return the fair price for the coffee'() {
        expect:
        Coffee.ESPRESSO.price == 4
    }
}
