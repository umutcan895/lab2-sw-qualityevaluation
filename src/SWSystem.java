import java.util.ArrayList;

public class SWSystem {
    private String systemName;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String systemName, String category, String version) {
        this.systemName = systemName;
        this.category = category;
        this.version = version;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(QualityDimension dimension) {
        this.dimensions.add(dimension);
    }

    public void setMeasuredValue(String isoCode, double value) {
        for (QualityDimension dim : dimensions) {
            for (Criterion c : dim.getCriteria()) {
                if (c.getIsoCode().equals(isoCode)) {
                    c.setMeasuredValue(value);
                    return;
                }
            }
        }
    }

    public double calculateTotalScore() {
        if (this.dimensions.isEmpty()) return 0.0;
        double totalWeightedScore = 0;
        double totalWeight = 0;
        for (QualityDimension dim : dimensions) {
            totalWeightedScore += (dim.calculateDimensionScore() * dim.getWeight());
            totalWeight += dim.getWeight();
        }
        return totalWeightedScore / totalWeight;
    }

    public String getQualityLabel(double score) {
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    public QualityDimension findWeakestDimension() {
        if (dimensions.isEmpty()) return null;
        QualityDimension weakest = dimensions.get(0);
        for (QualityDimension dim : dimensions) {
            if (dim.calculateDimensionScore() < weakest.calculateDimensionScore()) {
                weakest = dim;
            }
        }
        return weakest;
    }

    public void printReport() {
        System.out.println("==================================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + this.systemName + " v" + this.version + " (" + this.category + ")");
        System.out.println("==================================================");

        for (QualityDimension dim : dimensions) {
            double dScore = dim.calculateDimensionScore();
            System.out.printf("\n--- %s [%s] (Weight: %.0f) ---\n",
                    dim.getName(), dim.getIsoCode(), dim.getWeight());

            for (Criterion c : dim.getCriteria()) {
                System.out.printf("  * %s: %.1f%s -> Score: %.1f\n",
                        c.getName(), c.getMeasuredValue(), c.getUnit(), c.calculateScore());
            }
            System.out.printf(">> Dimension Score: %.1f/5.0 [%s]\n",
                    dScore, getQualityLabel(dScore));
        }

        double overall = calculateTotalScore();
        System.out.println("\n--------------------------------------------------");
        System.out.printf("OVERALL QUALITY SCORE: %.1f/5.0 [%s]\n", overall, getQualityLabel(overall));
        System.out.println("--------------------------------------------------");

        System.out.println("\nGAP ANALYSIS (ISO/IEC 25010)");
        QualityDimension weakest = findWeakestDimension();
        if (weakest != null) {
            double wScore = weakest.calculateDimensionScore();
            double gap = 5.0 - wScore;
            System.out.println("Weakest Characteristic: " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
            System.out.printf("Score: %.1f/5.0 | Gap: %.1f\n", wScore, gap);
            System.out.println("Level: " + getQualityLabel(wScore));
            System.out.println(">> This characteristic requires the most improvement.");
        }
    }










}