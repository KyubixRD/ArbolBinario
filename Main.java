public class Main
{
    static ArbolBinario arbol = new ArbolBinario();
    public static void main(String[] args)
    {
        arbol.insertarValor(8);
        arbol.insertarValor(7);
        arbol.insertarValor(4);
        arbol.insertarValor(1);
        arbol.insertarValor(14);
        arbol.insertarValor(2);

        arbol.muestraAcostado(0, arbol.regresaRaiz());

        arbol.recorridoInOrder(arbol.regresaRaiz());
        arbol.recorridoPostOrder(arbol.regresaRaiz());
        arbol.recorridoPreOrder(arbol.regresaRaiz());

        arbol.eliminarNodo(4);
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        arbol.buscarNodo(14);



    }
}
