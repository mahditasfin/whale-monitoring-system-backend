/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ca.uvic.seng330.backend;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        Driver classUnderTest = new Driver();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
