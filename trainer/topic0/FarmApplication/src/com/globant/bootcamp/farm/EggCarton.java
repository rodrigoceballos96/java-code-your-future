package com.globant.bootcamp.farm;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggColor;

public class EggCarton implements Comparable<EggCarton>{
	private static final Integer ROWS = 6;
	private static final Integer COLUMNS = 5;
	private Integer lastRow = 0;
	private Integer lastColumn = 0;
	private EggColor eggColor;

	private final Egg[][] eggs = new Egg[ROWS][COLUMNS];
	
	public EggCarton(EggColor eggColor) {
		this.eggColor = eggColor;
	}

	public boolean put(Egg egg) {
		if (!isFull()) {
			eggs[lastRow][lastColumn++] = egg;
			if (lastColumn == COLUMNS) {
				lastColumn = 0;
				lastRow++;
			}
		}

		return isFull();
	}

	public void print() {
		for (int row = 0; row < ROWS; row++) {
			String rows = "";
			for (int column = 0; column < COLUMNS; column++) {
				Egg egg = eggs[row][column];
				String character = (egg != null) ? egg.getEggColor().getConsoleChar() : EggColor.EMPTY.getConsoleChar();
				rows += character;
			}
			System.out.println(rows);
		}
	}

	public boolean isFull() {
		return lastRow.equals(ROWS) && lastColumn.equals(0);
	}

	public Egg[][] getEggs() {
		return eggs;
	}

	@Override
	public int compareTo(EggCarton otherEggCartor) {
		// TODO Auto-generated method stub
		return this.eggColor.compareTo(otherEggCartor.eggColor);
	}
}
