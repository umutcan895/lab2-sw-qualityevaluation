import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> allData = SWSystemData.getAllSystems();


        SWSystem shopSphere = allData.get("Web").get(0);

        shopSphere.setMeasuredValue("QC.FS.1", 94);
        shopSphere.setMeasuredValue("QC.FS.2", 91);

        shopSphere.setMeasuredValue("QC.RE.1", 99.1);
        shopSphere.setMeasuredValue("QC.RE.2", 12);

        shopSphere.setMeasuredValue("QC.PE.1", 220);
        shopSphere.setMeasuredValue("QC.PE.2", 45);

        shopSphere.setMeasuredValue("QC.MA.1", 82);
        shopSphere.setMeasuredValue("QC.MA.2", 14);

        shopSphere.printReport();
    }











}