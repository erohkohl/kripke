package example;

import kripke.KripkeStructure;
import kripke.RelationsForAgent;
import kripke.World;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static kripke.KripkeHelper.rels;
import static kripke.KripkeHelper.zip;

/**
 * @author Matthias on 16.08.2017.
 */
public class WiseMenWithHat {

    Set<World> worlds = new HashSet<>();

    Set<RelationsForAgent> relationsForAgents = new HashSet<>();

    public KripkeStructure getKnowledgeBase() {
        worlds.add(new World("RWW", zip(asList("1:R", "2:W", "3:W"), asList(true, true, true))));
        worlds.add(new World("RRW", zip(asList("1:R", "2:R", "3:W"), asList(true, true, true))));
        worlds.add(new World("RRR", zip(asList("1:R", "2:R", "3:R"), asList(true, true, true))));
        worlds.add(new World("WRR", zip(asList("1:W", "2:R", "3:R"), asList(true, true, true))));
        worlds.add(new World("WWR", zip(asList("1:W", "2:W", "3:R"), asList(true, true, true))));
        worlds.add(new World("RWR", zip(asList("1:R", "2:W", "3:R"), asList(true, true, true))));
        worlds.add(new World("WRW", zip(asList("1:W", "2:R", "3:W"), asList(true, true, true))));
        worlds.add(new World("WWW", zip(asList("1:W", "2:W", "3:W"), asList(true, true, true))));

        relationsForAgents.add(new RelationsForAgent("1", rels("RWW", "WWW", "RRW", "WRW", "RWR", "WWR", "WRR", "RRR")));
        relationsForAgents.add(new RelationsForAgent("2", rels("RWR", "RRR", "RWW", "RRW", "WRR", "WWR", "WWW", "WRW")));
        relationsForAgents.add(new RelationsForAgent("3", rels("WWR", "WWW", "RRR", "RRW", "RWW", "RWR", "WRW", "WRR")));
        return new KripkeStructure(worlds, relationsForAgents);
    }
}
