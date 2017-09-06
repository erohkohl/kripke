package kripke;

import java.util.Set;

/**
 * @author Matthias on 16.08.2017.
 */
public class KripkeStructure {
    private Set<World> worlds;
    private Set<RelationsForAgent> kripkeRelations;

    public KripkeStructure(Set<World> worlds, Set<RelationsForAgent> kripkeRelations) {
        this.worlds = worlds;
        this.kripkeRelations = kripkeRelations;
    }

    public Set<World> getWorlds() {
        return worlds;
    }

    public Set<RelationsForAgent> getKripkeRelations() {
        return kripkeRelations;
    }

    public Set<RelationsForAgent> updateRelations(Set<RelationsForAgent> relations) {
        relations.stream().filter(r -> !kripkeRelations.contains(r)).forEach(kripkeRelations::add);
        return kripkeRelations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KripkeStructure that = (KripkeStructure) o;

        if (worlds != null ? !worlds.equals(that.worlds) : that.worlds != null) return false;
        return kripkeRelations != null ? kripkeRelations.equals(that.kripkeRelations) : that.kripkeRelations == null;
    }

    @Override
    public int hashCode() {
        int result = worlds != null ? worlds.hashCode() : 0;
        result = 31 * result + (kripkeRelations != null ? kripkeRelations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KripkeStructure{" +
                "worlds=" + worlds +
                ", kripkeRelations=" + kripkeRelations +
                '}';
    }
}
