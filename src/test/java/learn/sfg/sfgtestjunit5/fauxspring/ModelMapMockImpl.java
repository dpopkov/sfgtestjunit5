package learn.sfg.sfgtestjunit5.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapMockImpl implements Model {
    private final Map<String, Object> attributes = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        attributes.put(key, o);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public void addAttribute(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
