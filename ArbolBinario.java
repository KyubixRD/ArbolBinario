public class ArbolBinario{   		//Java Beans
    private Node raiz;  //null

    ArbolBinario(){
        this.raiz = null;
    }

    public boolean esVacio(){
        return (this.raiz == null);
    }

    public Node regresaRaiz(){   //getRaiz  -- getter de atributo raiz
        return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Node();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Node nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Node();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }
        else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Node();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }


    public void muestraAcostado(int nivel, Node nodoRef)
    {
        if (nodoRef == null){
            return;
        }
        else {
            muestraAcostado(nivel + 1, nodoRef.derecho);

            for (int i=0; i < nivel; i++){
                System.out.print("   ");
            }

            System.out.println(nodoRef.dato);
            muestraAcostado(nivel + 1, nodoRef.izquierdo);
        }
    }

    public void recorridoInOrder(Node nodoRef)
    {
        if (nodoRef != null) {
            recorridoInOrder(nodoRef.izquierdo);
            System.out.print(nodoRef.dato + " ");
            recorridoInOrder(nodoRef.derecho);
        }
    }

    public void recorridoPostOrder(Node nodoRef)
    {
        if (nodoRef != null)
        {
            recorridoPostOrder(nodoRef.izquierdo);
            recorridoPostOrder(nodoRef.derecho);
            System.out.print(nodoRef.dato + " ");
        }
    }

    public void recorridoPreOrder(Node nodoRef)
    {
        if (nodoRef != null) {
            System.out.print(nodoRef.dato + " ");
            recorridoPreOrder(nodoRef.izquierdo);
            recorridoPreOrder(nodoRef.derecho);
        }
    }


    public void eliminarNodo(int valor)
    {
        this.raiz = eliminarNodoRecursivo(this.raiz, valor);
    }

    private Node eliminarNodoRecursivo(Node nodo, int valor)
    {
        if (nodo == null)
        {
            return nodo;
        }
        // Buscar el nodo a eliminar en el subárbol izquierdo o derecho según sea necesario
        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarNodoRecursivo(nodo.izquierdo, valor);
        }
        else if (valor > nodo.dato)
        {
            nodo.derecho = eliminarNodoRecursivo(nodo.derecho, valor);
        }
        else
        {
            // Nodo encontrado, realizar la eliminación

            // Caso 1: Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null)
            {
                return nodo.derecho;
            }
            else if (nodo.derecho == null)
            {
                return nodo.izquierdo;
            }

            // Caso 2: Nodo con dos hijos
            // Encontrar el sucesor inorden (el valor más pequeño en el subárbol derecho)
            nodo.dato = encontrarSucesorInorden(nodo.derecho);

            // Eliminar el sucesor inorden
            nodo.derecho = eliminarNodoRecursivo(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private int encontrarSucesorInorden(Node nodo)
    {
        int sucesor = nodo.dato;

        while (nodo.izquierdo != null)
        {
            sucesor = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return sucesor;
    }

    public boolean buscarNodo(int valor)
    {
        Node nodoEncontrado = buscarNodoRecursivo(this.raiz, valor);

        if (nodoEncontrado != null)
        {
            return true;
            //return "Nodo encontrado con valor " + valor;
        }
        else
        {
            return false;
        }
    }

    private Node buscarNodoRecursivo(Node nodo, int valor)
    {
        if (nodo == null || nodo.dato == valor)
        {
            return nodo;
        }

        // Si el valor a buscar es menor que el valor del nodo, buscar en el subárbol izquierdo
        if (valor < nodo.dato)
        {
            return buscarNodoRecursivo(nodo.izquierdo, valor);
        }
        // Si el valor a buscar es mayor que el valor del nodo, buscar en el subárbol derecho
        return buscarNodoRecursivo(nodo.derecho, valor);
    }


}



