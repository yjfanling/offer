package leetcode100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrangesRottingTest {

    @Test
    void orangesRotting() {
        int[][] map = new int[][]{{2,1,1},{1,1,1},{0,1,2}};
        OrangesRotting orangesRotting = new OrangesRotting();
        orangesRotting.orangesRotting(map);
    }
}