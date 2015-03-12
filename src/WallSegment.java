
import java.util.ArrayList;

/**
 * A WallSegment is made up of bays. The number of bays is determined by the
 * length.
 */
public class WallSegment {

	public ArrayList<Integer> bayHeights;
	public boolean local;
	public boolean access;
	public int angle = 180;

	/**
	 * Concrete sleepers are 2m in length and 0.2m in height
	 *
	 * @param length length of the wall in metres
	 * @param startHeight height of the start of the wall in metres
	 * @param endHeight height of the end of the wall in metres
	 * @param angle default 180, angle of join to the previous wall
	 */
	public WallSegment(int length, double startHeight, double endHeight, int angle) {
		// TODO fill bays ArrayList, the following is wrong
		bayHeights = new ArrayList<>();
		for (int bay = 0; bay < length / 2; bay++) {
			bayHeights.add((int) Math.round(startHeight + (endHeight - startHeight) * bay / length / 2));
		}
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getLength() {
		return bayHeights.size() * 2;
	}

	public int getNumberOfBays() {
		return bayHeights.size();
	}

	public int getHeight(int bay) {
		return bayHeights.get(bay);
	}

	public int getSleepersInWallSegment() {
		int total = 0;
		for (Integer height : bayHeights) {
			total += height;
		}
		return total;
	}

	@Override
	public String toString() {
		return "WallSegment{" + "bays=" + bayHeights + ", local=" + local + ", access=" + access + '}';
	}

}
