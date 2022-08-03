import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    Integer[][] estadoInicial = new Integer[3][3];
    Node raiz;
    Node noAtual;
    Integer[][] objetivo = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    Stack<Node> perimetro = new Stack<Node>();
    List<Node> noExplorado = new ArrayList<>();

    public DFS(String... state) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (state[index].equals("0")) {
                    raiz = new Node(0, i, j, estadoInicial, "", 0);
                }
                estadoInicial[i][j] = Integer.parseInt(state[index++]);

            }
        }
        raiz.SetEstado(estadoInicial);
    }

    public boolean Resolver() {
        boolean solucionado = false;
        perimetro.add(raiz);

        while (!perimetro.isEmpty()) {

            noAtual = perimetro.pop();
            noExplorado.add(noAtual);
            if (CaminhoAlcancado()) {
                solucionado = true;
                PrintNoAtual();
                return solucionado;
            } else {
                PrintNoAtual();
            }


            for (Node vizinhos : noAtual.GetVizinhos()) {
                if (noExplorado.indexOf(vizinhos) == -1 && perimetro.contains(vizinhos) == false) {
                    perimetro.add(vizinhos);

                }
            }
            noAtual.Setvizinhos(null);

        }

        return solucionado;
    }

    private boolean CaminhoAlcancado() {
        boolean sucesso = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!noAtual.GetEstado()[i][j].equals(objetivo[i][j])) {
                    sucesso = false;
                    break;
                }

            }
            if (sucesso == true) {
                break;
            }

        }

        return sucesso;
    }

    private void PrintNoAtual() {
        System.out.println("Estado atual -> estado apos: " + noAtual.GetCaminhoObjetivo());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(noAtual.GetEstado()[i][j] + "");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public Integer[][] GetEstadoInicial() {
        return estadoInicial;
    }

    public void SetEstadoInicial(Integer[][] estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Node GetRaiz() {
        return raiz;
    }

    public void SetRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Node GetNoAtual() {
        return noAtual;
    }

    public void SetNoAtual(Node noAtual) {
        this.noAtual = noAtual;
    }

    public Integer[][] Getobjetivo() {
        return objetivo;
    }

    public void Setobjetivo(Integer[][] objetivo) {
        this.objetivo = objetivo;
    }

    public Stack<Node> GetPerimetro() {
        return perimetro;
    }

    public void SetPerimetro(Stack<Node> perimetro) {
        this.perimetro = perimetro;
    }

    public List<Node> GetNoExplorado() {
        return noExplorado;
    }

    public void SetNoExplorado(List<Node> noExplorado) {
        this.noExplorado = noExplorado;
    }


}
