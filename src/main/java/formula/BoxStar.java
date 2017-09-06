package formula;

import kripke.KripkeStructure;
import kripke.RelationsForAgent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Matthias on 16.08.2017.
 */
public class BoxStar implements Formula {
    private Formula formula;

    public BoxStar(Formula formula) {
        this.formula = formula;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        Formula f = formula;
        List<String> agents = kripkeStructure.getKripkeRelations().stream().map(RelationsForAgent::getAgent).distinct().collect(Collectors.toList());

        for (String agent : agents) {
            f = new And(f, new BoxA(agent, formula));
        }
        return f.semantic(kripkeStructure, nameWorld);
    }
}
