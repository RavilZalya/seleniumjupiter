package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.page.commonelements.Table;
import com.adjuster.honeybadger.uitest.page.connections.ConnectionsPage;
import com.adjuster.honeybadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Disable and enable connection tests")
@Tag("nested")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DisableEnableConnectionTest extends AuthenticatedTest {

    private ConnectionsPage connectionsPage;

    @BeforeAll
    public void proceedToConnectionTypesGrid() {
        connectionsPage = givenIAmAtHomePage
                .iGoToConnectionsPage();
    }

    @Test
    public void whenOnConnectionPage_thenConnectionPageIsDisplayed() {
        then(connectionsPage.isDisplayed()).isTrue();
    }

    @Test
    public void whenOnConnectionPage_thenToggleIsOff() {
        then(connectionsPage.toggleIsOn()).isFalse();
    }

    @Test
    public void whenOnConnectionPage_thenActiveConnectionIsShown() {
        then(connectionsPage.getTable().columnContainsLabel("Name", "Conn1001Opnx\n1 Data Set")).isTrue();
    }

    @Test
    public void whenOnConnectionPage_thenInactiveConnectionIsNotShown() {
        then(connectionsPage.getTable().columnContainsLabel("Name", "Conn1001Crto\n1 Data Set")).isFalse();
    }


    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class Step1ConnectionDetailsWindow {

        private Table connectionsTable;

        @BeforeAll
        public void setShowDisabledConnectionsToggleOn() {
            connectionsTable = connectionsPage.setDisabledToggle(true);
        }

        @Test
        public void whenToggleIsSetToShowDisabled_thenDisabledConnectionIsShown() {
            then(connectionsTable.columnContainsLabel("Name", "Conn1001Crto\n1 Data Set")).isTrue();
        }


    }
}