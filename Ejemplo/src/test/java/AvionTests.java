import org.example.Avion;
import org.example.AvionComercial;
import org.example.AvionPrivado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvionTests {
    private AvionComercial avion1 = new AvionComercial(100, 100);
    int cantidad;

    @Test
    public void testGetCapacidadCombustible() {
        cantidad = avion1.getCapacidadCombustible();
        Assertions.assertEquals(cantidad, 100);
    }

    @Test
    public void testGetConsumoCombustible() {
        cantidad = avion1.getConsumoCombustible();
        Assertions.assertEquals(cantidad, 100);
    }

}
