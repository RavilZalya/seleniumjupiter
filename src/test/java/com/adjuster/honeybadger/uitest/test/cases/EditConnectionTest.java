/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@DisplayName("Editing connections tests")
@Tag("blank")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditConnectionTest extends AuthenticatedTest {
}
