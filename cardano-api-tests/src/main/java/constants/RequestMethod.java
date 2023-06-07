package constants;

public enum RequestMethod {

    GET("GET"), PUT("PUT"), POST("POST"), DELETE("DELETE"), UNKNOWN("UNKNOWN");

    private final String value;

    RequestMethod(final String value) {
        this.value = value;
    }

    public static RequestMethod fromValue(final String value) {
        if (value != null) {
            for (final RequestMethod method : RequestMethod.values()) {
                if (method.value.equals(value)) {
                    return method;
                }
            }
        }

        // you may return a default value
        return RequestMethod.getDefault();
        // or throw an exception
        // throw new IllegalArgumentException("Invalid color: " + value);
    }

    public String toValue() {
        return this.value;
    }

    public static RequestMethod getDefault() {
        return UNKNOWN;
    }
}
