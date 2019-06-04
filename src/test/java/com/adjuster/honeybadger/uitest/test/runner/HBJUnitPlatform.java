/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test.runner;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.notification.RunNotifier;

public class HBJUnitPlatform extends JUnitPlatform {

    public HBJUnitPlatform(Class<?> testClass) {
        super(testClass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new FailFastListener(notifier));
        notifier.fireTestStarted(getDescription());
        super.run(notifier);
    }

}
