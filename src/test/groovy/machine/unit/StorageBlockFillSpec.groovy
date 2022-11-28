package machine.unit

import machine.model.Resource
import spock.lang.PendingFeature
import spock.lang.Specification

class StorageBlockFillSpec extends Specification {

    @PendingFeature
    def 'replenish resource for empty storage block'() {

        given:
        def storageUnit = new StorageBlock()

        expect:
        storageUnit.volume(resource) == 0

        when:
        storageUnit.fill resource, replenishment

        then:
        storageUnit.volume(resource) == expectedVolume

        where:
        resource = Resource.WATER
        replenishment = 5000
        expectedVolume = replenishment
    }
}
