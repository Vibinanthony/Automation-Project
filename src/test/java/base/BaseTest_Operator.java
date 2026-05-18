package base;

/**
 * Operator-user login flow (config: OperatorUsername / OperatorPassword).
 *
 * What changed: Explicit base for @operator Cucumber scenarios and OperatorTestRunner.
 * Why: Keeps Global and Operator login flows separated as required.
 * Mapping: loginAsOperatorUser() in legacy tests → performOperatorLogin() for reusable BDD login steps.
 */
public class BaseTest_Operator extends BaseTest {

    public void performOperatorLogin() {
        loginAsOperatorUser();
    }
}
