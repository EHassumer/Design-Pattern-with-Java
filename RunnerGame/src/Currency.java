
public abstract class Currency {
	private final int point;

	public Currency() {
		this.point =0;
	}

	public int getPoint() {
		return point;
	}
	public abstract void gain();

}
