package Negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Medicamento {
    private String nome;
    private String principioAtivo;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private String unidadeFarmaco;
    private String registroMs;
    private Integer id;
    public static Integer  proximoIdMedicamento = 1;

    SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy");

    public Medicamento(String nome, String principioAtivo, LocalDate dataFabricacao,LocalDate dataValidade , Integer id,String unidadeFarmaco,String registroMs) {
        this.setNome(nome);
        this.setPrincipioAtivo(principioAtivo);
        this.setDataFabricacao(dataFabricacao);
        this.setDataValidade(dataValidade);
        this.setId(id);
        this.setUnidadeFarmaco(unidadeFarmaco);
        this.setRegistroMs(registroMs);
    }

    public Medicamento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static int getProximoIdMedicamento(){
        return proximoIdMedicamento++;
    }

    public String getUnidadeFarmaco() {
        return unidadeFarmaco;
    }

    public void setUnidadeFarmaco(String unidadeFarmaco) {
        this.unidadeFarmaco = unidadeFarmaco;
    }

    public String getRegistroMs() {
        return registroMs;
    }

    public void setRegistroMs(String registroMs) {
        this.registroMs = registroMs;
    }

    public static void setProximoIdMedicamento(Integer proximoIdMedicamento) {
        Medicamento.proximoIdMedicamento = proximoIdMedicamento;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return  "\nMedicamento ='" + nome + '\'' +
                ", Principio Ativo ='" + principioAtivo + '\'' +
                ", Fabricacao ='" +dataFabricacao + '\'' +
                ", Validade ='" + dataValidade;
    }
}

