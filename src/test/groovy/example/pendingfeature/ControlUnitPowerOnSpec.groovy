package example.pendingfeature

import machine.model.ControlState
import machine.unit.ControlBlock
import machine.unit.DisplayUnit
import machine.unit.StorageUnit
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.See
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Tag
import spock.lang.Title

@Title('The technician powers on the control unit')
@Narrative('''
As a technician
I want to turn on the coffee machine control unit
so that the coffee machine starts serving coffee lovers
''')
@Issue('31')
@See('https://github.com/rabestro/coffee-machine/wiki/Coffee-Machine-powerOn')
@Tag('Sanity')
class ControlUnitPowerOnSpec extends Specification {
    def storageStub = _ as StorageUnit
    def displayMock = Mock DisplayUnit

    @PendingFeature
    def 'should power on the control unit'() {

        given: 'a coffee machine control unit'
        @Subject
        def controlUnit = new ControlBlock(displayMock, storageStub)

        expect: 'control unit is switched off and does not work'
        !controlUnit.isOperate()

        when: 'we turn on the control unit'
        controlUnit.powerOn()

        then: 'the control unit goes into working condition'
        controlUnit.isOperate()

        then: 'the main menu prompt is sent to the display'
        1 * displayMock.accept(ControlState.MainMenu.prompt)
    }
}
