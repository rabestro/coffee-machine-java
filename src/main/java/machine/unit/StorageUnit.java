package machine.unit;

import machine.model.Resource;

public interface StorageUnit {
    int volume(Resource resource);

    void fill(Resource resource, int replenishment);
}
