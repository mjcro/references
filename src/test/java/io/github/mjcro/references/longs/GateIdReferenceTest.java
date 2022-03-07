package io.github.mjcro.references.longs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GateIdReferenceTest {
    @Test
    public void testPredicate() {
        Predicate<GateIdReference> predicate = GateIdReference.predicate(8);

        Assert.assertTrue(predicate.test(new Impl(8)));
        Assert.assertFalse(predicate.test(new Impl(7)));
        Assert.assertFalse(predicate.test(new Impl(-3)));
    }

    @Test
    public void testFilter() {
        ArrayList<Impl> source = new ArrayList<>();
        source.add(new Impl(1));
        source.add(new Impl(2));
        source.add(new Impl(3));

        List<Impl> filtered = GateIdReference.filter(source, 2);
        Assert.assertEquals(filtered.size(), 1);
        Assert.assertEquals(filtered.get(0).getGateId(), 2);
    }

    private static class Impl implements GateIdReference {
        private final long gateId;

        private Impl(long gateId) {
            this.gateId = gateId;
        }

        @Override
        public long getGateId() {
            return gateId;
        }
    }
}