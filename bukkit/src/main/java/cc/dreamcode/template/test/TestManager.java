package cc.dreamcode.template.test;

import cc.dreamcode.template.config.PluginConfig;
import eu.okaeri.injector.annotation.Inject;

import java.util.ArrayList;
import java.util.List;

public class TestManager {

    @Inject
    private PluginConfig pluginConfig;

    /**
     * Retrieves the test strings from all the tests in the testList.
     *
     * @return A list of test strings.
     */
    public List<String> getTestStrings() {
        List<String> testStrings = new ArrayList<>();
        for (Test test : this.pluginConfig.testList) {
            testStrings.add(test.getTestString());
        }
        return testStrings;
    }

    /**
     * Retrieves the test numbers from all the tests in the testList.
     *
     * @return A list of test numbers.
     */
    public List<Integer> getTestNumbers() {
        List<Integer> testNumbers = new ArrayList<>();
        for (Test test : this.pluginConfig.testList) {
            testNumbers.add(test.getTestNumber());
        }
        return testNumbers;
    }

    /**
     * Adds a new test with the specified string and number to the testList.
     *
     * @param testString The test string to be added.
     * @param testNumber The test number to be added.
     */
    public void addTestStringAndInt(String testString, int testNumber) {
        this.pluginConfig.testList.add(new Test(testNumber, testString));
        this.pluginConfig.save();
    }

}
