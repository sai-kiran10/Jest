package io.searchbox.core;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Dogukan Sonmez
 */


public class ExplainTest {

    @Test
    public void explain(){
        Explain explain = new Explain.Builder("query").index("twitter").type("tweet").id("1").build();
        assertEquals("POST",explain.getRestMethodName());
        assertEquals("twitter/tweet/1/_explain",explain.getURI());
        assertEquals("EXPLAIN",explain.getName());
        assertEquals("query",explain.getData());
    }

    @Test
    public void explainWithDefaultIndex(){
        Explain explain = new Explain.Builder("query").type("tweet").id("1").build();
        assertEquals("POST",explain.getRestMethodName());
        assertEquals("<jesttempindex>/tweet/1/_explain",explain.getURI());
        assertEquals("EXPLAIN",explain.getName());
        assertEquals("query",explain.getData());
    }

    @Test
    public void explainWithDefaultIndexAndType(){
        Explain explain = new Explain.Builder("query").id("1").build();
        assertEquals("POST",explain.getRestMethodName());
        assertEquals("<jesttempindex>/<jesttemptype>/1/_explain",explain.getURI());
        assertEquals("EXPLAIN",explain.getName());
        assertEquals("query",explain.getData());
    }

}
