package src.main.um.services;

import src.main.um.entidades.Despensa;
import src.main.um.entidades.RecetaBase;
import src.main.um.excepciones.StockInsuficiente;
import src.main.um.excepciones.VidaUtilInsuficiente;

public class CocinaService {
  private static CocinaService instance = null;

  public static CocinaService getInstance() {
    if (instance == null) {
      instance = new CocinaService();
    }
    return instance;
  }


  public CocinaService() {

  }

  public String cocinar(RecetaBase receta, Despensa despensa) throws VidaUtilInsuficiente, StockInsuficiente {
    if (receta.sePuedeCocinar(despensa)) {
      System.out.println("Cocinando: \n");
      System.out.println(receta.getPreparacion() + "\n");
      for (int i = 0; i < receta.getIngredientes().size(); i++) {
        if (receta.getIngredientes().get(i) != null) {
          despensa.getDespensable(
              receta.getIngredientes().get(i).getNombre(),
              receta.getIngredientes().get(i).getCantidad());
        }
      }

      for (int i = 0; i < receta.getUtensilios().size(); i++) {
        if (receta.getUtensilios().get(i) != null) {
          despensa.getDespensable(
              receta.getUtensilios().get(i).getNombre(),
              receta.getUtensilios().get(i).getVidaUtil());
        }
      }
      return "Se ha cocinado la receta";
    } else {
      return "No se puede cocinar la receta "
          + receta.getClass().getSimpleName()
          + "\n"
          + receta.queFalta(despensa);
    }
  }
}
