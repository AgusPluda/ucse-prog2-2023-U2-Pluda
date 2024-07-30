import org.example.AvionPrivado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvionPrivadoTests {
    private AvionPrivado avion1 = new AvionPrivado(100, 100);

    int cantidad;
    int distancia = 300;

    @Test
    public void testVolar() {
        cantidad = avion1.volar(distancia);
        Assertions.assertEquals(cantidad, 30050);
    }
}
