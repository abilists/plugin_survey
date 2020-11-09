package com.abilists.plugins.survey.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.abilists.plugins.survey.bean.model.MSurveyModel;

@Repository
public interface SSurveyDao {

	public List<MSurveyModel> sltMSurveyList(Map<String, Object> map) throws SQLException;
	public MSurveyModel sltMSurvey(Map<String, Object> map) throws SQLException;

}