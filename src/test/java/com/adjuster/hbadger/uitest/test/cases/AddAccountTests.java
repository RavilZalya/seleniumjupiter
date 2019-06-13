/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;

import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.data.AccountData;
import com.adjuster.hbadger.uitest.data.AccountData.AccountLabelAndValue;
import com.adjuster.hbadger.uitest.data.PermissionData;
import com.adjuster.hbadger.uitest.page.accounts.AccountsPage;
import com.adjuster.hbadger.uitest.page.accounts.component.AccountDetailsDialog;
import com.adjuster.hbadger.uitest.page.accounts.component.AccountPermissionsDialog;
import com.adjuster.hbadger.uitest.page.accounts.component.ReviewDialog;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddAccountTests extends AuthenticatedTest {

    public AddAccountTests() {
        super(new TestParams("internalcredsOld.csv"));
    } //the idea is to load all test params from a csv file inside the TestParam object. In this case contains only credentials

    // data init
    public PermissionData permissionsData = new PermissionData();
    public AccountData accountData = new AccountData(permissionsData);

    private AccountsPage accountsPage;
    private AccountDetailsDialog detailsStep;
    private AccountPermissionsDialog permissionsStep;
    private ReviewDialog reviewStep;

    @Tag("account")
    @Tag("Adem")
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("Test creating a new account \ud83d\udeac")
    class TestCreateNewAccount {

        @BeforeAll
        public void proceedToConnectionTypesGrid() {
            accountsPage = givenIAmAtHomePage
                    .iGoToAccountsPage();
        }


        @Test
        @DisplayName("Verify add new account button is clickable")
        void verifyAddAccountButtonClickable() {
            assertTrue(accountsPage.isAddAccountButtonClickable());
        }

        // STEP 1 - ACCOUNT DETAILS
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        @DisplayName("Test AddAccountTests Account Step 1 - Account Details")
        class TestAddAccountStep1 {

            @BeforeAll
            void setup() {
                detailsStep = accountsPage.clickOnAddNewAccount();
            }

            @Test
            @DisplayName("Verify Create New Account Dialog Header")
            void verifyAccountDetailsHeader() {
                assertTrue(detailsStep.verifyHeader(wdController));
            }

            @Test
            @DisplayName("Verify Create New Account - Account Details Sub Header")
            void verifyAccountDetailsSubHeader() {
                assertTrue(detailsStep.verifySubHeader());
            }

            @Test
            @DisplayName("Verify Account Name Label")
            void verifyAccountNameLabel() {
                assertTrue(detailsStep.verifyAccountNameLabel());
            }

            @Test
            @DisplayName("Verify Salesforce Account Label")
            void verifySalesforceLabel() {
                assertTrue(detailsStep.verifySalesforceLabel());
            }

            @Test
            @DisplayName("Verify Timezone Label")
            void verifyTimezoneLabel() {
                assertTrue(detailsStep.verifyTimezoneLabel());
            }

            @Test
            @DisplayName("Verify Enable SSO Support Label")
            void verifySsoLabel() {
                assertTrue(detailsStep.verifySsoLabel());
            }

            @Test
            @DisplayName("Verify Max Users Label")
            void verifyMaxUserLabel() {
                assertTrue(detailsStep.verifyMaxUserLabel());
            }

            @Test
            @DisplayName("Verify Default Number of Max Users")
            void verifyDefaultMaxUsersNumber() {
                assertTrue(detailsStep.verifyDefaultNumberOfMaxUsers());
            }

            // STEP 2 - ACCOUNT PERMISSIONS
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            @Nested
            @DisplayName("Test AddAccountTests Account Step 2 - Account Permissions")
            class TestAddAccountStep2 {

                @BeforeAll
                void setup() {
                    permissionsStep = detailsStep.enterAccountName(accountData.getAccountName())
                            .selectTimeZone(accountData.getTimezone().getLongText()).clickNext();
                }

                @Test
                @DisplayName("Verify Account Permissions Header")
                void verifyPermissionsHeader() {
                    assertTrue(permissionsStep.verifyHeader(wdController));
                }

                @Test
                @DisplayName("Verify Create New Account - Account Permissions Sub Header")
                void verifyPermissionsSubHeader() {
                    assertTrue(permissionsStep.verifySubHeader());
                }

                @ParameterizedTest
                @EnumSource(value = PermissionData.PermissionElements.class)
                @DisplayName("Verify all account permission labels")
                void verifyLabels(PermissionData.PermissionElements permissions) {
                    assertTrue(permissionsStep.isLabelVisible(permissions.getName()));
                }

                @ParameterizedTest
                @EnumSource(value = PermissionData.PermissionElements.class)
                @DisplayName("Verify all account permission toggle values")
                void verifyToggleValues(PermissionData.PermissionElements permissions) {
                    assertTrue(permissionsStep.verifyToggleValue(permissions.toString(), permissions.getFlag()));
                }

                @ParameterizedTest
                @EnumSource(value = PermissionData.PermissionElements.class)
                @DisplayName("Verify all account permission toggle availabilities")
                void verifyToggleAvailabilities(PermissionData.PermissionElements permissions) {
                    assertTrue(permissionsStep.verifyToggleAvailability(permissions.getName(),
                            permissions.getFieldEnabled()));
                }

                // STEP 3 - ACCOUNT DATA VERIFY
                @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                @Nested
                @DisplayName("Test Add Account Account Step 3")
                class VerifyAddAccountStep3 {

                    @BeforeAll
                    void setup() {
                        reviewStep = permissionsStep.clickNext();
                    }

                    @Test
                    @DisplayName("Verify Review Step Header")
                    void verifyReviewStepHeader() {
                        assertTrue(reviewStep.verifyHeader(wdController));
                    }

                    @Test
                    @DisplayName("Verify Review Step Header")
                    void verifyReviewStepSubHeader() {
                        assertTrue(reviewStep.verifySubHeader());
                    }

                    @Test
                    @DisplayName("Verify account label")
                    void verifyAccountLabel() {
                        assertEquals(AccountLabelAndValue.ACCOUNT_NAME.getLabel(), reviewStep.getAccountLabel());
                    }

                    @Test
                    @DisplayName("Verify salesforce label")
                    void verifySalesforceLabel() {
                        assertEquals(AccountLabelAndValue.SALESFORCE_ACCOUNT.getLabel(),
                                reviewStep.getSalesforceAccountLabel());
                    }

                    @Test
                    @DisplayName("Verify timezone label")
                    void verifyTimezoneLabel() {
                        assertEquals(AccountLabelAndValue.TIMEZONE.getLabel(), reviewStep.getTimezoneLabel());
                    }

                    @Test
                    @DisplayName("Verify sso support label")
                    void verifySsoLabel() {
                        assertEquals(AccountLabelAndValue.SSO_SUPPORT.getLabel(), reviewStep.getSSOLabel());
                    }

                    @Test
                    @DisplayName("Verify permissions label")
                    void verifyPermissionsLabel() {
                        assertEquals(AccountLabelAndValue.PERMISSIONS.getLabel(), reviewStep.getPermissionsLabel());
                    }

                    @Test
                    @DisplayName("Verify account value")
                    void verifyAccountValue() {
                        assertEquals(AccountLabelAndValue.ACCOUNT_NAME.getValue(), reviewStep.getAccountValue());
                    }

                    @Test
                    @DisplayName("Verify salesforce account value")
                    void verifySalesforceValue() {
                        assertEquals(AccountLabelAndValue.SALESFORCE_ACCOUNT.getValue(),
                                reviewStep.getSalesforceAccountValue());
                    }

                    @Test
                    @DisplayName("Verify timezone value")
                    void verifyTimezoneValue() {
                        assertEquals(AccountLabelAndValue.TIMEZONE.getValue(), reviewStep.getTimezoneValue());
                    }

                    @Test
                    @DisplayName("Verify sso support value")
                    void verifySsoValue() {
                        assertEquals(AccountLabelAndValue.SSO_SUPPORT.getValue(), reviewStep.getSSOValue());
                    }

                    @Test
                    @DisplayName("Verify permissions value")
                    void verifyPermissionsValue() {
                        assertEquals(AccountLabelAndValue.PERMISSIONS.getValue(), reviewStep.getPermissionsValue());
                    }

                    // VERIFY ACCOUNT ADDED
                    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                    @Nested
                    @DisplayName("Test Account added successfully")
                    class VerifyAddedAccount {

                        @BeforeAll
                        void setup() {
                            reviewStep.clickAddAccountButton();
                            accountsPage = new AccountsPage(wdController, getConfig());
                        }

                        //See comments in AccountsPage
                        //@Test
                        //@DisplayName("Verify page header")
                        //void verifyPageHeader() {
                        //	assertTrue(accountsPage.verifyPageHeader(accountData.getAccountName()));
                        //}

                        @Test
                        @DisplayName("Verify add user to account text")
                        void verifyNoUserAddUserText() {
                            assertTrue(accountsPage.isNoUserTextVisible(accountData.getAccountName()));
                        }

                        @Test
                        @DisplayName("Verify add a new user button is clickable")
                        void verifyAddUserButtonClickable() {
                            assertTrue(accountsPage.isAddUserButtonClickable());
                        }

                        @Test
                        @DisplayName("Verify add a new user icon is clickable")
                        void verifyAddUserIconClickable() {
                            assertTrue(accountsPage.isAddUserIconClickable());
                        }
                    }
                }
            }
        }
    }
}
