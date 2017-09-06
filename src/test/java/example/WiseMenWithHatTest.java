package example;

import kripke.KripkeStructure;
import kripke.RelationsForAgent;
import kripke.World;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static kripke.KripkeHelper.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Matthias on 06.09.2017.
 */
public class WiseMenWithHatTest {

    @Test
    @Ignore
    public void solveWithModelFirstAnn() {
        WiseMenWithHat wiseMenWithHatModel = new WiseMenWithHat();

        KripkeStructure knowledgeBase = wiseMenWithHatModel.getKnowledgeBase();

        KripkeStructure expectedKnowledgebase = getExpectedKnowledgebase();
        expectedKnowledgebase.updateRelations(addReflexiveEdges(expectedKnowledgebase.getWorlds()
                , expectedKnowledgebase.getKripkeRelations()));
        expectedKnowledgebase.updateRelations(addSymmetricEdges(expectedKnowledgebase.getKripkeRelations()));
        //TODO: addReflexiveEdges and addSymmetricEdges adding to much relationships, fixme
        assertEquals(expectedKnowledgebase, knowledgeBase);
    }

    private KripkeStructure getExpectedKnowledgebase() {
        Set<World> expectedWorlds = new HashSet<>();
        Set<RelationsForAgent> expectedRelations = new HashSet<>();
        expectedWorlds.add(new World("RRW", zip(asList("1:R", "2:R", "3:W"), asList(true, true, true))));
        expectedWorlds.add(new World("RRR", zip(asList("1:R", "2:R", "3:R"), asList(true, true, true))));
        expectedWorlds.add(new World("WRR", zip(asList("1:W", "2:R", "3:R"), asList(true, true, true))));

        expectedWorlds.add(new World("WWR", zip(asList("1:W", "2:W", "3:R"), asList(true, true, true))));
        expectedWorlds.add(new World("RWR", zip(asList("1:R", "2:W", "3:R"), asList(true, true, true))));
        expectedWorlds.add(new World("WRW", zip(asList("1:W", "2:R", "3:W"), asList(true, true, true))));

        expectedRelations.add(new RelationsForAgent("1", rels("RRW", "WRW", "RWR", "WWR", "WRR", "RRR")));
        expectedRelations.add(new RelationsForAgent("2", rels("RWR", "RRR", "WRR", "WWR")));
        expectedRelations.add(new RelationsForAgent("3", rels("RRR", "RRW", "WRW", "WRR")));

        return new KripkeStructure(expectedWorlds, expectedRelations);
    }
}