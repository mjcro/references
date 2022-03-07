package io.github.mjcro.references.longs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class IdReferenceTest {
    @Test
    public void testSorting() {
        ArrayList<Ref> refs = new ArrayList<>();
        refs.add(new Ref(82));
        refs.add(new Ref(11));
        refs.add(new Ref(132));
        refs.add(new Ref(-8));

        refs.sort(IdReference.SORT_ASC);
        Assert.assertEquals(refs.get(0).getId(), -8);
        Assert.assertEquals(refs.get(1).getId(), 11);
        Assert.assertEquals(refs.get(2).getId(), 82);
        Assert.assertEquals(refs.get(3).getId(), 132);

        refs.sort(IdReference.SORT_DESC);
        Assert.assertEquals(refs.get(0).getId(), 132);
        Assert.assertEquals(refs.get(1).getId(), 82);
        Assert.assertEquals(refs.get(2).getId(), 11);
        Assert.assertEquals(refs.get(3).getId(), -8);
    }

    private static class Ref implements IdReference {
        private final long id;

        private Ref(long id) {
            this.id = id;
        }

        @Override
        public long getId() {
            return id;
        }
    }
}