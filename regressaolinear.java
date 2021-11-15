package classes;

import java.util.List;

//como calcular as funções
/*
y = a * bx
ho(x) = a * bx
regressão linear = 1/(2m) * E(ho(x) - y)^ 2
*/

public class RegressaoLinear {
private List<DadosRegressao> listaDadosRegressao;
private double t0;
private double t1;
private double taxaAprendizado;
private int qtVezes;    
public RegressaoLinear(List<DadosRegressao> dadosRegressao) {
this.t0 = 0;
this.t1 = 0;

this.taxaAprendizado = 0.1;
this.qtVezes = 2000;

this.listaDadosRegressao = dadosRegressao;
}

public double retornarPredicao(double x) {
return this.t0 + this.t1 * x;
}

public double retornarFuncaoCusto() {
double soma = 0; 
for(DadosRegressao d : this.listaDadosRegressao) {
soma += Math.pow((retornarPredicao(d.x) - d.y), 2);
}
return soma / (2 * this.listaDadosRegressao.size()) ;
}

public void calcularGradientDescent() {
int i = 0;       
double tempT0;
double tempT1;
while (i < this.qtVezes) {
tempT0 = 0;
tempT1 = 0;

for(DadosRegressao d : this.listaDadosRegressao) {
tempT0 += (-(1.0/this.listaDadosRegressao.size()) * (d.y - this.retornarPredicao(d.x)));
tempT1 += (-(1.0/this.listaDadosRegressao.size()) * (d.y - this.retornarPredicao(d.x)) * d.x);
}        
this.t0 -= tempT0 * this.taxaAprendizado;
this.t1 -= tempT1 * this.taxaAprendizado;

i++;            
}
}

public double getT0() {
return t0;
}

public void setT0(double t0) {
this.t0 = t0;
}

public double getT1() {
return t1;
}

public void setT1(double t1) {
this.t1 = t1;
}    
}
