import java.util.ArrayList;
import java.util.List;

public class Party {

    protected ArrayList<Party> excluded = new ArrayList<>();
    private String name;

    public Party(String name) {
        this.name = name;
        this.excluded = new ArrayList<>();
    }

    public List<Party> getExcluded() {
        return excluded;
    }

    public void addExcludedParty(Party party) {

        excluded.add(party);

    }

    public String getName() {
        return name;
    }

}
