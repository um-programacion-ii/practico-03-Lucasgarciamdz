package src.main.um.entidades;

import src.main.um.excepciones.StockInsuficiente;
import src.main.um.excepciones.VidaUtilInsuficiente;
import src.main.um.services.CocinaService;

import java.util.concurrent.Callable;

public class Chef implements Callable {

  String nombre;
  int estrellasMichelin;
  Despensa despensa;
  CocinaService cocina;
  RecetaBase receta;

  public Chef(String nombre, int estrellasMichelin, Despensa despensa, RecetaBase receta) {
    this.nombre = nombre;
    this.estrellasMichelin = estrellasMichelin;
    this.despensa = despensa;
    this.cocina = CocinaService.getInstance();
    this.receta = receta;
  }

  public Chef() {}


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEstrellasMichelin() {
    return estrellasMichelin;
  }

  public void setEstrellasMichelin(int estrellasMichelin) {
    this.estrellasMichelin = estrellasMichelin;
  }

  public Despensa getDespensa() {
    return despensa;
  }

  public void setDespensa(Despensa despensa) {
    this.despensa = despensa;
  }

  public CocinaService getCocina() {
    return cocina;
  }

  public void setCocina(CocinaService cocina) {
    this.cocina = cocina;
  }

  public RecetaBase getReceta() {
    return receta;
  }

  public void setReceta(RecetaBase receta) {
    this.receta = receta;
  }



  public String cocinar(CocinaService cocina, RecetaBase receta) throws VidaUtilInsuficiente, StockInsuficiente, InterruptedException {
    System.out.println("Hola soy " + this);
    Thread.sleep(receta.getTiempoCoccion() * 1000);
    return cocina.cocinar(receta, this.despensa);
  }

  @Override
  public String toString() {
    return "Chef: " + nombre + ", Estrellas Michelin: " + estrellasMichelin;
  }

  @Override
  public String call() throws Exception {
    return cocinar(cocina, receta);
  }
}
