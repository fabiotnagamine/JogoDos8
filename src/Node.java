import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    int i, j;
    Integer nodeVal;
    Integer[][] estado = new Integer[3][3];
    List<Node> vizinhos = new ArrayList<>();
    String caminhoObjetivo = "";
    Integer custoCaminho = 0;
    int searchDepth = 0;
    static int maxSearchDepth = 0;
    public Node(Integer nodeVal, int i, int j, Integer[][] estado, String caminhoObjetivo,Integer custoCaminho)
    {
        this.nodeVal = nodeVal;
        this.i = i;
        this.j = j;
        this.estado = estado;
        this.caminhoObjetivo = caminhoObjetivo;
        this.custoCaminho = custoCaminho;
        this.searchDepth = custoCaminho;
        if(searchDepth > maxSearchDepth)
        {
            maxSearchDepth = searchDepth;
        }
    }



    private void GetVizinhoDireita() {
        Integer[][] estadoTemp = new Integer[3][3];
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 3; l++)
            {
                estadoTemp[k][l] = estado[k][l];
            }
        }
        int i1 = i, j1 = j + 1;
        Integer nodeValTemp;
        if(j + 1 < 3)
        {
            nodeValTemp = estadoTemp[i1][j1];
            Integer temp = estadoTemp[i1][j1];
            estadoTemp[i1][j1] = estadoTemp[i][j];
            estadoTemp[i][j] = temp;
            Node tempNode = new Node(nodeValTemp, i1, j1, estadoTemp, caminhoObjetivo+" Direita", custoCaminho+1);
            vizinhos.add(tempNode);
        }

    }



    private void GetVizinhoEsquerda() {
        Integer[][] estadoTemp = new Integer[3][3];
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 3; l++)
            {
                estadoTemp[k][l] = estado[k][l];
            }
        }
        int i1 = i, j1 = j - 1;
        Integer nodeValTemp;
        if(j - 1 >= 0)
        {
            nodeValTemp = estadoTemp[i1][j1];
            Integer temp = estadoTemp[i1][j1];
            estadoTemp[i1][j1] = estadoTemp[i][j];
            estadoTemp[i][j] = temp;
            Node tempNode = new Node(nodeValTemp, i1, j1, estadoTemp, caminhoObjetivo+" Esquerda", custoCaminho+1);
            vizinhos.add(tempNode);
        }

    }



    private void GetVizinhoBaixo() {
        Integer[][] estadoTemp = new Integer[3][3];
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 3; l++)
            {
                estadoTemp[k][l] = estado[k][l];
            }
        }
        int i1 = i + 1, j1 = j;
        Integer nodeValTemp;
        if(i + 1 < 3)
        {
            nodeValTemp = estadoTemp[i1][j1];
            Integer temp = estadoTemp[i1][j1];
            estadoTemp[i1][j1] = estadoTemp[i][j];
            estadoTemp[i][j] = temp;
            Node tempNode = new Node(nodeValTemp, i1, j1, estadoTemp, caminhoObjetivo+" Baixo", custoCaminho+1);
            vizinhos.add(tempNode);
        }

    }



    private void GetVizinhoCima() {
        Integer[][] estadoTemp = new Integer[3][3];
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 3; l++)
            {
                estadoTemp[k][l] = estado[k][l];
            }
        }
        int i1 = i - 1, j1 = j;
        Integer nodeValTemp;
        if(i - 1 >= 0)
        {
            nodeValTemp = estadoTemp[i1][j1];
            Integer temp = estadoTemp[i1][j1];
            estadoTemp[i1][j1] = estadoTemp[i][j];
            estadoTemp[i][j] = temp;
            Node tempNode = new Node(nodeValTemp, i1, j1, estadoTemp, caminhoObjetivo+" Cima", custoCaminho+1);
            vizinhos.add(tempNode);
        }



    }



    public Node() {
        super();
    }



    public int GetI() {
        return i;
    }

    public void SetI(int i) {
        this.i = i;
    }

    public int GetJ() {
        return j;
    }

    public void SetJ(int j) {
        this.j = j;
    }

    public Integer GetNodeVal() {
        return nodeVal;
    }

    public void SetNodeVal(Integer nodeVal) {
        this.nodeVal = nodeVal;
    }

    public Integer[][] GetEstado() {
        return estado;
    }

    public void SetEstado(Integer[][] estado) {
        this.estado = estado;
    }



    public List<Node> GetVizinhos() {
        GetVizinhoDireita();
        GetVizinhoEsquerda();
        GetVizinhoBaixo();
        GetVizinhoCima();



        return vizinhos;
    }



    public String GetCaminhoObjetivo() {
        return caminhoObjetivo;
    }



    public void SetCaminhoObjetivo(String caminhoObjetivo) {
        this.caminhoObjetivo = caminhoObjetivo;
    }



    public void Setvizinhos(List<Node> vizinhos) {
        this.vizinhos = vizinhos;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeVal == null) ? 0 : nodeVal.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (nodeVal == null) {
            if (other.nodeVal != null)
                return false;
        } else if (!nodeVal.equals(other.nodeVal))
            return false;
        return true;
    }



    public Integer GetcustoCaminho() {
        return custoCaminho;
    }



    public void SetcustoCaminho(Integer custoCaminho) {
        this.custoCaminho = custoCaminho;
    }



    public int GetSearchDepth() {
        return searchDepth;
    }



    public void SetSearchDepth(int searchDepth) {
        this.searchDepth = searchDepth;
    }

    public int GetMaxSearchDepth() {
        return maxSearchDepth;
    }

    public void SetMaxSearchDepth(int maxSearchDepth) {
        this.maxSearchDepth = maxSearchDepth;
    }


}
