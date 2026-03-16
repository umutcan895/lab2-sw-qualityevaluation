import java.util.ArrayList;

public class SWSystem {

private String systemName;
private ArrayList<QualityDimension> dimensions;


public SWSystem(String systemName){

this.systemName=systemName;
this.dimensions=new ArrayList<>();
}

public void addDimension(QualityDimension dimension){
    this.dimensions.add(dimension);
}

    public double calculateTotalScore() {
        if (this.dimensions.isEmpty()) {
            return 0.0;
        }

        double totalWeightedScore = 0;
        double totalWeight = 0;

        for (int i = 0; i < this.dimensions.size(); i++) {
            QualityDimension currentDim = this.dimensions.get(i);

            double dimensionScore = currentDim.calculateDimensionScore();

            totalWeightedScore += (dimensionScore * currentDim.getWeight());

            totalWeight += currentDim.getWeight();
        }

        return totalWeightedScore / totalWeight;
    }



    public void printReport() {
        System.out.println("==========================================");
        System.out.println("SOFTWARE QUALITY REPORT: " + this.systemName);
        System.out.println("==========================================");

        double overallScore = calculateTotalScore();
        System.out.printf("OVERALL SYSTEM QUALITY SCORE: %.2f / 5.00\n", overallScore);
        System.out.println("------------------------------------------");

        for (int i = 0; i < dimensions.size(); i++) {
            QualityDimension currentDim = dimensions.get(i);

            System.out.printf("\nDIMENSION: %s (%s)\n",
                    currentDim.getName(), currentDim.getIsoCode());
            System.out.printf("Dimension Score: %.2f\n", currentDim.calculateDimensionScore());
            System.out.println("   - - - - - - - - - - - - - - - - - -");

            ArrayList<Criterion> criteriaList = currentDim.getCriteria();

            for (int j = 0; j < criteriaList.size(); j++) {
                Criterion c = criteriaList.get(j);
                System.out.printf("   > Metric: %-20s | Measured: %-5.1f | Score: %.1f\n",
                        c.getName(), c.getMeasuredValue(), c.calculateScore());
            }
        }
        System.out.println("\n==========================================");
    }









}
