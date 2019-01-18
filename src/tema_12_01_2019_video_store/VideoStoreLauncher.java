package tema_12_01_2019_video_store;

public class VideoStoreLauncher {

	public static void main(String[] args) {
		VideoStore videoStore = new VideoStore();
		
		videoStore.addVideo("The Matrix");
		videoStore.addVideo("Godfather II");
		videoStore.addVideo("Star Wars Episode IV: A New Hope");
		
		videoStore.receiveRating("The Matrix", 8);
		videoStore.receiveRating("The Matrix", 7);
		videoStore.receiveRating("The Matrix", 7);
		
		videoStore.receiveRating("Godfather II", 7);
		videoStore.receiveRating("Godfather II", 10);
		videoStore.receiveRating("Godfather II", 7);
		
		videoStore.checkOut("the matrix");
		videoStore.returnVideo("the matrix");
		
		videoStore.checkOut("Godfather II");
		videoStore.listInventory();
		videoStore.returnVideo("Godfather II");
		
		
		
		videoStore.checkOut("Star Wars Episode IV: A New Hope");
		videoStore.returnVideo("Star Wars Episode IV: A New Hope");
		
		
		

	}

}
