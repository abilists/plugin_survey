package com.abilists.plugins.survey.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abilists.core.service.AbilistsAbstractService;
import com.abilists.plugins.survey.bean.model.MSurveyModel;
import com.abilists.plugins.survey.bean.para.IstSurveyPara;
import com.abilists.plugins.survey.bean.para.SltSurveyPara;
import com.abilists.plugins.survey.bean.para.UdtSurveyPara;
import com.abilists.plugins.survey.dao.MSurveyDao;
import com.abilists.plugins.survey.dao.SSurveyDao;
import com.abilists.plugins.survey.service.SurveyService;

@Service
public class SurveyServiceImpl extends AbilistsAbstractService implements SurveyService {

	final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

	@Autowired
	private SqlSession sAbilistsDao;

	@Override
	public List<MSurveyModel> sltServeyList(SltSurveyPara sltSurveyPara) throws Exception {
		List<MSurveyModel> surveyList = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sltSurveyPara.getUserId());

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			surveyList = sAbilistsDao.getMapper(SSurveyDao.class).sltMSurveyList(map);

		} catch (Exception e) {
			logger.error("sltOptions Exception error", e);
		}

		return surveyList;
	}

	@Override
	public MSurveyModel sltServey(SltSurveyPara sltSurveyPara) throws Exception {
		MSurveyModel survey = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sltSurveyPara.getUserId());

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			survey = sAbilistsDao.getMapper(SSurveyDao.class).sltMSurvey(map);
			if(survey == null) {
				logger.error("There is no user default options data. please insert your default data.");
			}
		} catch (Exception e) {
			logger.error("sltOptions Exception error", e);
		}

		return survey;
	}

	@Transactional(rollbackFor = {IndexOutOfBoundsException.class, Exception.class}, propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean istServey(IstSurveyPara istSurveyPara) throws Exception {
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", istSurveyPara.getUserId());

		} catch (IndexOutOfBoundsException ie) {
			logger.error("IndexOutOfBoundsException error", ie);
			return false;
		} catch (Exception e) {
			logger.error("Exception error", e);
			return false;
		}

		return true;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean udtServey(UdtSurveyPara udtSurveyPara) throws Exception {

		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", udtSurveyPara.getUserId());

		try {
			intResult = mAbilistsDao.getMapper(MSurveyDao.class).udtMSurvey(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
	
		if(intResult < 1) {
			logger.error("udtServey error, userId={}", udtSurveyPara.getUserId());
			return false;
		}
	
		return true;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean dltServey(UdtSurveyPara udtSurveyPara) throws Exception {

		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", udtSurveyPara.getUserId());

		try {
			intResult = mAbilistsDao.getMapper(MSurveyDao.class).udtMSurvey(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		if(intResult < 1) {
			logger.error("dltServey error, userId={}", udtSurveyPara.getUserId());
			return false;
		}
	
		return true;
	}

}