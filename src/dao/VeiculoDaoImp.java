package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.DatabaseConnection;
import model.Veiculo;
import servicos.EnumStatusVeiculo;

public class VeiculoDaoImp implements VeiculoDao {

	@Override
	public void adicionar(Veiculo v) throws ClassNotFoundException, SQLException {

		Connection con = DatabaseConnection.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO tb_veiculo (placa, marca, modelo, ano_fab, ano_mod, ");
		sb.append("status)");
		sb.append("VALUES (?, ?, ?, ?, ?, ?)");

		PreparedStatement st = con.prepareStatement(sb.toString());
		st.setString(1, v.getPlaca());
		st.setString(2, v.getMarca());
		st.setString(3, v.getModelo());
		st.setString(4, v.getAnoFabricacao());
		st.setString(5, v.getAnoModelo());
		st.setString(6, EnumStatusVeiculo.DISPONIVEL.toString());

		st.executeUpdate();
		con.close();

	}

	@Override
	public void alterar(Veiculo v) throws ClassNotFoundException, SQLException {
		{
			Connection con = DatabaseConnection.getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE tb_veiculo SET marca = ?, modelo = ?, ano_fab = ?, ano_mod = ?, ");
			sb.append("status = ? ");
			sb.append("WHERE placa = ?");

			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, v.getMarca());
			st.setString(2, v.getModelo());
			st.setString(3, v.getAnoFabricacao());
			st.setString(4, v.getAnoModelo());
			st.setString(5, v.getStatus());
			st.setString(6, v.getPlaca());

			st.executeUpdate();
			con.close();
		}

	}

	@Override
	public void remover(Veiculo v) throws ClassNotFoundException, SQLException {

		Connection con = DatabaseConnection.getConnection();
		String sql = "DELETE FROM tb_veiculo WHERE placa = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, v.getPlaca());
		st.executeUpdate();
		con.close();

	}

	@Override
	public Veiculo buscarPorPlaca(String placa) throws ClassNotFoundException, SQLException {
		Veiculo v = null;

		Connection con = DatabaseConnection.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT placa, marca, modelo, ano_fab, ano_mod, ");
		sb.append("status FROM tb_veiculo WHERE placa = ?");

		PreparedStatement st = con.prepareStatement(sb.toString());
		st.setString(1, placa);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			v = new Veiculo();
			v.setPlaca(rs.getString("placa"));
			v.setMarca(rs.getString("marca"));
			v.setModelo(rs.getString("modelo"));
			v.setAnoFabricacao(rs.getString("ano_fab"));
			v.setAnoModelo(rs.getString("ano_mod"));
			v.setStatus(rs.getString("status"));

		}
		con.close();

		return v;

	}

	@Override
	public List<Veiculo> listarPorStatus(String t) throws ClassNotFoundException, SQLException {
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

		Connection con = DatabaseConnection.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT placa, marca, modelo, ano_fab, ano_mod, ");
		sb.append("status FROM tb_veiculo WHERE status = ?");

		PreparedStatement st = con.prepareStatement(sb.toString());
		st.setString(1, t);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setPlaca(rs.getString("placa"));
			v.setMarca(rs.getString("marca"));
			v.setModelo(rs.getString("modelo"));
			v.setAnoFabricacao(rs.getString("ano_fab"));
			v.setAnoModelo(rs.getString("ano_mod"));
			v.setStatus(rs.getString("status"));
			listaVeiculos.add(v);
		}
		con.close();

		return listaVeiculos;
	}

	public List<Veiculo> listar() throws ClassNotFoundException, SQLException {

		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

		Connection con = DatabaseConnection.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT placa, marca, modelo, ano_fab, ano_mod, ");
		sb.append("status FROM tb_veiculo");

		PreparedStatement st = con.prepareStatement(sb.toString());

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setPlaca(rs.getString("placa"));
			v.setMarca(rs.getString("marca"));
			v.setModelo(rs.getString("modelo"));
			v.setAnoFabricacao(rs.getString("ano_fab"));
			v.setAnoModelo(rs.getString("ano_mod"));
			v.setStatus(rs.getString("status"));
			listaVeiculos.add(v);
		}
		con.close();

		return listaVeiculos;
	}

}
