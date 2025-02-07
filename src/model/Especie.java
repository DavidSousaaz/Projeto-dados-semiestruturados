package model;

public class Especie {
	
	private int id;
    private String especie;
    private String nomeComum;
    private String grupo;
    private String mesAnoAvaliacao;
    private String bioma;
    private String baciaHidrografica;
    private String riscoExtincao;

    public Especie(int id, String especie, String nomeComum, String grupo, String mesAnoAvaliacao, String bioma, String baciaHidrografica, String riscoExtincao) {
        this.id = id;
        this.especie = especie;
        this.nomeComum = nomeComum;
        this.grupo = grupo;
        this.mesAnoAvaliacao = mesAnoAvaliacao;
        this.bioma = bioma;
        this.baciaHidrografica = baciaHidrografica;
        this.riscoExtincao = riscoExtincao;
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
                ", categoria='" + riscoExtincao + '\'' +
                '}';
    }

	public int getId() {
		return id;
	}

	public String getEspecie() {
		return especie;
	}

	public String getNomeComum() {
		return nomeComum;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getMesAnoAvaliacao() {
		return mesAnoAvaliacao;
	}

	public String getBioma() {
		return bioma;
	}

	public String getBaciaHidrografica() {
		return baciaHidrografica;
	}

	public String getRiscoExtincao() {
		return riscoExtincao;
	}
	
	
    
    

}
