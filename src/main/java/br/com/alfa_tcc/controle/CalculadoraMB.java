package br.com.alfa_tcc.controle;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.alfa_tcc.bean.Calculadora;

@ManagedBean(name = "CalculadoraMB")
@RequestScoped
public class CalculadoraMB {
	
	private Calculadora bean;
	private String expressao = "";
	
	public CalculadoraMB(){
		this.bean = new Calculadora();
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	
	public Calculadora getBean() {
		return bean;
	}

	public void setBean(Calculadora bean) {
		this.bean = bean;
	}
	
	public String resultado() {
        return "resultado";
    } 
	public String calc() {
		this.bean = new Calculadora();
        return "index";
    } 
	
	public void ajustarValores() {
		
		String valor = this.getExpressao();
		
		double n1 = 0;
		double n2 = 0;
		
		if(valor.contains("+")) {
					
			String[] valores = valor.split(Pattern.quote("+"));
			
			n1 = Double.parseDouble(valores[0]);
			n2 = Double.parseDouble(valores[1]);
			bean.setOperador('+');
		}
		
		if(valor.contains("-")) {
			
			String[] valores = valor.split(Pattern.quote("-"));
			
			n1 = Double.parseDouble(valores[0]);
			n2 = Double.parseDouble(valores[1]);
			bean.setOperador('-');
		}
		
		if(valor.contains("*")) {
			
			String[] valores = valor.split(Pattern.quote("*"));
			
			n1 = Double.parseDouble(valores[0]);
			n2 = Double.parseDouble(valores[1]);
			bean.setOperador('*');
		}
		
		if(valor.contains("/")) {
			
			String[] valores = valor.split(Pattern.quote("/"));
			
			n1 = Double.parseDouble(valores[0]);
			n2 = Double.parseDouble(valores[1]);
			bean.setOperador('/');
		}
		
		bean.setN1(n1);
		bean.setN2(n2);
	}
	
	public String calcularExpressao() {

		this.ajustarValores();
		
		this.setExpressao(String.valueOf(this.calcular()));
		
		return "index";
	}
	
	public double calcular() {

		double result = 0.0;
		
		if (bean.getOperador() == '+') {
			result = bean.getN1() + bean.getN2();
		} else if (bean.getOperador() == '-') {
			result = bean.getN1() - bean.getN2();
		} else if (bean.getOperador() == '/') {
			result = bean.getN1() / bean.getN2();
		} else if (bean.getOperador() == '*') {
			result = bean.getN1() * bean.getN2();
		} 
		
		return result;
	}
}
