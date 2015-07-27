package movil.salt.dbsugarorm.Entidades;

import com.orm.SugarRecord;

/**
 * Created by pc on 23/07/2015.
 */
public class Cereal extends SugarRecord {

    String nombre,gramos;

    public Cereal() {
    }

    public Cereal(String nombre, String gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGramos() {
        return gramos;
    }

    public void setGramos(String gramos) {
        this.gramos = gramos;
    }
}
