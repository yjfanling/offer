package leetcode100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {

    @Test
    void numIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] map = new char[][]{
                {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
};
        numIslands.numIslands(map);
        numIslands.numIslandsDsf(map);
    }
}