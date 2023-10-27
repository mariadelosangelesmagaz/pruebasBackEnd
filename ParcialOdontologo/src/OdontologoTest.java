import dao.DB;
import dao.OdontologoIDaoH2;
import model.Odontologo;
import org.junit.Assert;
import org.junit.Test;
import service.OdontologoService;

public class OdontologoTest {

    @Test
    public void testeoDeListadoDeOdontologos(){
        DB.crearTablaOdontologo();
        OdontologoService servicio = new OdontologoService(new OdontologoIDaoH2());

        Odontologo od1 = new Odontologo(12, "Angeles", "Magaz");
        Odontologo od2 = new Odontologo(15, "Facundo", "Anellini");

        String resultadoEsperado = "Odontologo{numeroMatricula=12, nombre='Angeles', apellido='Magaz'}Odontologo{numeroMatricula=15, nombre='Facundo', apellido='Anellini'}";

        servicio.guardar(od1);
        servicio.guardar(od2);

        Assert.assertEquals(resultadoEsperado, servicio.listarOdontologos());

    }


}
