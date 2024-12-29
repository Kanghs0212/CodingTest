import java.util.*;

class Solution {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] land) {
        int answer = 0;
        int rows = land.length;
        int cols = land[0].length;

    
        Map<Integer, Integer> oilSizes = new HashMap<>();
        boolean[][] visited = new boolean[rows][cols];
        int currentOilId = 2; 

   
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(land, visited, i, j, currentOilId);
                    oilSizes.put(currentOilId, size);
                    currentOilId++;
                }
            }
        }

     
        for (int col = 0; col < cols; col++) {
            int totalOil = 0;
            Set<Integer> seenOilIds = new HashSet<>();

            for (int row = 0; row < rows; row++) {
                int oilId = land[row][col];
                if (oilId > 1 && !seenOilIds.contains(oilId)) {
                    totalOil += oilSizes.get(oilId);
                    seenOilIds.add(oilId);
                }
            }
            answer = Math.max(answer, totalOil);
        }

        return answer;
    }

    private int bfs(int[][] land, boolean[][] visited, int x, int y, int oilId) {
        int rows = land.length;
        int cols = land[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visited[x][y] = true;
        land[x][y] = oilId; 

        int size = 0;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    land[nx][ny] = oilId; 
                    queue.offer(new Pair(nx, ny));
                }
            }
        }

        return size;
    }
}