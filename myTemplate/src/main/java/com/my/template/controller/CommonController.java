package com.my.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionVO")
@RequestMapping("/common")
public class CommonController {

    @SuppressWarnings("unused")
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    /********************************************************************************************************************
     * ���� include
     ********************************************************************************************************************/      
    @RequestMapping(value="/header.do")
    public String header() throws Exception {
    	return "include/header";
    }

    @RequestMapping(value="/jsCommon.do")
    public String jsCommon() throws Exception {
    	return "include/jsCommon";
    }

    @RequestMapping(value="/ajaxCommon.do")
    public String ajaxCommon() throws Exception {
    	return "include/ajaxCommon";
    }
}