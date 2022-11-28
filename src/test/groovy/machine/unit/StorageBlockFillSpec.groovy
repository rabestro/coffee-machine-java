package machine.unit

import machine.model.Resource
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.See
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

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

    @PendingFeature
    def 'replenish resource for empty storage block'() {

        given: 'a storage block'
        def storageUnit = new StorageBlock()

        expect: 'the storage block has not resources'
        storageUnit.volume(resource) == 0

        when: 'we refill the resource'
        storageUnit.fill resource, replenishment

        then: 'the volume of this resource is equal to replenishment'
        storageUnit.volume(resource) == replenishment

        where: 'available resources and replenishment'
        resource << Resource.values()
        replenishment = 100
    }
}
