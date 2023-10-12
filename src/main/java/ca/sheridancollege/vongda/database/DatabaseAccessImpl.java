/*
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.vongda.beans.PasswordRecord;

@Repository
public class DatabaseAccessImpl implements DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	@Override
	public void insertRecord(PasswordRecord record) {
		//Insert query based off user input
		String query = "INSERT INTO PasswordRecord VALUES ("
				+ ":id, :title, :username,"
				+ ":password, :url, :email, :notes)";

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("id", record.getId());
		namedParameters.addValue("title", record.getTitle());
		namedParameters.addValue("username", record.getUsername());
		namedParameters.addValue("password", record.getPassword());
		namedParameters.addValue("url", record.getUrl());
		namedParameters.addValue("email", record.getUrl());
		namedParameters.addValue("notes", record.getNotes());

		int rowsAffected = jdbc.update(query, namedParameters);

		if (rowsAffected > 0)
			System.out.println("Record inserted into database.");
	}

	@Override
	public List<PasswordRecord> getRecordList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM PasswordRecord";
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<PasswordRecord>(PasswordRecord.class));
	}
	
	@Override
	public void updateRecord(PasswordRecord record) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Update PasswordRecord SET title = :title, username = :username,"
				+ "password = :password, url = :url, email = :email, notes = :notes WHERE id= :id";
		
		namedParameters.addValue("id", record.getId());
		namedParameters.addValue("title", record.getTitle());
		namedParameters.addValue("username", record.getUsername());
		namedParameters.addValue("password", record.getPassword());
		namedParameters.addValue("url", record.getUrl());
		namedParameters.addValue("email", record.getEmail());
		namedParameters.addValue("notes", record.getNotes());
		
		if (jdbc.update(query, namedParameters) > 0)
			System.out.println("Updated record " + record.getId() + " from database.");
		
	}

	@Override
	public void deleteRecordById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM PasswordRecord WHERE id= :id";
		
		namedParameters.addValue("id", id);
		
		if (jdbc.update(query, namedParameters) > 0)
			System.out.println("Deleted record " + id + " from database.");
		
	}

	@Override
	public List<PasswordRecord> getRecordListById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        
		String query = "SELECT * FROM PasswordRecord WHERE id = :id";
        
		namedParameters.addValue("id", id);

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<PasswordRecord>(PasswordRecord.class));
	}

}
