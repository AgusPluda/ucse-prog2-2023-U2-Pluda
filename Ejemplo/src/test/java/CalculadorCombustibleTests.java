import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.CalculadorCombustible;
import org.example.AvionComercial;

public class CalculadorCombustibleTests {
    private AvionComercial avion1 = new AvionComercial(100, 100);
    private CalculadorCombustible calculador;
    int cantidad;
    int distancia = 300;

    @Test
    public void testCacularCombustible() {
        cantidad = calculador.calcularCombustible(avion1, distancia);
        Assertions.assertEquals(cantidad, 30000);
    }
}
