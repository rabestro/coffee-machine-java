package machine.unit

import machine.model.ControlState
import spock.lang.Issue
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Issue('9')
@Subject(ControlBlock)
@Title('The control block with internal state')
class ControlUnitStateSpec extends Specification {

    def 'the created control block is in off state'() {
        when:
        def controlBlock = new ControlBlock(_ as DisplayUnit, _ as StorageUnit)

        then:
        controlBlock.state == ControlState.SHUTDOWN
    }
}
