import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {

    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        map.put("Web", webList);

        return map;
    }

    private static SWSystem createECommercePlatform() {
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", "QC.FS.1", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", "QC.FS.2", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25);
        reliability.addCriterion(new Criterion("Availability Ratio", "QC.RE.1", 50, "higher", 95, 100, "%"));
        reliability.addCriterion(new Criterion("Defect Density", "QC.RE.2", 50, "lower", 0, 20, "defect/KLOC"));
        s.addDimension(reliability);

        QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        performance.addCriterion(new Criterion("Response Time", "QC.PE.1", 50, "lower", 100, 500, "ms"));
        performance.addCriterion(new Criterion("CPU Utilisation Ratio", "QC.PE.2", 50, "lower", 0, 100, "%"));
        s.addDimension(performance);

        QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25);
        maintainability.addCriterion(new Criterion("Test Coverage Ratio", "QC.MA.1", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(new Criterion("Cyclomatic Complexity (avg)", "QC.MA.2", 50, "lower", 1, 30, "score"));
        s.addDimension(maintainability);

        return s;
    }
}