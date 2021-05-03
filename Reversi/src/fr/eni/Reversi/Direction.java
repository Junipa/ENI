package fr.eni.Reversi;

public enum Direction {
	LEFT(),
	TOP_LEFT,
	TOP,
	TOP_RIGHT,
	RIGHT,
	BOTTOM_RIGHT,
	BOTTOM,
	BOTTOM_LEFT;
	
	public static int getNextColumn(Direction direction, int oldColumnValue){
		int newValue;
		switch(direction) {
		case LEFT:
			newValue =  oldColumnValue - 1;
			break;
		case TOP_LEFT:
			newValue =  oldColumnValue - 1;
			break;
		case BOTTOM_LEFT:
			newValue =  oldColumnValue - 1;
			break;
		case RIGHT:
			newValue = oldColumnValue + 1;
			break;
		case TOP_RIGHT:
			newValue = oldColumnValue + 1;
			break;
		case BOTTOM_RIGHT:
			newValue = oldColumnValue + 1;
			break;
		default:
			newValue = oldColumnValue;
			break;
		}
		return newValue;
	}
	
	public static int getNextLine(Direction direction, int oldLineValue){
		int newValue;
		switch(direction) {
		case TOP, TOP_LEFT, TOP_RIGHT:
			newValue =  oldLineValue - 1;
			break;
		case BOTTOM, BOTTOM_LEFT, BOTTOM_RIGHT:
			newValue =  oldLineValue + 1;
			break;
		default:
			newValue =  oldLineValue;
			break;
		}
		return newValue;
	}
}