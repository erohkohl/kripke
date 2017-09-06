package kripke;

import java.util.Map;

/**
 * @author Matthias on 16.08.2017.
 */
public class World {

    private String name;
    private Map<String, Boolean> assignement;

    public World(String name, Map<String, Boolean> assignement) {
        this.name = name;
        this.assignement = assignement;
    }

    public String getName() {
        return name;
    }

    public Map<String, Boolean> getAssignement() {
        return assignement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (name != null ? !name.equals(world.name) : world.name != null) return false;
        return assignement != null ? assignement.equals(world.assignement) : world.assignement == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (assignement != null ? assignement.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                ", assignement=" + assignement +
                '}';
    }
}
