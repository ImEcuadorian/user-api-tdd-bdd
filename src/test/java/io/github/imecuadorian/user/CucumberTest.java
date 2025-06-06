package io.github.imecuadorian.user;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/github/imecuadorian/user/bdd")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "io.github.imecuadorian.user.bdd"
)
public class CucumberTest {
}
