package Cucumber.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class Test {

    @Given("User prepares the system")
    public void user_prepares_the_system() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("System is Ready....");
    }
    @When("User prints {string}")
    public void user_prints(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Printing: " + string);
    }
    @Then("Message should be displayed successfully")
    public void message_should_be_displayed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Message Displayed");
    }

    @When("User prints the following values:")
    public void user_prints_the_following_values(DataTable dataTable) {
        List<String> list = dataTable.asList();
        for (String s: list) {
            System.out.println(s);
        }
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }
}
