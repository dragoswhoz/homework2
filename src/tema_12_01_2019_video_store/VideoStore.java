package tema_12_01_2019_video_store;

import java.util.*;

public class VideoStore {

	private List<Video> videoList = new ArrayList<>();

	//public void addVideo(Video video) { ce zici daca ai fi facut ca metoda addVideo sa primeasca direct Video
	//avantajul acestei abordari e ca poti pasa un obiet Video construit in mai multe moduri, 
	//sau cu diverse campuri setate, nu doar cu title
	public void addVideo(String title) {
		Video video = new Video(title);
		videoList.add(video);
	}

	public void checkOut(String title) {
		for (Video video : videoList) {
			if (video.getTitle().toLowerCase().equals(title.toLowerCase())) {
				video.setIsInStoreFlag(false);
			}
		}

	}

	public void returnVideo(String title) {
		for (Video video : videoList) {
			if (video.getTitle().toLowerCase().equals(title.toLowerCase())) {
				video.setIsInStoreFlag(true);
			}
		}

	}

	public void receiveRating(String title, int rating) {
		for (Video video : videoList) {
			if (video.getTitle().toLowerCase().equals(title.toLowerCase())) {
				video.setNumberOfRatings(video.getNumberOfRatings() + 1);
				video.setTotalRatings(video.getTotalRatings() + rating);
				video.setUserRating((double) video.getTotalRatings() / (double) video.getNumberOfRatings());

			}
		}

	}

	public void listInventory() {
		for (Video video : videoList) {
			System.out.println("Movie " + (videoList.indexOf(video) + 1) + ":");
			System.out.println();
			System.out.println("Title:" + video.getTitle());
			System.out.println("Average rating: " + video.getUserRating());
			System.out.println("In store status: " + video.getIsInStoreFlag());
			System.out.println("**********************************************************************");
		}

	}

}
