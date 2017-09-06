package formula;

import kripke.KripkeStructure;
import kripke.Relation;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Matthias on 16.08.2017.
 */
public class Box implements Formula {

    private Formula formula;

    public Box(Formula formula) {
        this.formula = formula;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        Boolean result = true;
        Set<Relation> relations = kripkeStructure.getKripkeRelations().stream()
                .flatMap(relationsForAgent -> relationsForAgent.getRelations().stream()).collect(Collectors.toSet());

        for (Relation relation : relations) {
            if (relation.getFirst().equals(nameWorld)) {
                result = result && formula.semantic(kripkeStructure, relation.getSecond());
            }
        }
        return result;
    }
}
