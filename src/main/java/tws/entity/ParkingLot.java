package tws.entity;

public class ParkingLot {
	
	private String parkingLotID;
	public ParkingLot(String parkingLotID, int parkingLotCount, int availablePositionCount) {
		this.parkingLotID = parkingLotID;
		this.parkingLotCount = parkingLotCount;
		this.availablePositionCount = availablePositionCount;
	}

	public String getParkingLotID() {
		return parkingLotID;
	}

	public void setParkingLotID(String parkingLotID) {
		this.parkingLotID = parkingLotID;
	}

	public int getParkingLotCount() {
		return parkingLotCount;
	}

	public void setParkingLotCount(int parkingLotCount) {
		this.parkingLotCount = parkingLotCount;
	}

	public int getAvailablePositionCount() {
		return availablePositionCount;
	}

	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}

	private int parkingLotCount;
	private int availablePositionCount;

	public ParkingLot() {
		// TODO Auto-generated constructor stub
	}

}
