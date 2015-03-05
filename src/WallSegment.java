
import java.util.ArrayList;

/**
 * A WallSegment is made up of bays. The number of bays is determined by the length.
 * 
 */
public class WallSegment {
	private ArrayList<Integer> bays;
	public boolean local;
	public boolean access;
	public Difficulty difficulty;
	public int angle = 180;

	public enum Difficulty {

		not, sandy, limestone, bluestone
	}

	/**
	 * @param length length of the wall in metres
	 * @param startHeight height of the start of the wall in metres
	 * @param endHeight height of the end of the wall in metres
	 * @param local true if local, false otherwise
	 * @param access true if adequate access, false otherwise
	 * @param difficulty not difficult, sandy conditions, limestone, or
	 * bluestone
	 * @param angle default 180, angle of join to the previous wall
	 */
	public WallSegment(int length, int startHeight, int endHeight, boolean local, boolean access, Difficulty difficulty, int angle) {

		// TODO fill bays ArrayList
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getLength() {
		return bays.size() * 2;
	}

	public int getNumberOfBays() {
		return bays.size();
	}

	public int getHeight(int bay) {
		return bays.get(bay);
	}

	public int getSleepersInWallSegment() {
		int total = 0;
		for (Integer height : bays) {
			total += height;
		}
		return total;
	}

	@Override
	public String toString() {
		return "WallSegment{" + "bays=" + bays + ", local=" + local + ", access=" + access + ", difficulty=" + difficulty + '}';
	}

}
