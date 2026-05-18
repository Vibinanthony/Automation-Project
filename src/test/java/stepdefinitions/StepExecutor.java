package stepdefinitions;

import base.BaseTest;

/**
 * Binds legacy TestNG test classes to the active Cucumber WebDriver session without changing test logic.
 */
public final class StepExecutor {

    private StepExecutor() {
    }

    public static <T extends BaseTest> T bind(Class<T> testClass) {
        try {
            T instance = testClass.getDeclaredConstructor().newInstance();
            instance.syncFromTestContext();
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to bind test class: " + testClass.getSimpleName(), e);
        }
    }
}
