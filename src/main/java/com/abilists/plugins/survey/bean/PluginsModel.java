package com.abilists.plugins.survey.bean;

import java.util.List;

import com.abilists.plugins.survey.bean.model.MSurveyModel;

import base.bean.model.CommonModel;

public class PluginsModel extends CommonModel {

	private MSurveyModel mSurvey;
	private List<MSurveyModel> mSurveyList;

	public MSurveyModel getmSurvey() {
		return mSurvey;
	}
	public void setmSurvey(MSurveyModel mSurvey) {
		this.mSurvey = mSurvey;
	}
	public List<MSurveyModel> getmSurveyList() {
		return mSurveyList;
	}
	public void setmSurveyList(List<MSurveyModel> mSurveyList) {
		this.mSurveyList = mSurveyList;
	}

}
