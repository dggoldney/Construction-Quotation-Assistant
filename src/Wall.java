
import java.util.ArrayList;

/**
 * A Wall is composed of WallSegments
 */
public class Wall {

	private boolean isLocal;
	private boolean hasAccess;
	private Difficulty difficulty;

	/**
	 *
	 * @param local true if local, false otherwise
	 * @param access true if adequate access, false otherwise
	 * @param difficulty not difficult, sandy conditions, limestone, or
	 * bluestone
	 */
	public Wall(boolean local, boolean access, Difficulty difficulty) {
		this.isLocal = local;
		this.hasAccess = access;
		this.difficulty = difficulty;
	}
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

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public void setAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void setDifficulty(String difficulty) {
		Difficulty d = Difficulty.normal;
		switch (difficulty) {
			case "Sandy":
				d = Difficulty.sandy;
				break;
			case "Limestone":
				d = Difficulty.limestone;
				break;
			case "Bluestone":
				d = Difficulty.bluestone;
				break;
		}
		this.difficulty = d;
	}
}
