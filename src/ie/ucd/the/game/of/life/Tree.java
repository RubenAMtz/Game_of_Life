package ie.ucd.the.game.of.life;

public class Tree {
    private Node root;
    private Node trackNode;

    public Tree(String data) {
        this.root = new Node(data, null, null);
        // trackNode es igual siempre al ultimo nodo añadido
        this.trackNode = this.root;
    }

    public Node addNode(String data) {
        // para agregar un nodo al arbol, crea un nodo nuevo:
        Node newNode = new Node(data, null, null);
        // si la primera opcion del ultimo nodo añadido == null
        if (trackNode.getFirst() == null) {
            // entonces agrega el nuevo nodo a la primera opcion
            trackNode.setFirst(newNode);
            // setea trackNode (el ultimo nodo) como este ultimo nodo añadido (newNode)
            this.trackNode = newNode;
        }
        // simplemente regresa el nodo añadido. (esto podria no regresar nada¿?(creo que
        //ni estoy usando este return)
        // entiendes?
        // y abajo:
        return newNode; 
    }

    public Node getRoot() {
        return this.root;
    }

    public void print(Node node) {
        // print es esta funcion, que acepta un nodo como argumento.
        // si el nodo recibido como argumento es == null, no hagas nada
        // pero si es dif. de null:
        if (node != null){
            // vuelve a llamar a esta misma funcion print
            // pero en el first de este nodo. (que es otro nodo)
            print(node.getFirst()); //recursividad
            // has lo mismo pero en el second (que es otro nodo)
            print(node.getSecond()); //recursividad
            // imprime data.
            //esta funcion si esta un poquito mas rara
            //pero ten encuenta que cada vez que llamo a print(nodo)
            //no se ejecuta lo que esta dentro del "if" si el "nodo"
            //que pasé como argumento es null
            //se detiene en el ultimo nodo pq first y second = null
            System.out.printf(node.getData());
        }
    }
}