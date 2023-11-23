package Music;

public class Song {
	String title;
	double duration;
	
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Song{"+
				"title='"+title+'\''+", duration="+duration+'}';
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	
	
	
}
