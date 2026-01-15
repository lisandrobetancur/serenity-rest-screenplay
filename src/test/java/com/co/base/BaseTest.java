package com.co.base;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTest {

  protected String restApiUrl;

  @BeforeEach
  void setUp() {
    restApiUrl = System.getProperty("restapi.baseurl");
  }
}
