package api;

import java.util.Map;

public class Device {
    private String id;
    private String name;
    private String createdAt;
    private Map<String, Object> data;

    public Device() {}

    public Device(String name, Map<String, Object> data) {
        this.name = name;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
