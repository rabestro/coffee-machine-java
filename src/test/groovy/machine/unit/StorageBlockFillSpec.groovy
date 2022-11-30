package machine.unit

import machine.model.Resource
import spock.lang.*

import java.util.concurrent.ThreadLocalRandom

@Title('The technician replenishes the resources in the storage unit')
@Narrative('''
As a technician
I want to replenish the resources in the storage unit
So that the coffee machine can prepare the coffee drinks
''')
@Issue('4')
@See('https://github.com/rabestro/coffee-machine/wiki/Resources-replenishment')
@Subject(StorageBlock)
@Tag('Sanity')
class StorageBlockFillSpec extends Specification {

    def 'replenish resource for an empty storage unit'(Resource resource) {

        given: 'an empty storage unit'
        def storageUnit = new StorageBlock()

        expect: 'the storage unit is missing a specific resource'
        storageUnit.volume(resource) == 0

        when: 'we replenish the specific resource'
        storageUnit.fill resource, replenishment

        then: 'the volume of the resource is equal to replenishment'
        storageUnit.volume(resource) == replenishment

        where: 'all available resources and their replenishment'
        resource << Resource.values()
        replenishment = 'some resource volume'()
    }

    def 'replenish resource for a filled storage unit'(Resource resource) {

        given: 'storage unit with a certain amount of all resources'
        def storageUnit = 'filled storage unit'()

        when: 'we replenish a specific resource in storage unit'
        storageUnit.fill resource, replenishment

        then: 'the volume of the resource increased by replenishment'
        storageUnit.volume(resource) == old(storageUnit.volume(resource)) + replenishment

        where: 'all available resources and their replenishment'
        resource << Resource.values()
        replenishment = 'some resource volume'()
    }

    def 'filled storage unit'() {
        def storage = new StorageBlock()
        Resource.values().every {
            storage.fill it, 'some resource volume'()
        }
        return storage
    }

    def 'some resource volume'() {
        ThreadLocalRandom.current().nextInt(50) * 10
    }
}

