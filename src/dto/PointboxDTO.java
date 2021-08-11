package dto;

public class PointboxDTO {
	private String Stclass;
	private String Stname;
	private int Score;
	
	public String getStclass() {
		return Stclass;
	}
	public void setStclass(String stclass) {
		Stclass = stclass;
	}
	public String getStname() {
		return Stname;
	}
	public void setStname(String stname) {
		Stname = stname;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int Score) {
		this.Score = Score;
	}
	@Override
	public String toString() {
		return "PointboxDTO [Stclass=" + Stclass + ", Stname=" + Stname + ", Score=" + Score + "]";
	}
	
	
}
