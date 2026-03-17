public class Criterion {
    private String name;
    private String isoCode;
    private double weight;
    private String type;
    private double minThreshold;
    private double maxThreshold;
    private String unit;
    private double measuredValue;

    public Criterion(String name, String isoCode, double weight, String type, double minThreshold, double maxThreshold, String unit) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.type = type;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.unit = unit;
        this.measuredValue = 0.0;
    }

    public double calculateScore() {
        if (type.equalsIgnoreCase("higher")) {
            if (measuredValue >= maxThreshold) return 5.0;
            if (measuredValue <= minThreshold) return 1.0;
            return 1.0 + 4.0 * (measuredValue - minThreshold) / (maxThreshold - minThreshold);
        } else {
            if (measuredValue <= minThreshold) return 5.0;
            if (measuredValue >= maxThreshold) return 1.0;
            return 5.0 - 4.0 * (measuredValue - minThreshold) / (maxThreshold - minThreshold);
        }
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public double getWeight() {
        return weight;
    }

    public String getUnit() {
        return unit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }










}