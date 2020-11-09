package com.abilists.plugins.survey.dao;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MSurveyDao {

	public int istMSurvey(Map<String, Object> map) throws SQLException;
	public int udtMSurvey(Map<String, Object> map) throws SQLException;
	public int dltMSurvey(Map<String, Object> map) throws SQLException;

}