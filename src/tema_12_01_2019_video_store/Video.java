package tema_12_01_2019_video_store;

public class Video {
	
	private String title;
	private boolean isInStoreFlag = true;
	private int numberOfRatings;
	private int totalRatings;
	private double averageUserRating;
	
	
	public Video(String title) {
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public boolean getIsInStoreFlag() {
		return isInStoreFlag;
	}
	public void setIsInStoreFlag(boolean flag) {
		this.isInStoreFlag = flag;
	}
	public double getUserRating() {
		return averageUserRating;
	}
	public void setUserRating(double userRating) {
		this.averageUserRating = userRating;
	}

	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public int getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}
	

}
