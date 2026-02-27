package com.careerlink.EasyApply.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerlink.EasyApply.dao.JobApplicationRepo;
import com.careerlink.EasyApply.entity.JobApplication;
import com.careerlink.EasyApply.service.JobApplicationService;


@Service
public class JobApplicationserviceIMPL implements JobApplicationService {
	
	@Autowired
	JobApplicationRepo repo;

	@Override
	public JobApplication apply(String role, JobApplication application) {
		if(!role.equals("USER"))
				{
		throw new RuntimeException("only user can apply");
				}
		
		JobApplication jobapplication=	repo.save(application);
		
	
		return jobapplication;
	}

}
