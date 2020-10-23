import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	private static int[] X = {-1, 0, 1, 0};		// x축의 상하좌우 이동을 위한 베열
	private static int[] Y = {0, 1, 0, -1};		// y축의 상하좌우 이동을 위한 배열 (x, y 짝만 맞추어주면 상하좌우든 하좌우상이든 순서 상관 x)
	private static int cnt = 1;
	
  private static void solution(int x, int y, boolean[][] ck, int[][] map) {
		ck[x][y] = true;
		map[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + X[i];
			int nextY = y + Y[i];
			// 상, 하, 좌, 우 이동 중 범위가 넘어서는 경우 continue
			if (nextX < 0 || nextY < 0 || nextX >= ck.length || nextY >= ck.length) {
				continue;
			} 
			if (ck[nextX][nextY]) {
				// 방문한 곳은 continue
				continue;
			}
			if (map[nextX][nextY] == 0) {
				// 0은 벽이라서 이동할 경로가 벽이면 continue
				ck[nextX][nextY] = true;
				continue;
			}
			
			solution(nextX, nextY, ck, map);
			cnt++;
		}
  }
  
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();		// 각 영역의 넓이를 저장할 ArrayList 생성.
		boolean[][] check = new boolean[inputData.sizeOfMatrix][inputData.sizeOfMatrix];		// 방문한 곳을 체크하기 위한 배열 행렬 생성.
		
		for (int i = 0; i < inputData.sizeOfMatrix; i++) {
			// (0, 0) 부터 탐색 시작 후 1을 만나면 넓이 구하기 시작.
			for (int j = 0; j < inputData.sizeOfMatrix; j++) {
				if (inputData.matrix[i][j] == 1) {
					solution(i, j, check, inputData.matrix);
					arr.add(cnt);
					cnt = 1;
				}
				// 아닌 경우 continue
				else {
					continue;
				}
			}
		}
		
		System.out.println(arr.size());
		Collections.sort(arr);
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
  }
}