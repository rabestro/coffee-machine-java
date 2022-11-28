package machine.unit;

public interface ControlUnit {
    boolean isOperate();

    void powerOn();

    void process(String request);
}
