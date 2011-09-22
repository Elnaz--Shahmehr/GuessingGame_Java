
public class HighscoreItem implements Comparable<HighscoreItem> {
	private String name;
	private int guesses;
	private long time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGuesses() {
		return guesses;
	}
	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long l) {
		this.time = l;
	}
	public int compareTo(HighscoreItem o) {
		
		if (this.getGuesses() == o.getGuesses()) {
			if (this.getTime() == o.getTime()) {
				return 0;
			} else if(this.getTime() > o.getTime()) {
				return 1;
			} else return -1;
		} else if (this.getGuesses() > o.getGuesses()) {
			return 1;
		} else return -1;	
	}
	
}
