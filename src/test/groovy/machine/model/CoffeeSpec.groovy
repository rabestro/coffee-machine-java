package machine.model

import spock.lang.Specification

class CoffeeSpec extends Specification {
    def "should return the fair price for the coffee"() {
        expect:
        Coffee.ESPRESSO.price == 4
    }
}
