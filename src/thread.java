class threadinit extends Thread{
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
}
public class thread {

	
	public static void main(String[] args){
		threadinit t1= new threadinit();
		t1.start();
		
	}

}




	

