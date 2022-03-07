package io.github.mjcro.references.longs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ScopeIdReferenceTest {
    @Test
    public void testPredicate() {
        Predicate<ScopeIdReference> predicate = ScopeIdReference.predicate(8);

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

        List<Impl> filtered = ScopeIdReference.filter(source, 2);
        Assert.assertEquals(filtered.size(), 1);
        Assert.assertEquals(filtered.get(0).getScopeId(), 2);
    }

    private static class Impl implements ScopeIdReference {
        private final long scopeId;

        private Impl(long scopeId) {
            this.scopeId = scopeId;
        }

        @Override
        public long getScopeId() {
            return scopeId;
        }
    }
}