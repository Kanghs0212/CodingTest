#include<stdio.h>
#include <iostream>
#include<vector>
#include<queue>
#include<array>
using namespace std;


struct Point {
	int x;
	int y;
};


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, a;
	int total_cnt = 0, max_cnt = 0;
	array<int, 4> dx = { 1, 0, -1, 0 };
	array<int, 4> dy = { 0, 1, 0, -1 };

	cin >> n >> m;
	vector<vector<int>> map(n, vector<int>(m, 0)); 
	vector<vector<bool>> visited(n, vector<bool>(m, 0));
	queue<Point> q;


	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> a;
			map[i][j] = a;
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (map[i][j] == 1 && !visited[i][j]) {
				q.push({ i,j });
				int cnt = 0;
				total_cnt++;

				while (!q.empty()) {
					Point cur = q.front();
					q.pop();

					if (visited[cur.x][cur.y]) continue;
					cnt++;
					visited[cur.x][cur.y] = true;

					for (int k = 0; k < 4; k++)
					{
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];

						if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

						if (map[nx][ny] == 1 && !visited[nx][ny])
							q.push({ nx,ny });
					}
				}
				if (cnt > max_cnt)
					max_cnt = cnt;
			}
		}
	}
	cout << total_cnt << "\n" << max_cnt;
	return 0;
}