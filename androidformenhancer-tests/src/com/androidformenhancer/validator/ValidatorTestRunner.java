/*
 * Copyright 2012 Soichiro Kashima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androidformenhancer.validator;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

import java.util.Locale;

import junit.framework.TestSuite;

/**
 * @author Soichiro Kashima
 */
public class ValidatorTestRunner extends InstrumentationTestRunner {

    @Override
    public TestSuite getAllTests() {
        updateLocale(Locale.US);
        return getTargetTestSuite();
    }

    protected void updateLocale(Locale locale) {
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Resources resources = getContext().getResources();
        resources.updateConfiguration(config, null);
    }

    protected InstrumentationTestSuite getTargetTestSuite() {
        final InstrumentationTestSuite testSuite = new InstrumentationTestSuite(this);

        testSuite.addTestSuite(DigitsValidatorTest.class);
        testSuite.addTestSuite(LengthValidatorTest.class);
        testSuite.addTestSuite(MaxLengthValidatorTest.class);
        testSuite.addTestSuite(NumOfDigitsValidatorTest.class);
        testSuite.addTestSuite(MaxNumOfDigitsValidatorTest.class);
        testSuite.addTestSuite(MaxValueValidatorTest.class);
        testSuite.addTestSuite(MinValueValidatorTest.class);
        testSuite.addTestSuite(IntRangeValidatorTest.class);
        testSuite.addTestSuite(MultibyteValidatorTest.class);
        testSuite.addTestSuite(HiraganaValidatorTest.class);
        testSuite.addTestSuite(KatakanaValidatorTest.class);
        testSuite.addTestSuite(AlphabetValidatorTest.class);
        testSuite.addTestSuite(AlphaNumValidatorTest.class);
        testSuite.addTestSuite(SinglebyteValidatorTest.class);
        testSuite.addTestSuite(IntTypeValidatorTest.class);
        testSuite.addTestSuite(FloatTypeValidatorTest.class);
        testSuite.addTestSuite(RequiredValidatorTest.class);
        testSuite.addTestSuite(RegexValidatorTest.class);
        testSuite.addTestSuite(EmailValidatorTest.class);
        testSuite.addTestSuite(DatePatternValidatorTest.class);
        testSuite.addTestSuite(PastDateValidatorTest.class);

        return testSuite;
    }

    @Override
    public ClassLoader getLoader() {
        return ValidatorTestRunner.class.getClassLoader();
    }

}
