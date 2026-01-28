package com.co.booking.runner;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@happy-path")
class CucumberPetTest {}
