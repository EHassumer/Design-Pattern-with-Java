package ShipAndDecorator;

abstract class ShipDecorator implements Ship{

	protected Ship tempShip;
	public ShipDecorator(Ship newShip) {
		tempShip= newShip;
	}
	public String getName() {
		return tempShip.getName();
	}
	public int getPoit() {
		return tempShip.getPoint();
	}
}
