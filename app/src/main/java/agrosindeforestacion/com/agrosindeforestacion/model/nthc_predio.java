package agrosindeforestacion.com.agrosindeforestacion.model;

public class nthc_predio {
    public String id_nthc_predio;
    public  String fecha_registro;
    public  String PUNTOS_POLIGONO_id_puntos_poligono;
    public  String NTHC_PERSONA_id_nthc_persona;

    public String getId_nthc_predio() {
        return id_nthc_predio;
    }

    public void setId_nthc_predio(String id_nthc_predio) {
        this.id_nthc_predio = id_nthc_predio;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getPUNTOS_POLIGONO_id_puntos_poligono() {
        return PUNTOS_POLIGONO_id_puntos_poligono;
    }

    public void setPUNTOS_POLIGONO_id_puntos_poligono(String PUNTOS_POLIGONO_id_puntos_poligono) {
        this.PUNTOS_POLIGONO_id_puntos_poligono = PUNTOS_POLIGONO_id_puntos_poligono;
    }

    public String getNTHC_PERSONA_id_nthc_persona() {
        return NTHC_PERSONA_id_nthc_persona;
    }

    public void setNTHC_PERSONA_id_nthc_persona(String NTHC_PERSONA_id_nthc_persona) {
        this.NTHC_PERSONA_id_nthc_persona = NTHC_PERSONA_id_nthc_persona;
    }
}
