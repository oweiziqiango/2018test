package wzq.test.algorithm.graph;
/**
 * 深度优先搜索
 * @author Administrator
 *
 */
public class LeetcodeDeepFirstSearch {

	private static int[][] grids ={{1,1,0,0,0},
			{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}
	};
    private static boolean[][] seen = new boolean[grids.length][grids[0].length];

    public static int area(int r, int c) {
        if (r < 0 || r >= grids.length || c < 0 || c >= grids[0].length ||
                seen[r][c] || grids[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                  + area(r, c-1) + area(r, c+1));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        //grids = grid;
        //记录节点是否已经被遍历
        //seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        //r：行   c：列
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		
		//grid = 
		int island = maxAreaOfIsland(grids);
		System.out.println(island);
	}

}
