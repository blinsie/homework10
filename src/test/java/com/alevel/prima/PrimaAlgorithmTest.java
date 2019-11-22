package com.alevel.prima;

import org.junit.Assert;
import org.junit.Test;

public class PrimaAlgorithmTest {

    private static final int INF = Integer.MAX_VALUE;
    private PrimaAlgorithmUtils primaAlgorithmUtils = new PrimaAlgorithmUtils();

    private int[][] adjacencyMatrix7 = new int[][]{
            {INF, INF,  7,    INF, 5,   INF, 2  },
            {INF, INF,  16,   6,   11,  INF, INF},
            {7,   16,   INF,  INF, 8,   INF, INF},
            {INF, 6,    INF,  INF, 4,   3,   INF},
            {5,   11,   8,    4,   INF, 2,   1  },
            {INF, INF,  INF,  3,   2,   INF, 1  },
            {2,   INF,  INF,  INF, 1,   1,   INF},

    };

    private int[][] adjacencyMatrix2 = new int[][] {
            {0,2},
            {2,0},
    };

    private int[][] adjacencyMatrix3 = new int[][] {
            {0,1,7},
            {1,0,2},
            {7,2,0},
    };

    private int[][] adjacencyMatrixNull = new int[][]{};


    @Test
    public void mstPrimNullTest() {
        Assert.assertEquals(0, primaAlgorithmUtils.mstPrim(adjacencyMatrixNull));
    }

    @Test
    public void mstPrim2Test() {
        Assert.assertEquals(2, primaAlgorithmUtils.mstPrim(adjacencyMatrix2));
    }

    @Test
    public void mstPrim3Test() {
        Assert.assertEquals(3, primaAlgorithmUtils.mstPrim(adjacencyMatrix3));
    }

    @Test
    public void mstPrim7Test() {
        Assert.assertEquals(20, primaAlgorithmUtils.mstPrim(adjacencyMatrix7));
    }
}