package br.com.embravix.encontrecasa.models;

@MappedSuperclass
public abstract class Pessoa {

    private Long id;
    private String documento;
    private String nome;
    //private
}
