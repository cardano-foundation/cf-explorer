package constants.enums;

public enum AnalyticsType {
    ONE_DAY("ONE_DAY"),
    ONE_WEEK("ONE_WEEK"),
    TWO_WEEK("TWO_WEEK"),
    ONE_MONTH("ONE_MONTH"),
    THREE_MONTH("THREE_MONTH"),
            ;
    private String alcType;

    AnalyticsType(String alcType) {
        this.alcType = alcType;
    }

    public String getAlcType(){
        return this.alcType;
    }
}
