package formula;

import kripke.KripkeStructure;
import kripke.World;

/**
 * @author Matthias on 16.08.2017.
 */
public class Atom implements Formula {

    private String name;

    public Atom(String name) {
        this.name = name;
    }

    public boolean semantic(KripkeStructure kripkeStructure, String nameWorld) {
        for (World world : kripkeStructure.getWorlds()) {
            if (world.getName().equals(nameWorld)) {
                return world.getAssignement().get(name);
            }
        }
        return false;
    }
}
