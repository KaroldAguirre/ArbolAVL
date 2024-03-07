public class principal {
    public static void main(String[] args) {
        arbol arbolAVL = new arbol();

        arbolAVL.insertar(10);
        arbolAVL.insertar(5);
        arbolAVL.insertar(13);
        arbolAVL.insertar(1);
        arbolAVL.insertar(6);
        arbolAVL.insertar(17);
       // arbolAVL.insertar(16);

        arbolAVL.preOrder(arbolAVL.obtenerRaiz());
    }


}
