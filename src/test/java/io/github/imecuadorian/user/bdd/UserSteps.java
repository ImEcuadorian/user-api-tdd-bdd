package io.github.imecuadorian.user.bdd;

import io.github.imecuadorian.user.service.UserService;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserSteps {

    private final UserService userService = new UserService();
    private String email;
    private boolean result;

    @Given("I have a user with email {string}")
    public void i_have_a_user(String email) {
        this.email = email;
    }

    @And("I register the user")
    public void i_register_the_user() {
        userService.register(email);
    }

    @When("I check if the user exists")
    public void i_check_if_the_user_exists() {
        result = userService.existsByEmail(email);
    }

    @Then("the result should be true")
    public void the_result_should_be_true() {
        assertTrue(result);
    }

    @Then("the result should be false")
    public void the_result_should_be_false() {
        assertFalse(result);
    }
}
