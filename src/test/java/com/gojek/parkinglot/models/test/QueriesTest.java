package com.gojek.parkinglot.models.test;

import com.gojek.parkinglot.models.Queries;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mohan Kotla on 02/June/2019.
 */
public class QueriesTest {
    Queries queries = new Queries();

    @Test
    public void checkQueryInMap() throws Exception {
        assertFalse(queries.queriesMap.isEmpty());
        assertTrue(queries.queriesMap.containsKey("status"));
        assertTrue(queries.queriesMap.containsKey("park"));
        assertTrue(queries.queriesMap.containsKey("leave"));
        assertFalse(queries.queriesMap.containsKey("InvalidQuery"));
    }
}