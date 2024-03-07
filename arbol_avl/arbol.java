/**
 * arbol
 */
public class arbol {
    private nodo_arbol raiz;

    public arbol() {
        raiz = null;
    }

    public nodo_arbol obtenerRaiz() {
        return raiz;
    }

    public nodo_arbol buscar (int d, nodo_arbol r) {
        if (raiz == null) {
            return null;

        } else if (r.dato == d) {
            return r;

        } else if (r.dato < d) {
            return buscar(d, r.hijoDer);

        } else {
            return buscar(d, r.hijoIzq);
        }
    }

    public int obtenerFE(nodo_arbol x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    public nodo_arbol rotacionIzq(nodo_arbol ri) {
        nodo_arbol aux = ri.hijoIzq;
        ri.hijoIzq = aux.hijoDer;
        aux.hijoDer = ri;
        ri.fe = Math.max(obtenerFE(ri.hijoIzq), obtenerFE(ri.hijoDer)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hijoIzq), obtenerFE(aux.hijoDer)) + 1;

        return aux;
    }

    public nodo_arbol rotacionDer(nodo_arbol rd) {
        nodo_arbol aux = rd.hijoDer;
        rd.hijoDer = aux.hijoIzq;
        aux.hijoIzq = rd;
        rd.fe = Math.max(obtenerFE(rd.hijoIzq), obtenerFE(rd.hijoDer)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hijoIzq), obtenerFE(aux.hijoDer)) + 1;

        return aux;
    }

    public nodo_arbol rotacionDobleIzq(nodo_arbol rdi) { 
        nodo_arbol temporal;
        rdi.hijoIzq = rotacionDer(rdi.hijoIzq);
        temporal = rotacionIzq(rdi);

        return temporal;
    }

    public nodo_arbol rotacionDobleDer(nodo_arbol rdd) {
        nodo_arbol temporal;
        rdd.hijoDer = rotacionIzq(rdd.hijoDer);
        temporal = rotacionDer(rdd);

        return temporal;
    }

    public nodo_arbol insertarAVL(nodo_arbol nuevo , nodo_arbol subAr) {
        nodo_arbol nuevoPadre = subAr;

        if (nuevo.dato < subAr.dato) {

            if (subAr.hijoIzq == null) {
                subAr.hijoIzq = nuevo;
                
            } else {
                subAr.hijoIzq = insertarAVL(nuevo, subAr.hijoIzq);

                if ((obtenerFE(subAr.hijoIzq) - obtenerFE(subAr.hijoDer) == 2)) {

                    if (nuevo.dato < subAr.hijoIzq.dato) {
                        nuevoPadre = rotacionIzq(subAr);

                    } else {
                        nuevoPadre = rotacionDobleIzq(subAr);

                    }
                }
            }

        } else if (nuevo.dato > subAr.dato) {

            if (subAr.hijoDer == null) {
                subAr.hijoDer = nuevo;
                
            } else {
                subAr.hijoDer = insertarAVL(nuevo, subAr.hijoDer);

                if ((obtenerFE(subAr.hijoDer) - obtenerFE(subAr.hijoIzq) == 2)) {

                    if (nuevo.dato > subAr.hijoDer.dato) {
                        nuevoPadre = rotacionDer(subAr);

                    } else {
                        nuevoPadre = rotacionDobleDer(subAr);

                    }

                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }

        if ((subAr.hijoIzq == null) && (subAr.hijoDer != null)) {
            subAr.fe = subAr.hijoDer.fe+1;

        } else if ((subAr.hijoDer == null) && (subAr.hijoIzq != null)) {
            subAr.fe = subAr.hijoIzq.fe + 1;

        } else {
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzq), obtenerFE(subAr.hijoDer));
        }

        return nuevoPadre;
    }

    public void insertar (int d) {
        nodo_arbol nuevo = new nodo_arbol(d);
        if (raiz == null) {
            raiz = nuevo;
            
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    public void inOrder(nodo_arbol r) {

        if (r != null) {
            inOrder(r.hijoIzq);
            System.out.print(r.dato + ", ");
            inOrder(r.hijoDer);
        }

    }

    public void preOrder(nodo_arbol r) {

        if(r != null) {
            System.out.print(r.dato + ", ");
            preOrder(r.hijoIzq);
            preOrder(r.hijoDer);
        }

    }

    public void postOrder(nodo_arbol r) {

        if (r != null) {
            
            preOrder(r.hijoIzq);
            preOrder(r.hijoDer);
            System.out.print(r.dato + ", ");

        }

    }





}