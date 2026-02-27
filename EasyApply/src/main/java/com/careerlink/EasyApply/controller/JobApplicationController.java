package com.careerlink.EasyApply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerlink.EasyApply.entity.JobApplication;
import com.careerlink.EasyApply.serviceimpl.JobApplicationserviceIMPL;

@RestController
@RequestMapping("/jobapply")
public class JobApplicationController {
	
	@Autowired
	JobApplicationserviceIMPL job;
	
	
	@PostMapping("/apply")
	public JobApplication apply(@RequestHeader String role, @RequestBody JobApplication application) {
		JobApplication jp=	job.apply(role, application);
		
	
		return jp;
	}


}
