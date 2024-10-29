import java.util.Scanner;

public class celula {
    class Celula{
        private int elemento;
        private Celula prox, ant;

        public Celula(){
            elemento = 0;
        }
        public Celula(int x){
            this.elemento = x;
            this.prox = this.ant =null;
        }
        public void setProx(Celula prox){
            this.prox = prox;
        }
        public void setAnt(Celula ant){
            this.ant = ant;
        }
        public int getElemento(){
            return this.elemento;
        }
    }

    class Lista{
        public Celula ultima;
        public Celula primeira;
        public Lista(){
            primeira = new Celula();
            ultima = primeira;
        }
        public void inserirFim(int x){
            if(ultima == primeira){
                Celula temp = new Celula(x);
                temp.setProx(primeira);
                primeira.setAnt(temp);
                temp.setAnt(null);
                ultima = temp;
            }else {
                Celula temp = new Celula(x);
                temp.setProx(ultima);
                ultima.setAnt(temp);
                temp.setAnt(null);
                ultima = temp;
                temp = null;
            }
        }
        public void inserirInicio(int x){
            if(ultima == primeira){
                Celula temp = new Celula(x);
                temp.setProx(primeira);
                primeira.setAnt(temp);
                temp.setAnt(null);
                ultima = temp;
            } else{
                Celula temp = new Celula(x);
                temp.setProx(primeira);
                temp.setAnt(primeira.ant);
                primeira.ant.setProx(temp);
                primeira.setAnt(temp);
                temp = null;
            }
        }
        public int removerFim() throws Exception{
            if(ultima.elemento == 0 ){
                throw new Exception("ERRO!");
            }
            int elemento = ultima.elemento;
            ultima = ultima.prox;
            ultima.setAnt(null);
            return elemento;
        }
        public int removerInicio() throws Exception{
            int elemento;
            if(primeira.ant.elemento == 0 ){
                throw new Exception("ERRO!");
            }else{
                Celula temp = primeira.ant;
                elemento = temp.elemento;
                if(temp.ant != null){
                    primeira.setAnt(temp.ant);
                    temp.ant.setProx(primeira);
                } else{
                    primeira.setAnt(null);
                }
            }
            return elemento;
        }
    }

    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            celula outer = new celula(); 
            Lista lista = outer.new Lista(); 
            int elemento;
            for (int i = 0; i < 5 ; i++){
                elemento = sc.nextInt();
                lista.inserirFim(elemento);
                elemento = sc.nextInt();
                lista.inserirInicio(elemento);
            }
            for (int i = 0; i < 5 ; i++){
                System.out.println(lista.removerFim());
                System.out.println(lista.removerInicio());
            }
        }
        catch (Exception e){
            System.out.println("erro!" + e.getMessage());
        }
    }
}
