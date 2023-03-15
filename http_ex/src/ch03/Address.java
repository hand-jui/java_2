
package ch03;

import java.util.LinkedHashMap;
import java.util.Map;

public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
