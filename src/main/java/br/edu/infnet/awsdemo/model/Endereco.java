package br.edu.infnet.awsdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "cep", "logradouro", "bairro", "localidade", "uf", "erro" })
public class Endereco {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("localidade")
    private String localidade;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("erro")
    private Boolean erro = false;

    public Endereco() {
    }

    @JsonProperty("cep")
    public String getCep() {
        return cep;
    }

    @JsonProperty("cep")
    public void setCep(String cep) {
        this.cep = cep;
    }

    @JsonProperty("logradouro")
    public String getLogradouro() {
        return logradouro;
    }

    @JsonProperty("logradouro")
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @JsonProperty("bairro")
    public String getBairro() {
        return bairro;
    }

    @JsonProperty("bairro")
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @JsonProperty("localidade")
    public String getLocalidade() {
        return localidade;
    }

    @JsonProperty("localidade")
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @JsonProperty("uf")
    public String getUf() {
        return uf;
    }

    @JsonProperty("uf")
    public void setUf(String uf) {
        this.uf = uf;
    }

    @JsonProperty("erro")
    public Boolean getErro() {
        return erro;
    }

    @JsonProperty("erro")
    public void setErro(Boolean erro) {
        this.erro = erro;
    }
}
