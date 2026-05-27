package base;

/**
 * Global-user login flow (config: username / password).
 *
 * What changed: Explicit base for @global Cucumber scenarios and GlobalTestRunner.
 * Why: Keeps Global and Operator login flows separated as required.
 * Mapping: loginAsGlobalUser() in legacy tests → performGlobalLogin() for reusable BDD login steps.
 */
public class BaseTest_Global extends BaseTest {

    public void performGlobalLogin() {
        loginAsGlobalUser();
    }
}
