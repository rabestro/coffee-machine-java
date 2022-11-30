package example.helper

import machine.model.Resource
import machine.unit.StorageBlock
import spock.lang.Specification

import java.util.concurrent.ThreadLocalRandom

class StorageUnitFillSpec extends Specification {

    def 'replenish resource for a storage unit'(Resource resource) {

        given:
        def storageUnit = 'filled storage unit'()

        when:
        storageUnit.fill resource, replenishment

        then:
        storageUnit.volume(resource) == old(storageUnit.volume(resource)) + replenishment

        where:
        resource << Resource.values()
        replenishment = 'random resource volume'()
    }

    def 'filled storage unit'() {
        def storage = new StorageBlock()
        Resource.values().every {
            storage.containers[it.ordinal()] = 'random resource volume'()
        }
        return storage
    }

    def 'random resource volume'() {
        ThreadLocalRandom.current().nextInt(5000)
    }
}
