package formula;

import kripke.KripkeStructure;

/**
 * @author Matthias on 16.08.2017.
 */
public class Not implements Formula {

    private Formula formula;

    public Not(Formula formula) {
        this.formula = formula;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        return !formula.semantic(kripkeStructure, nameWorld);
    }
}
