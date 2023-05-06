import java.util.Observable;

import javax.swing.JPanel;

@SuppressWarnings("deprecation")
public class Enemigos extends Observable implements Runnable {
	
	private Navecita[] aliens = new Navecita[55];
	
	public Enemigos() {
		int posi_y=100, multi=0;
		for (int i=0;i<aliens.length;i++) {
			
			aliens[i] = new Navecita(multi * 60 + 20, posi_y);
			multi++;
			
			if(i==10 || i==21 || i==32 || i==43) {
				posi_y+=60;
				multi=0;
			}
		}
		
	}
	
	public Enemigos(Enemigos e) {
		this.aliens=e.aliens;
	}
	
	//GETTERES AND SETTERS
	public Navecita[] getEnemigos() {
		return aliens;
	}

	public void setEnemigos(Navecita[] enemigos) {
		this.aliens = enemigos;
	}
	//

	@Override
	public void run() {
		int aux=0;
		
		try {
			while(!navesDestruidas()) {
				for (int i=0;i<aliens.length;i++) {
					if(aliens[i].isVivo()) {
						aux = aliens[i].getPosi_x()+5;
						aliens[i].setPosi_x(aux);
					}
				}
				
				for (int i=0;i<aliens.length;i++) {
					System.out.println("X: "+aliens[i].getPosi_x()+" Y: "+aliens[i].getPosi_y());
				}
			
				this.setChanged();
				this.notifyObservers(aliens);
				this.clearChanged();
				
				Thread.sleep(1000);
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean navesDestruidas() {
		int count=0;
		boolean resultado=false;
		
		for(int i=0;i<aliens.length;i++) {
			if (aliens[i].isVivo()) {
				count++;
			}
		}
		
		if (count==0) {
			resultado=true;
		}
		
		return resultado;
	}

}
