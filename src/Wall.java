
import java.util.ArrayList;

/**
 * A Wall is composed of WallSegments
 */
public class Wall {
//	public static void main(String[] args) {
//		Wall w = new Wall();
//		
//		int length = 10;
//		int start = 2;
//		int end = 4;
//		int angle = 180;
//		w.addWallSegment(new WallSegment(length, start, end, false, false, null, angle));
//		
//		w.addWallSegment(new WallSegment(12, 4, 6, false, false, null, 180));
//		
//	}
	
	ArrayList<WallSegment> wallSegments = new ArrayList<>();
	
	public void addWallSegment(WallSegment wallSegment) {
		wallSegments.add(wallSegment);
	}
	
	public int getSleepersInWall() {
		int total = 0;
		for (WallSegment segment : wallSegments) {
			total += segment.getSleepersInWallSegment();
		}
		return total;
	}
	
	public int getNumberOfSegments() {
		return wallSegments.size();
	}
	
	public WallSegment getSegment(int segmentNumber) {
		return wallSegments.get(segmentNumber);
	}
}
