package formula;

import kripke.KripkeStructure;

/**
 * @author Matthias on 16.08.2017.
 */
public interface Formula {
    boolean semantic(KripkeStructure kripkeStructure, String nameWorld);
}
