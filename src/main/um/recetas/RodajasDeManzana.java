package src.main.um.recetas;

import java.util.List;
import src.main.um.entidades.Ingrediente;
import src.main.um.entidades.RecetaBase;
import src.main.um.entidades.Utensilio;

public class RodajasDeManzana extends RecetaBase {
  public RodajasDeManzana() {
    super(2, List.of(new Ingrediente("Manzana", 1)),
            List.of(new Utensilio(
                "Tabla para cortar", 1),
                new Utensilio("Cuchillo", 1
            ))
            ,"Corta la manzana en rodajas.");
  }
}
