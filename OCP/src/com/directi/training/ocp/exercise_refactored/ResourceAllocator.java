package com.directi.training.ocp.exercise_refactored;

import java.util.HashMap;
import java.util.Map;

public class ResourceAllocator {
    private Map<Class<? extends Resource>, Resource> resources = new HashMap<>();

    public ResourceAllocator() {
        resources.put(TimeSlotResource.class, new TimeSlotResource());
        resources.put(SpaceSlotResource.class, new SpaceSlotResource());
    }

    public int allocate(Class<? extends Resource> resourceType) {
        Resource resource = resources.get(resourceType);
        if (resource != null) {
            return resource.allocate();
        } else {
            System.out.println("ERROR: Attempted to allocate invalid resource");
            return -1;
        }
    }

    public void free(Class<? extends Resource> resourceType, int resourceId) {
        Resource resource = resources.get(resourceType);
        if (resource != null) {
            resource.free(resourceId);
        } else {
            System.out.println("ERROR: Attempted to free invalid resource");
        }
    }
}

