package src.main.um.recetas;

import java.util.List;
import src.main.um.entidades.Ingrediente;
import src.main.um.entidades.RecetaBase;
import src.main.um.entidades.Utensilio;

public class Espaguetis extends RecetaBase {
  public Espaguetis() {
    super(
        20,
        List.of(
            new Ingrediente("Espaguetis", 100),
            new Ingrediente("Salsa de Tomate", 100),
            new Ingrediente("Sal", 1)),
        List.of(
new Utensilio("Olla", 1),
            new Utensilio("Cuchara de Madera", 1),
            new Utensilio("Colador", 1)
        ),
        "Cocina los espaguetis, calienta la salsa, mezcla todo, añade sal al gusto.");
  }
}
