public class nodo_arbol {
    int dato, fe;   //fe = factor de equilibrio
    nodo_arbol hijoIzq;
    nodo_arbol hijoDer;

    public nodo_arbol(int d){
        this.dato = d;
        this.fe = 0;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
}
