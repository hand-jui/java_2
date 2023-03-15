
package ch03;

import java.util.LinkedHashMap;
import java.util.Map;

public class Geo {

    public String lat;
    public String lng;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
