package kawakuticode.lagos.webservice;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.postgresql.util.PGobject;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

@Path("/")
public class Resources {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Hello, naija websersice";
	}

	@GET
	@Path("/games")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGamesJson() throws ClassNotFoundException, SQLException {

		String resultset = "";
		Connection dbConnection = null;
		Statement stmt = null;

		String selectTableSQL = "select array_to_json(array_agg(row_to_json(t)))from (select * from tb_games) t";

		try {
			dbConnection = ConnectFactory.getLocalConnection();
			stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(selectTableSQL);
			rs.first();
			if (rs.getString("array_to_json") != null) {
				JsonArray jsonArray = (JsonArray) new JsonParser().parse(rs.getString("array_to_json"));
				resultset = jsonArray.toString();
				System.out.println("my set games" + resultset);
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			resultset = null;

		} finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return resultset;
	}

	@GET
	@Path("/events")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEventsJson() throws ClassNotFoundException, SQLException {

		Connection dbConnection = null;
		Statement stmt = null;
		String resultset = "";

		String selectTableSQL = "SELECT array_to_json(array_agg(row_to_json(t)))from (select * from tb_events) t";

		try {
			dbConnection = ConnectFactory.getLocalConnection();
			stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(selectTableSQL);
			rs.first();
			if (rs.getString("array_to_json") != null) {

				JsonArray jsonArray = (JsonArray) new JsonParser().parse(rs.getString("array_to_json"));
				resultset = jsonArray.toString();
				System.out.println("my set events" + resultset);
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			resultset = null;

		} finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return resultset;
	}

	@POST
	@Path("/inputevent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int inputgame(String inputJson) throws ClassNotFoundException, SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO tb_events" + "(event_content) VALUES" + "(?)";

		try {

			dbConnection = ConnectFactory.getLocalConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			PGobject jsonOb = new PGobject();
			jsonOb.setType("json");
			jsonOb.setValue(inputJson);
			preparedStatement.setObject(1, jsonOb);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into events table!");

			return 1;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return 0;
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	@POST
	@Path("/inputgame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int inputevent(String inputJson) throws SQLException, ClassNotFoundException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO tb_games" + "(game_content) VALUES" + "(?)";

		try {

			dbConnection = ConnectFactory.getLocalConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			PGobject jsonOb = new PGobject();
			jsonOb.setType("json");
			jsonOb.setValue(inputJson);
			preparedStatement.setObject(1, jsonOb);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into games table!");

			return 1;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return 0;
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}

	@GET
	@Path("/addevent")
	@Produces(MediaType.TEXT_HTML)
	public InputStream viewAddEvent() throws ClassNotFoundException, SQLException, FileNotFoundException {
		return Resources.class.getResourceAsStream("/addevent.html");
	}

	@GET
	@Path("/addgame")
	@Produces(MediaType.TEXT_HTML)
	public InputStream viewAddGameContentJson() {
		return Resources.class.getResourceAsStream("/addgame.html");
	}

}
