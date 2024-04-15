import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Party vvd = new Party("VVD");
        Party d66 = new Party("D66");
        Party gl = new Party("GroenLinks");
        Party fvd = new Party("Forum voor Democratie");

        vvd.getExcluded().add(fvd);
        d66.getExcluded().add(fvd);
        gl.getExcluded().add(fvd);

        Map<Party, Integer> electionResult = new HashMap<>();
        electionResult.put(vvd, 50);
        electionResult.put(d66, 30);
        electionResult.put(gl, 20);
        electionResult.put(fvd, 20);

        CoalitionScout scout = new CoalitionScout("Tjeek Willink");
        scout.finalizeElection(electionResult);
        scout.leakDocuments();
    }
}
