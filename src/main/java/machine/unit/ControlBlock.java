package machine.unit;

import machine.model.ControlState;

public class ControlBlock implements ControlUnit {
    private final DisplayUnit displayUnit;
    private final StorageUnit storageUnit;

    private ControlState state = ControlState.SHUTDOWN;

    public ControlBlock(DisplayUnit displayUnit, StorageUnit storageUnit) {
        this.displayUnit = displayUnit;
        this.storageUnit = storageUnit;
    }

    @Override
    public boolean isOperate() {
        return false;
    }

    @Override
    public void powerOn() {

    }

    @Override
    public void process(String request) {

    }
}

