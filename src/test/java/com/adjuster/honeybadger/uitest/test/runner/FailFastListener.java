/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test.runner;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class FailFastListener extends RunListener {

    private RunNotifier runNotifier;

    public FailFastListener(RunNotifier runNotifier) {
        super();
        this.runNotifier = runNotifier;
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
        this.runNotifier.pleaseStop();
    }

}
