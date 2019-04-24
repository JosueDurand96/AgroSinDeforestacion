package agrosindeforestacion.com.agrosindeforestacion.model;

public class nthc_persona {
    public String id_nthc_persona;
    public String nombres;
    public String correo;
    public String dni;
    public String password;
    public String apellido_paterno;
    public String apellido_materno;
    public String predio;

    public String getId_nthc_persona() {
        return id_nthc_persona;
    }

    public void setId_nthc_persona(String id_nthc_persona) {
        this.id_nthc_persona = id_nthc_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }
}
