package kripke;

import java.util.Set;

/**
 * @author Matthias on 16.08.2017.
 */
public class RelationsForAgent {

    private String agent;
    private Set<Relation> relations;

    public RelationsForAgent(String agent, Set<Relation> relations) {
        this.agent = agent;
        this.relations = relations;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public String getAgent() {
        return agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationsForAgent that = (RelationsForAgent) o;

        if (agent != null ? !agent.equals(that.agent) : that.agent != null) return false;
        return relations != null ? relations.equals(that.relations) : that.relations == null;
    }

    @Override
    public int hashCode() {
        int result = agent != null ? agent.hashCode() : 0;
        result = 31 * result + (relations != null ? relations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RelationsForAgent{" +
                "agent='" + agent + '\'' +
                ", relations=" + relations +
                '}';
    }
}
