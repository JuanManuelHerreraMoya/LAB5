
package edu.eci.cvds.servlet;

import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;
import java.util.*;


@ManagedBean(name = "guessBean")
@ApplicationScoped
@SessionScoped 
public class Game {
    
    
    private int puntaje;
    private boolean estadoJuego;
    private Random alea ;
    private int numeroGen;
    private int numeroInt;
	private String ganaste;
	private ArrayList<Integer> intentos;
    public Game(){
        puntaje = 100000;
        estadoJuego = false;
        numeroInt = 0;
        alea = new Random();
        aleatorio();
		intentos = new ArrayList<Integer>();
    }
    private void aleatorio() {
    	numeroGen = alea.nextInt(10);
    }
	public int getNumeroGenerado(){
		return numeroGen;
	}
    public int getPuntaje(){
        return puntaje;
    }
    public int getNumeroIntentos(){
        return numeroInt;
    }
    public ArrayList<Integer> getIntentos(){
		return intentos;
	}
	
    public void setPuntaje(){
        puntaje = puntaje-10000;
    }
    public void setNumeroIntentos(int value){
        numeroInt = value;
    }
    public void setEstado(){
        estadoJuego = !estadoJuego;
    }
    public String getEstado(){
    	ganaste = "Ganaste tu puntaje es : "+puntaje;
    	if (estadoJuego) return ganaste;
        return "Estas jugando!!";
    }
    public boolean getEstadoJuego() {
    	return estadoJuego;
    }
    public int getNumeroAleatorio(){
        return numeroGen;
    }
	
    private void perdiste() {
    	estadoJuego = false;
    	puntaje = 0;
    }
    public void restart() {
    	puntaje = 100000;
    	estadoJuego = false;
    	aleatorio();
    	numeroInt = 0;
		intentos.clear();
    }
    public void guess(int ingresado){
        if (ingresado == numeroGen){
            estadoJuego = true;
        }
        else{
        	setPuntaje();
        	if (puntaje <= 0 ) {
        		perdiste();
        	}
            numeroInt += 1;
			intentos.add(ingresado);
        }
    }
    
}