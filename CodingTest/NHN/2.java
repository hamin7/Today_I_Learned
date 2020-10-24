import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Main {
  private static void solution(int day, int width, int[][] blocks) {
		int[] building = new int[width];
		int howMany = 0;
		
		for (int i = 0; i < width; i++) {
			building[i] = blocks[0][i];
		}
		
		// 빌딩에 시멘트 붇기
		building = buildCement(building);
		
  }
  
	public static int[] buildCement(int[] building) {
		// bar 높이 순서 찾기
		int[] barHeightOrder = findBarHeigthOrder(building);
		int totalCount = 0;
		
		for (int i = 0; i < barHeightOrder.length-1; i++) {
			int heighestBar = barHeightOrder[barHeightOrder.length - 1 - i];
			int secondBar = barHeightOrder[barHeightOrder.length - 1 - i - 1];
			int heighestBarIndex = 0;
			int secondBarIndex = 0;
			
			for (int j = 0; j < building.length; j++) {
				if (building[j] == heighestBar) {
					heighestBarIndex = j;
				}
				if (building[j] == secondBar) {
					secondBarIndex = j;
				}
			}
			
			// System.out.println(heighestBarIndex+","+secondBarIndex);
			// 이제 heighestBarIndex와 secondBarIndex 사이 시멘트 부으면 됨.
			// target 높이는 secondBarIndex
			int rightBarIndex = 0;
			int leftBarIndex = 0;
			
			if (heighestBarIndex > secondBarIndex) {
				leftBarIndex = secondBarIndex;
				rightBarIndex = heighestBarIndex;
			} else {
				leftBarIndex = heighestBarIndex;
				rightBarIndex = secondBarIndex;
			}
			
			int count = 0;
			for (int j = leftBarIndex+1; j < rightBarIndex; j++) {
				count += building[secondBarIndex] - building[j];
			}
			if(count > 0) {
				totalCount += count;
			}
		}
		
		
		return building;
	}
	
	// 젤 높은 것 찾는 함수.
	public static int[] findBarHeigthOrder(int[] building) {
		int[] temporaryBuilding = new int[building.length];
		int heighestBarIndex = 0;
		
		for (int i = 0; i < building.length; i++) {
			temporaryBuilding[i] = building[i];
		}
		
		Arrays.sort(temporaryBuilding);
		
		return temporaryBuilding;
	}

  private static class InputData {
    int day;
    int width;
    int[][] blocks;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      
      inputData.blocks = new int[inputData.day][inputData.width];
      for (int i = 0; i < inputData.day; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.width; j++) {
          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.day, inputData.width, inputData.blocks);
  }
}