package machine.unit;

import machine.model.Resource;

public class StorageBlock implements StorageUnit {
    private final int[] containers = new int[Resource.values().length];

    @Override
    public int volume(Resource resource) {
        return containers[resource.ordinal()];
    }

    @Override
    public void fill(Resource resource, int replenishment) {
        containers[resource.ordinal()] += replenishment;
    }
}

