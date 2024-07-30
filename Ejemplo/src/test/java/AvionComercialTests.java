import org.example.AvionComercial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvionComercialTests {
    private AvionComercial avion1 = new AvionComercial(100, 100);

    int cantidad;
    int distancia = 300;

    @Test
    public void testVolar() {
        cantidad = avion1.volar(distancia);
        Assertions.assertEquals(cantidad, 30000);
    }
}
