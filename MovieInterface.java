package project;

import java.sql.SQLException;

public interface MovieInterface 
{
	void TeluguMovies() throws SQLException;
	void HindiMovies()throws SQLException;
	void EnglishMovies()throws SQLException;

}
