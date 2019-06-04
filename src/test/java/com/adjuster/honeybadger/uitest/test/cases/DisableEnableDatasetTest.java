package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@DisplayName("Disable and enable dataset tests")
@Tag("blank")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DisableEnableDatasetTest extends AuthenticatedTest {
}
