package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Especie;

public class EspecieDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/ecobase";
    private static final String USER = "root";
    private static final String PASSWORD = "Deda.6869";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    public static List<Especie> buscarTodasEspecies() {
        List<Especie> especies = new ArrayList<>();
        String sql = "SELECT * FROM tb_especies";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                especies.add(new Especie(
                    rs.getInt("id"),
                    rs.getString("especie"),
                    rs.getString("nome_comum") != null ? rs.getString("nome_comum").replace("'", ", ") : "Não Consta",
                    rs.getString("grupo"),
                    rs.getString("mes_ano_avaliacao"),
                    rs.getString("bioma") != null ? rs.getString("bioma").replace("'", ", ") : "Não Consta",
                    rs.getString("bacia_hidrografica") != null ? rs.getString("bacia_hidrografica").replace("'", ", ") : "Não Consta",
                    rs.getString("risco_extincao") != null ? rs.getString("risco_extincao") : "Desconhecido"
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especies;
    }


    public static List<Especie> buscarEspeciesPorGrupo(String grupo) {
        List<Especie> especies = new ArrayList<>();
        String sql = "SELECT * FROM tb_especies WHERE grupo = ?";
        
        

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, grupo);
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                especies.add(new Especie(
                        rs.getInt("id"),
                        rs.getString("especie"),
                        rs.getString("nome_comum") != null ? rs.getString("nome_comum").replace("'", ", ") : "Não Consta",
                        rs.getString("grupo"),
                        rs.getString("mes_ano_avaliacao"),
                        rs.getString("bioma") != null ? rs.getString("bioma").replace("'", ", ") : "Não Consta",
                        rs.getString("bacia_hidrografica") != null ? rs.getString("bacia_hidrografica").replace("'", ", ") : "Não Consta",
                        rs.getString("risco_extincao") != null ? rs.getString("risco_extincao") : "Desconhecido"
                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especies;
    }

}
