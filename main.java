package main;

import classes.DadosRegressao;
import classes.RegressaoLinear;
import java.util.ArrayList;

public class Principal {
    
    public static void main(String args[]) {
        // Exemplo de dados
        ArrayList<DadosRegressao> dadosRegressao = new ArrayList<>();
        dadosRegressao.add(new DadosRegressao(1,1));
        dadosRegressao.add(new DadosRegressao(2,2));
        dadosRegressao.add(new DadosRegressao(3,3));
        
        RegressaoLinear r = new RegressaoLinear(dadosRegressao);
        
        System.out.println("Theta0 = " + r.getT0() + ", Theta1 = " + r.getT1());
        r.calcularGradientDescent();
        System.out.println("Theta0 = " + r.getT0() + ", Theta1 = " + r.getT1());
        System.out.println(r.retornarPredicao(4));
    }
    
}
