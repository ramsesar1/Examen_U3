import java.util.Observable;

@SuppressWarnings("deprecation")
public class Enemigos extends Observable implements Runnable {

    private Navecita[] aliens = new Navecita[55];
    private Navecita[] comparar = new Navecita[55];

    public Enemigos() {
        int posi_y=100, multi=0;
        for (int i=0;i<aliens.length;i++) {

            aliens[i] = new Navecita(multi * 60 + 5, posi_y);
            comparar[i] = new Navecita(aliens[i]);
            multi++;

            if(i==10 || i==21 || i==32 || i==43) {
                posi_y+=40;
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
        int aux_x=0;
        int aux_y=0;
        int direccion = 1;

        try {
            while(!navesDestruidas()) {

                for (int i=0;i<aliens.length;i++) {
                    if(aliens[i].isVivo()) {
                        if((comparar[i].getPosi_x()+55)>aliens[i].getPosi_x() && direccion==1) {
                            aux_x = aliens[i].getPosi_x()+5;
                            aliens[i].setPosi_x(aux_x);
                            direccion=1;

                        }else {
                            direccion=2;
                            aux_x = aliens[i].getPosi_x()-5;
                            aliens[i].setPosi_x(aux_x);

                        }

                        if ((comparar[i].getPosi_x()+55)==aliens[i].getPosi_x() || comparar[0].getPosi_x()==aliens[0].getPosi_x()){
                            aux_y = aliens[i].getPosi_y()+25;
                            aliens[i].setPosi_y(aux_y);
                        }

                    }


                }
                if (comparar[0].getPosi_x()==aliens[0].getPosi_x()) {
                    direccion=1;
                }




                this.setChanged();
                this.notifyObservers(aliens);
                this.clearChanged();

                Thread.sleep(700);

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