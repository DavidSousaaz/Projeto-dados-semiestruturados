package model;

public class Especie {
	
	private int id;
    private String especie;
    private String nomeComum;
    private String grupo;
    private String mesAnoAvaliacao;
    private String bioma;
    private String baciaHidrografica;

    public Especie(int id, String especie, String nomeComum, String grupo, String mesAnoAvaliacao, String bioma, String baciaHidrografica) {
        this.id = id;
        this.especie = especie;
        this.nomeComum = nomeComum;
        this.grupo = grupo;
        this.mesAnoAvaliacao = mesAnoAvaliacao;
        this.bioma = bioma;
        this.baciaHidrografica = baciaHidrografica;
    }

    @Override
    public String toString() {
        return "Especie{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", nomeComum='" + nomeComum + '\'' +
                ", grupo='" + grupo + '\'' +
                ", mesAnoAvaliacao='" + mesAnoAvaliacao + '\'' +
                ", bioma='" + bioma + '\'' +
                ", baciaHidrografica='" + baciaHidrografica + '\'' +
                '}';
    }

}
