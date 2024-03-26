import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoalitionScout {
    private String name;
    private List<String> possibilities;
    private Map<Party, Integer> electionResult;

    public CoalitionScout(String name) {
        super();
        this.name = name;
    }
    
    private void addPossibility(Party lead, List<Party> others) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(lead.getName()); // "VVD"
        sb.append(" wil coalitieverkenning met: "); // VVD wil coalitieverkenning met: 

        for (int i = 0; i < others.size(); i++) {
            Party otherParty = others.get(i);
            sb.append(otherParty.getName());
        }

        possibilities.add(sb.toString()); 
    }

    private List<Party> findPartners(Party lead, List<Party> others) {

        // bereken uit others of er een meerderheid is
        List<Party> excludedParties = lead.getExcluded();

        ArrayList<Party> partners = new ArrayList<>();
        Integer seats = 0;
        for (int i = 0; i < others.size(); i++) {
            Party otherParty = others.get(i);
            Integer otherPartySeats = electionResult.get(otherParty);
            
             // let op uitgesloten partijen
           if(!excludedParties.contains(otherParty)) {
            seats += otherPartySeats;
            partners.add(otherParty);
           }
        }
       
        if(seats > 75) {
              // meerderheid => partners teruggeven
            return partners;
        } else {
            // geen meerderheid => null teruggeven
            return null;
        }
        

    }
}
