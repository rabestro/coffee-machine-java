package machine.unit

import machine.model.Resource
import spock.lang.*

import java.util.concurrent.ThreadLocalRandom

@Title('The technician replenishes the resources in the storage unit')
@Narrative('''
As a technician
I want to replenish the necessary resources in the coffee machine
So that the coffee machine can prepare the necessary coffee drinks
''')
@See('https://github.com/rabestro/coffee-machine/wiki/Resources-replenishment')
@Issue('4')
@Subject(StorageBlock)
class StorageBlockFillSpec extends Specification {

    def 'replenish resource for an empty storage unit'() {

        given: 'an empty storage unit'
        def storageUnit = new StorageBlock()

        expect: 'the storage unit has not resources'
        storageUnit.volume(resource) == 0

        when: 'we refill the resource'
        storageUnit.fill resource, replenishment

        then: 'the volume of this resource is equal to replenishment'
        storageUnit.volume(resource) == replenishment

        where: 'available resources and replenishment'
        resource << Resource.values()
        replenishment = 'random resource volume'()
    }

    def 'replenish resource for a filled storage unit'(Resource resource) {

        given: 'a filled storage unit'
        def storageUnit = 'filled storage unit'()

        when: 'we refill the resource'
        storageUnit.fill resource, replenishment

        then: 'the volume of this resource is equal to replenishment'
        storageUnit.volume(resource) == old(storageUnit.volume(resource)) + replenishment

        where: 'available resources and replenishment'
        resource << Resource.values()
        replenishment = 'random resource volume'()
    }

    def 'filled storage unit'() {
        def storage = new StorageBlock()
        Resource.values().every {
            storage.fill it, 'random resource volume'()
        }
        return storage
    }

    def 'random resource volume'() {
        ThreadLocalRandom.current().nextInt(1, 5000)
    }
}
