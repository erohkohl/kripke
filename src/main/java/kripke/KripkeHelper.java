package kripke;

import java.util.*;

/**
 * @author Matthias on 06.09.2017.
 */
public class KripkeHelper {
    public static Set<Relation> rels(String... relnames) {
        Set<Relation> relations = new HashSet<>();
        String first = "";
        String second = "";
        for (int i = 0; i < relnames.length; i++) {
            if (i % 2 == 0) {
                first = relnames[i];
            } else {
                second = relnames[i];
                relations.add(new Relation(first, second));
            }
        }
        return relations;
    }

    public static <A, B> Map<A, B> zip(List<A> a, List<B> b) {
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("sizes arent equal");
        }
        Map<A, B> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            map.put(a.get(i), b.get(i));
        }
        return map;
    }


    public static Set<RelationsForAgent> addSymmetricEdges(Set<RelationsForAgent> allRelations) {
        //TODO: first concept, fixme
        Set<RelationsForAgent> result = new HashSet<>();
        for (RelationsForAgent relations : allRelations) {
            String agent = relations.getAgent();
            Set<Relation> newRelationsForAgent = new HashSet<>();
            for (Relation relationsForAgent : relations.getRelations()) {
                String x = relationsForAgent.getFirst();
                String y = relationsForAgent.getSecond();
                newRelationsForAgent.add(new Relation(x, y));
                newRelationsForAgent.add(new Relation(y, x));
            }
            result.add(new RelationsForAgent(agent, newRelationsForAgent));
        }
        return result;
    }

    public static Set<RelationsForAgent> addReflexiveEdges(Set<World> worlds, Set<RelationsForAgent> allRelations) {
        //TODO: first concept, fixme
        Set<RelationsForAgent> result = new HashSet<>();
        for (World world : worlds) {
            for (RelationsForAgent relations : allRelations) {
                String agent = relations.getAgent();
                Set<Relation> newRelationsForAgent = new HashSet<>();
                for (Relation relationsForAgent : relations.getRelations()) {
                    String x = relationsForAgent.getFirst();
                    String y = relationsForAgent.getSecond();
                    newRelationsForAgent.add(new Relation(x, y));
                    newRelationsForAgent.add(new Relation(world.getName(), world.getName()));
                }
                result.add(new RelationsForAgent(agent, newRelationsForAgent));
            }
        }
        return result;
    }
}
