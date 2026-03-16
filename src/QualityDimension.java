import java.util.ArrayList;

public class QualityDimension {

private String name;
private String isoCode;
private double weight;
private ArrayList<Criterion> criteria;


    public QualityDimension(String name, String isoCode, double weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteria = new ArrayList<>(); //restarting the list here
    }

    public void addCriterion(Criterion criterion) {
        this.criteria.add(criterion);
    }


    public double calculateDimensionScore() {
double totalWeightedScore = 0, totalWeight = 0;

    for(int i = 0; i < this.criteria.size(); i++) {
        Criterion currentCriterion = this.criteria.get(i);
        double score = currentCriterion.calculateScore();
        totalWeightedScore += (score * currentCriterion.getWeight());
        totalWeight += currentCriterion.getWeight();


    }

return totalWeightedScore/totalWeight;



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

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }
}
