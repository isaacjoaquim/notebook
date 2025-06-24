/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author gelad
 */
public class Aluno {
    private int idAlu;
    private String nomeAlu;
    private String sobrenomeAlu;
    private String dataNascAlu;
    private String cpfAlu;
    private String rgAlu;
    private String cargo;
    private String sexoAlu;
    private String emailAlu;
    private String telefone1Alu;
    private String telefone2Alu;

    public Aluno(String nomeAlu, String sobrenomeAlu, String dataNascAlu, String cpfAlu, String rgAlu, String cargo, String sexoAlu, String emailAlu, String telefone1Alu, String telefone2Alu) {
        this.nomeAlu = nomeAlu;
        this.sobrenomeAlu = sobrenomeAlu;
        this.dataNascAlu = dataNascAlu;
        this.cpfAlu = cpfAlu;
        this.rgAlu = rgAlu;
        this.cargo = cargo;
        this.sexoAlu = sexoAlu;
        this.emailAlu = emailAlu;
        this.telefone1Alu = telefone1Alu;
        this.telefone2Alu = telefone2Alu;
    }

   
    
    
    public int getIdAlu() {
        return idAlu;
    }

    public void setIdAlu(int idAlu) {
        this.idAlu = idAlu;
    }

    public String getNomeAlu() {
        return nomeAlu;
    }

    public void setNomeAlu(String nomeAlu) {
        this.nomeAlu = nomeAlu;
    }

    public String getSobrenomeAlu() {
        return sobrenomeAlu;
    }

    public void setSobrenomeAlu(String sobrenomeAlu) {
        this.sobrenomeAlu = sobrenomeAlu;
    }

    public String getDataNascAlu() {
        return dataNascAlu;
    }

    public void setDataNascAlu(String dataNascAlu) {
        this.dataNascAlu = dataNascAlu;
    }

    public String getCpfAlu() {
        return cpfAlu;
    }

    public void setCpfAlu(String cpfAlu) {
        this.cpfAlu = cpfAlu;
    }

    public String getRgAlu() {
        return rgAlu;
    }

    public void setRgAlu(String rgAlu) {
        this.rgAlu = rgAlu;
    }

    public String getSexoAlu() {
        return sexoAlu;
    }

    public void setSexoAlu(String sexoAlu) {
        this.sexoAlu = sexoAlu;
    }

    public String getEmailAlu() {
        return emailAlu;
    }

    public void setEmailAlu(String emailAlu) {
        this.emailAlu = emailAlu;
    }

    public String getTelefone1Alu() {
        return telefone1Alu;
    }

    public void setTelefone1Alu(String telefone1Alu) {
        this.telefone1Alu = telefone1Alu;
    }

    public String getTelefone2Alu() {
        return telefone2Alu;
    }

    public void setTelefone2Alu(String telefone2Alu) {
        this.telefone2Alu = telefone2Alu;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
