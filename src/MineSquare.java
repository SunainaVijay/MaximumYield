

/**
 *Class MineSquare to store the quantity of dilithium and the index 
 *of the mine square in the List
 */
public class MineSquare implements Comparable<MineSquare>{
	
	private int index;
	private int stripValue;
	
	public MineSquare(int index, int stripValue) {
		this.index = index;
		this.stripValue = stripValue;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getStripValue() {
		return stripValue;
	}

	public void setStripValue(int stripValue) {
		this.stripValue = stripValue;
	}
	
	public int compareTo(MineSquare compareStrip) {
		int compareValue = ((MineSquare) compareStrip).getStripValue();
		return compareValue - this.stripValue;
	}
}
