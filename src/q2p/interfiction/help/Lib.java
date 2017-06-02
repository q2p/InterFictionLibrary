package q2p.interfiction.help;

import java.util.Random;

public final class Lib {
	private static final Random random = new Random();
	
	public static final int random(final int bound) {
		return random.nextInt(bound);
	}
	public static final int selectRandom(final byte ... chances) {
		int total = 0;
		
		for(int i = chances.length-1; i != -1; i--)
			total += chances[i];
		
		int cursor = random.nextInt(total);
		
		for(int i = 0; i != chances.length; i++) {
			if(chances[i] == 0)
				continue;
			
			if(cursor < chances[i])
				return i;
			
			cursor -= chances[i];
		}
		
		return 0;
	}
	public static final int selectRandom(final short... chances) {
		int total = 0;
		
		for(int i = chances.length-1; i != -1; i--)
			total += chances[i];
		
		int cursor = random.nextInt(total);
		
		for(int i = 0; i != chances.length; i++) {
			if(chances[i] == 0)
				continue;
			
			if(cursor < chances[i])
				return i;
			
			cursor -= chances[i];
		}
		
		return 0;
	}
	public static final int selectRandom(final int ... chances) {
		int total = 0;
		
		for(int i = chances.length-1; i != -1; i--)
			total += chances[i];
		
		int cursor = random.nextInt(total);
		
		for(int i = 0; i != chances.length; i++) {
			if(chances[i] == 0)
				continue;
			
			if(cursor < chances[i])
				return i;
			
			cursor -= chances[i];
		}
		
		return 0;
	}
	public static final String pick(final int id, final String ... variants) {
		return variants[id];
	}
	public static final byte pick(final int id, final byte ... variants) {
		return variants[id];
	}
	public static final short pick(final int id, final short ... variants) {
		return variants[id];
	}
	public static final int pick(final int id, final int ... variants) {
		return variants[id];
	}
	public static final long pick(final int id, final long ... variants) {
		return variants[id];
	}
	public static final String pickRandom(final String ... variants) {
		return variants[random.nextInt(variants.length)];
	}
	public static final double gapDecimical(final double decimical, final int digitsAfterDot) {
		double multiplier = 1;
		for(int i = digitsAfterDot; i != 0; i--)
			multiplier *= 10;
		return Math.round(decimical*multiplier)/multiplier;
	}
	public static final String decline(final int amount, final String one, final String two, final String five) {
		if (amount > 10 && ((amount % 100) / 10) == 1)
			return five;
	
		switch (amount % 10) {
			case 1:
				return one;
			case 2:
			case 3:
			case 4:
				return two;
			default: // 0, 5-9
				return five;
		}
	}
}