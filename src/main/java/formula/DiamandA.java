package formula;

import kripke.KripkeStructure;
import kripke.Relation;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Matthias on 16.08.2017.
 */
public class DiamandA implements Formula {
    private String agent;
    private Formula formula;

    public DiamandA(String agent, Formula formula) {
        this.agent = agent;
        this.formula = formula;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        Boolean result = false;
        Set<Relation> relations = kripkeStructure.getKripkeRelations().stream()
                .filter(relationsForAgent -> relationsForAgent.getAgent().equals(agent))
                .flatMap(relationsForAgent -> relationsForAgent.getRelations().stream()).collect(Collectors.toSet());

        for (Relation relation : relations) {
            if (relation.getFirst().equals(nameWorld)) {
                result = result || formula.semantic(kripkeStructure, relation.getSecond());
            }
        }
        return result;
    }
}
