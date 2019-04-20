package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.opet.model.Especialidade;

public class EspecialidadeDAO {

	private final String INSERT = "INSERT INTO ESPECIALIDADE (ID_ESPECIALIDADE, DESCRICAO) VALUES (SEQ_ESPECIALIDADE.NEXTVAL,?)";

	private final String UPDATE = "UPDATE ESPECIALIDADE SET DESCRICAO = ? WHERE ID_ESPECIALIDADE = ?";

	private final String DELETE = "DELETE FROM ESPECIALIDADE WHERE ID_ESPECIALIDADE = ?";

	private final String SELECT_GET = "SELECT ID_ESPECIALIDADE, DESCRICAO FROM ESPECIALIDADE WHERE ID_ESPECIALIDADE = ?";

	private final String SELECT_LIST = "SELECT ID_ESPECIALIDADE, DESCRICAO FROM ESPECIALIDADE";

	public boolean salvar(Especialidade espTMP) {
		Connection conn = Conexao.getConexao();
		PreparedStatement ps = null;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, espTMP.getDescricao());
			int rows = ps.executeUpdate();
			if (rows != 1) {
				System.err.println("Número de linha diferente de 1");
				conn.rollback();
				return false;
			}
			conn.commit();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean atualizar(Especialidade espTMP) {
		Connection conn = Conexao.getConexao();
		PreparedStatement ps = null;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, espTMP.getDescricao());
			ps.setInt(2, espTMP.getId());
			int rows = ps.executeUpdate();
			if (rows != 1) {
				System.err.println("Número de linha diferente de 1");
				conn.rollback();
				return false;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean excluir(int id) {
		Connection conn = Conexao.getConexao();
		PreparedStatement ps = null;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(DELETE);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if (rows != 1) {
				System.err.println("Número de linha diferente de 1");
				conn.rollback();
				return false;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	protected Especialidade recuperar(int id_especialidade) {
		Connection conn = Conexao.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Especialidade espTMP = new Especialidade();

		try {
			ps = conn.prepareStatement(SELECT_GET);
			ps.setInt(1, id_especialidade);
			rs = ps.executeQuery();

			boolean isFilled = false;
			while (rs.next()) {
				espTMP.setId(rs.getInt("ID_ESPECIALIDADE"));
				espTMP.setDescricao(rs.getString("DESCRICAO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return espTMP;
	}

	public HashMap<Integer, Especialidade> list() {
		Connection conn = Conexao.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap<Integer, Especialidade> hEsp = new HashMap<Integer, Especialidade>();

		try {
			ps = conn.prepareStatement(SELECT_LIST);
			rs = ps.executeQuery();

			while (rs.next()) {
				Especialidade espTMP = new Especialidade();
				espTMP.setId(rs.getInt("ID_ESPECIALIDADE"));
				espTMP.setDescricao(rs.getString("DESCRICAO"));
				hEsp.put(espTMP.getId(), espTMP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return hEsp;
	}
}