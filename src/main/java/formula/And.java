package formula;

import kripke.KripkeStructure;

/**
 * @author Matthias on 16.08.2017.
 */
public class And implements Formula {

    private final Formula left;
    private final Formula right;

    public And(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        return left.semantic(kripkeStructure, nameWorld) && right.semantic(kripkeStructure, nameWorld);
    }
}
