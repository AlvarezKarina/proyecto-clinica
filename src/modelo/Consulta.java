package modelo;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author herna
 */
public class Consulta {
    private int numConsulta;
    //private Doc_Especialidad objDoctor;
    private Date fecha_consulta;
    private String consultaPor;
    private String presentaEnfermedad;
    private String diagnostico;
    private Date citaControl;
    private Date citaSeguimiento;
    private ArrayList<Referencia> referencia;
    private Antecedente objAntecedente;
    private Hoja_Inscripcion objInscripcion;
    private Hoja_Enfermeria objEnfermeria;

    public Consulta() {
    }

    public Consulta(int numConsulta) {
        this.numConsulta = numConsulta;
    }

    public Consulta(Doc_Especialidad objDoctor, Date fecha_consulta, String consultaPor, String presentaEnfermedad, String diagnostico, Date citaControl, Date citaSeguimiento, Antecedente objAntecedente, Hoja_Inscripcion objInscripcion, Hoja_Enfermeria objEnfermeria) {
        this.objDoctor = objDoctor;
        this.fecha_consulta = fecha_consulta;
        this.consultaPor = consultaPor;
        this.presentaEnfermedad = presentaEnfermedad;
        this.diagnostico = diagnostico;
        this.citaControl = citaControl;
        this.citaSeguimiento = citaSeguimiento;
        this.objAntecedente = objAntecedente;
        this.objInscripcion = objInscripcion;
        this.objEnfermeria = objEnfermeria;
    }

    public Consulta(int numConsulta, Doc_Especialidad objDoctor, Date fecha_consulta, String consultaPor, String presentaEnfermedad, String diagnostico, Date citaControl, Date citaSeguimiento, Antecedente objAntecedente, Hoja_Inscripcion objInscripcion, Hoja_Enfermeria objEnfermeria) {
        this.numConsulta = numConsulta;
        this.objDoctor = objDoctor;
        this.fecha_consulta = fecha_consulta;
        this.consultaPor = consultaPor;
        this.presentaEnfermedad = presentaEnfermedad;
        this.diagnostico = diagnostico;
        this.citaControl = citaControl;
        this.citaSeguimiento = citaSeguimiento;
        this.objAntecedente = objAntecedente;
        this.objInscripcion = objInscripcion;
        this.objEnfermeria = objEnfermeria;
    }

    public int getNumConsulta() {
        return numConsulta;
    }

    public void setNumConsulta(int numConsulta) {
        this.numConsulta = numConsulta;
    }

    public Doc_Especialidad getObjDoctor() {
        return objDoctor;
    }

    public void setObjDoctor(Doc_Especialidad objDoctor) {
        this.objDoctor = objDoctor;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getConsultaPor() {
        return consultaPor;
    }

    public void setConsultaPor(String consultaPor) {
        this.consultaPor = consultaPor;
    }

    public String getPresentaEnfermedad() {
        return presentaEnfermedad;
    }

    public void setPresentaEnfermedad(String presentaEnfermedad) {
        this.presentaEnfermedad = presentaEnfermedad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getCitaControl() {
        return citaControl;
    }

    public void setCitaControl(Date citaControl) {
        this.citaControl = citaControl;
    }

    public Date getCitaSeguimiento() {
        return citaSeguimiento;
    }

    public void setCitaSeguimiento(Date citaSeguimiento) {
        this.citaSeguimiento = citaSeguimiento;
    }

    public Antecedente getObjAntecedente() {
        return objAntecedente;
    }

    public void setObjAntecedente(Antecedente objAntecedente) {
        this.objAntecedente = objAntecedente;
    }

    public Hoja_Inscripcion getObjInscripcion() {
        return objInscripcion;
    }

    public void setObjInscripcion(Hoja_Inscripcion objInscripcion) {
        this.objInscripcion = objInscripcion;
    }

    public Hoja_Enfermeria getObjEnfermeria() {
        return objEnfermeria;
    }

    public void setObjEnfermeria(Hoja_Enfermeria objEnfermeria) {
        this.objEnfermeria = objEnfermeria;
    }
    
    
    
    
    
    
    
}
