package com.mack.clinica.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mack.clinica.util.DatabaseConnection;


public class AgendarConsultaDAO {

    private String realPathBase;

    public AgendarConsultaDAO(String realPathBase) {
        this.realPathBase = realPathBase;
    }

    public boolean agendarConsulta(int pacienteId, int profissionalId, String dataHora) {
        String sql = "INSERT INTO consultas (paciente_id, profissional_id, data_hora, status, observacoes) VALUES (?, ?, ?, 'agendada', '')";

        try (Connection conn = DatabaseConnection.getConnection(realPathBase)) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pacienteId);
            stmt.setInt(2, profissionalId);
            stmt.setString(3, dataHora);
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("entrou aqui");
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> listarMedicos() {
        List<Usuario> medicos = new ArrayList<>();
        String sql = "SELECT id, nome FROM usuarios WHERE tipo = 'medico'";
    
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                medicos.add(u);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar médicos: " + e.getMessage());
        }
    
        return medicos;
    }
    
    public static List<Consulta> buscarPorPaciente(int pacienteId, String realPath) {
        List<Consulta> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(realPath)) {
            String sql = """
                        SELECT c.data_hora, c.status, u.nome AS medico_nome
                        FROM consultas c
                        JOIN usuarios u ON c.profissional_id = u.id
                        WHERE c.paciente_id = ?
                        ORDER BY c.data_hora
                    """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();

            // formatando a data e hora
            DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");
            
            while (rs.next()) {
                Consulta c = new Consulta();

                String dataHoraOriginal = rs.getString("data_hora");

                // Converte e formata data/hora
                LocalDateTime dt = LocalDateTime.parse(dataHoraOriginal);
                c.setDataFormatada(dt.format(dataFormatter));
                c.setHoraFormatada(dt.format(horaFormatter));

                // c.setDataHora(rs.getString("data_hora")); Data hora original
                c.setNomeMedico(rs.getString("medico_nome"));
                c.setStatus(rs.getString("status"));
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar consultas do paciente.", e);
        }
        return lista;
    }
}
