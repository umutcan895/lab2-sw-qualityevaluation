public class Criterion {
    private String name;
    private double weight;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;
    private double measuredValue; // will be assinged on runtime

    public Criterion(String name, double weight, String direction, double minValue, double maxValue, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
    }

    public double calculateScore(){
            double initialScore = 0.0;
if(direction.equals("higher")){
initialScore = 1+((measuredValue-minValue)/(maxValue-minValue))*4;
}
else if(direction.equals("lower")){
initialScore =5-((measuredValue-minValue)/(maxValue-minValue))*4;
}


    if(initialScore > 5.0 ){
        initialScore = 5.0;
    }
    if(initialScore < 1.0 ){
        initialScore = 1.0;
    }

initialScore = Math.round(initialScore*2.0)/2.0;


    return initialScore;

    }























    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }







}
