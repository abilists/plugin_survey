package com.abilists.plugins.survey.service;

import java.util.List;

import com.abilists.plugins.survey.bean.model.MSurveyModel;
import com.abilists.plugins.survey.bean.para.IstSurveyPara;
import com.abilists.plugins.survey.bean.para.SltSurveyPara;
import com.abilists.plugins.survey.bean.para.UdtSurveyPara;

public interface SurveyService {

	public List<MSurveyModel> sltServeyList(SltSurveyPara sltSurveyPara) throws Exception;
	public MSurveyModel sltServey(SltSurveyPara sltSurveyPara) throws Exception;
	public boolean istServey(IstSurveyPara istSurveyPara) throws IndexOutOfBoundsException, Exception;
	public boolean udtServey(UdtSurveyPara udtSurveyPara) throws Exception;
	public boolean dltServey(UdtSurveyPara udtSurveyPara) throws Exception;

}
