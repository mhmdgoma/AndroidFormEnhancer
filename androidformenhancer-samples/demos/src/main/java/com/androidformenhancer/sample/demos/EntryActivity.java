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

package com.androidformenhancer.sample.demos;

import com.androidformenhancer.helper.FormHelper;
import com.androidformenhancer.ValidationResult;
import com.androidformenhancer.helper.FragmentActivityFormHelper;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

/**
 * @author Soichiro Kashima
 */
public class EntryActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        FormHelper helper = new FragmentActivityFormHelper(EntryForm.class, this);
        helper.setAsDateField(R.id.textfield_birthday, R.string.msg_default_date);
        helper.setOnFocusOutValidation();
    }

    public void onSubmit(View v) {
        FormHelper helper = new FragmentActivityFormHelper(EntryForm.class, this);
        ValidationResult result = helper.validate();
        if (result.hasError()) {
            helper.showAlertDialog(result.getAllSerializedErrors());
        } else {
            Toast.makeText(this, "OK!", Toast.LENGTH_SHORT).show();
        }
    }

}
