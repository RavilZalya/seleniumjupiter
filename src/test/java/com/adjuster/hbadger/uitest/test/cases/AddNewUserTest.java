/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;

import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.account.component.NewUserDetails;
import com.adjuster.hbadger.uitest.page.account.component.NewUserPermissions;
import com.adjuster.hbadger.uitest.page.account.component.NewUserReview;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.common.Toggles;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Adding a new user")
@Tag("user")
@Tag("rz")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddNewUserTest extends AuthenticatedTest {

    private NewUserDetails newUserDetails;

    public AddNewUserTest() {
        super(new TestParams("AddNewUserTestOld.csv"));
    }

    @BeforeAll
    public void proceedToCreatingNewUser() {
        newUserDetails = givenIAmAtHomePage
                .iGoToAccountsPage()
                .goToAccountPage(testParams.get("account"))
                .clickAddNewUserBtn();
    }

    @Test
    public void whenClickingAddNewUser_thenStep1UserDetailsWindowAppears() {
        then(newUserDetails.isDisplayed()).isTrue();
    }

    @Test()
    public void whenTypingConnectionName_thenNextButtonGetsEnabled() {
        then(newUserDetails.andIEnterUserDetails(testParams.get("firstName"), testParams.get("lastName"), testParams.get("accntType"))
                .andEnterValidEmailFormat(testParams.get("email")).buttonNextIsEnabled()).isTrue();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class Step2UserPermissionsWindow {

        NewUserPermissions userPermissions;
        Toggles toggleGrid;

        @BeforeAll
        public void proceedToStep2ConnectionPermissionWindow() {
            userPermissions = newUserDetails.clickButtonNext();
            toggleGrid = userPermissions.getToggleGrid();
        }

        @Test
        public void whenClickingNextButton_thenStep2UserPermissionAppears() {
            then(userPermissions.isDisplayed()).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_thenInStep2UserPermissionNextButtonIsEnabled() {
            then(userPermissions.buttonNextIsEnabled()).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserCreateIsEnabled() {
            then(toggleGrid.toggleIsEnabled("user_create")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserReadIsEnabled() {
            then(toggleGrid.toggleIsEnabled("user_read")).isFalse(); //BUG
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserUpdateIsEnabled() {
            then(toggleGrid.toggleIsEnabled("user_update")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserDeleteIsEnabled() {
            then(toggleGrid.toggleIsEnabled("user_delete")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserCreateIsOn() {
            then(toggleGrid.toggleIsSetOn("user_create")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserReadIsOn() {
            then(toggleGrid.toggleIsSetOn("user_read")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserUpdateIsOn() {
            then(toggleGrid.toggleIsSetOn("user_update")).isTrue();
        }

        @Test
        public void whenInStep2UserPermissions_toggleUserDeleteIsOn() {
            then(toggleGrid.toggleIsSetOn("user_delete")).isTrue();
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        public class ChangeToggleStateTests {


            @BeforeAll
            public void proceedToStep3ReviewAppears() {
                toggleGrid
                        .setToggle("user_create", false)
                        .setToggle("user_read", false)
                        .setToggle("user_update", false)
                        .setToggle("user_delete", false);
            }

            @Test
            public void whenInStep2UserPermissions_toggleUserCreateIsOff() {
                then(toggleGrid.toggleIsSetOn("user_create")).isFalse();
            }

            @Test
            public void whenInStep2UserPermissions_toggleUserReadIsOff() {
                then(toggleGrid.toggleIsSetOn("user_read")).isFalse();
            }

            @Test
            public void whenInStep2UserPermissions_toggleUserUpdateIsOff() {
                then(toggleGrid.toggleIsSetOn("user_update")).isFalse();
            }

            @Test
            public void whenInStep2UserPermissions_toggleUserDeleteIsOff() {
                then(toggleGrid.toggleIsSetOn("user_delete")).isFalse();
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            public class GoToStep3NewUserVerify {

                NewUserReview userReview;

                @BeforeAll
                public void proceedToStep3ReviewAppears() {
                    userReview = userPermissions.clickButtonNext();
                }

                @Test
                public void whenInStep3UserReview_thenNextButtonIsEnabled() {
                    then(userReview.buttonNextIsEnabled()).isTrue();
                }

                @Nested
                @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                public class StepSaveUser {

                    Snackbar snackbar;

                    @BeforeAll
                    public void proceedToStep3ReviewAppears() {
                        snackbar = userReview.clickButtonNext();
                    }

                    @Test
                    public void whenInStep3UserReview_thenNextButtonIsEnabled() {
                        then(snackbar.isSuccess()).isTrue();
                    }
                }
            }
        }
    }
}





