package com.example.user.lifeplant.Fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.user.lifeplant.Models.ResSignupModel;
import com.example.user.lifeplant.R;
import com.example.user.lifeplant.WsClass.WSSignUp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupFragment extends Fragment {


    public String we;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private Calendar calendar = Calendar.getInstance();
    private ImageButton btnShow;
    private TextView txtv, intv;
    private EditText fname, lname, mobileno, email, password, confmpassword;
    private Button reset, submit;
    private RadioGroup radiogp;
    private RadioButton male, female;


    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int DayOfMonth) {
            final String date = DayOfMonth + "-" + (month + 1) + "-" + year;
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, DayOfMonth);
            txtv.setText(getFormattedDate("yyyy-MM-dd"));

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_signup, container, false);
    }


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnShow = view.findViewById(R.id.date_button);
        intv = view.findViewById(R.id.iamid);
        txtv = view.findViewById(R.id.enterbirthdate);
        fname = view.findViewById(R.id.first_name);
        lname = view.findViewById(R.id.lastname);
        radiogp = view.findViewById(R.id.radiogp);
        male = view.findViewById(R.id.male);
        female = view.findViewById(R.id.female);
        mobileno = view.findViewById(R.id.mobileno);
        email = view.findViewById(R.id.emailid);
        password = view.findViewById(R.id.password);
        confmpassword = view.findViewById(R.id.confirm_password);
        reset = view.findViewById(R.id.reset_button);
        submit = view.findViewById(R.id.submit_button);


        btnShow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog
                        = new DatePickerDialog(getActivity(),
                        dateSetListener,
                        calendar.get(java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH));


                datePickerDialog.show();


            }

        });
        txtv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog
                        = new DatePickerDialog(getActivity(),
                        dateSetListener,
                        calendar.get(java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH));


                datePickerDialog.show();

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String pswd = password.getText().toString();
                final String cnfpaswd = confmpassword.getText().toString();
                final String fname1 = fname.getText().toString().trim();
                final String lname1 = lname.getText().toString().trim();
                final String radiogroup = "we";
                final String mobilenum = mobileno.getText().toString().trim();
                final String emailid = email.getText().toString().trim();
                final String birthdate = txtv.getText().toString().trim();


                if (fname.getText().toString().length() == 0) {
                    fname.setError("First Name Not Entered");
                    fname.requestFocus();
                } else if (lname.getText().toString().length() == 0) {
                    lname.setError("Last Name Not Entered");
                    lname.requestFocus();
                } else if (radiogp.getCheckedRadioButtonId() == -1) {
                    male.setError("Gender Not Selected");
                    female.setError("Gender Not Selected");
                    female.requestFocus();
                } else if (mobileno.getText().toString().length() == 0) {
                    mobileno.setError("Mobile Number Not Entered");
                    mobileno.requestFocus();
                } else if (email.getText().toString().length() == 0) {
                    email.setError("Email Not Entered");
                    email.requestFocus();
                } else if (!emailid.matches(emailPattern)) {
                    email.setError("Enter Valid Email id");
                    email.requestFocus();
                } else if (password.getText().toString().length() == 0) {
                    password.setError("Password Not Entered");
                    password.requestFocus();
                } else if (password.getText().toString().length() < 8) {
                    password.setError("Password Must be Alteast 8 character");
                    password.requestFocus();
                } else if (confmpassword.getText().toString().length() == 0) {
                    confmpassword.setError("Confirm Password Not Entered");
                    confmpassword.requestFocus();
                } else if (!pswd.equals(cnfpaswd)) {
                    password.setError("Password Not Same");
                    password.requestFocus();
                    confmpassword.setError("Confirm Password Not Same");
                    confmpassword.requestFocus();
                } else if (txtv.getText().toString().length() == 0) {
                    txtv.setError("Enter Birth Date");
                    txtv.requestFocus();
                } else {

                    new AsyncSignup().execute(fname1, lname1, radiogroup, mobilenum, emailid, pswd, birthdate);

                }

//
//                final FragmentManager fm = getFragmentManager();
//                final FragmentTransaction ft = fm.beginTransaction();
//                final ProductFragment productFragment = new ProductFragment();
//
//                productFragment.setTargetFragment(SignupFragment.this, 0);
//                ft.add(R.id.main_container, productFragment, ProductFragment.class.getSimpleName());
//                ft.hide(SignupFragment.this);
//                ft.addToBackStack(ProductFragment.class.getSimpleName());
//                ft.commit();
            }
        });

        male.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String userGender = "";
                boolean checked = ((RadioButton) view).isChecked();
                switch (view.getId()) {
                    case R.id.male:
                        if (checked) {
                            userGender = "male";
                            we = userGender;
                            break;
                        }
                    case R.id.female:
                        if (checked) {
                            userGender = "female";
                            we = userGender;
                            break;

                        }
                }

            }
        });
        female.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String userGender = "";
                boolean checked = ((RadioButton) view).isChecked();
                switch (view.getId()) {
                    case R.id.male:
                        if (checked) {
                            userGender = "male";
                            we = userGender;
                            break;
                        }
                    case R.id.female:
                        if (checked) {
                            userGender = "female";
                            we = userGender;
                            break;

                        }
                }

            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() != KeyEvent.ACTION_DOWN)
                    return true;

                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        //Log.i("Menu", "onKey Back listener is working!!!");
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Wait")
                                .setMessage("Do you wish to exit?")
                                .setNegativeButton("No", null)
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int id) {

                                                getActivity().onBackPressed();
                                            }
                                        }).create().show();
                        break;
                }

                return true;
            }
        });
    }


    private String getFormattedDate(final String formatOfDate) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(formatOfDate, Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }


    private class AsyncSignup extends AsyncTask<String, Void, Void> {

        private WSSignUp wsSignup;
        private ProgressDialog progressDialog;
        private ResSignupModel resSignupModel;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "Loding", "Please wait");
        }

        @Override
        protected Void doInBackground(String... strings) {
            wsSignup = new WSSignUp(getActivity());
            resSignupModel = wsSignup.executeService(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (resSignupModel.getResponse() == 0) {
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();
                final ProductFragment productFragment = new ProductFragment();

                productFragment.setTargetFragment(SignupFragment.this, 0);
                ft.add(R.id.main_container, productFragment, ProductFragment.class.getSimpleName());
                ft.hide(SignupFragment.this);
                ft.addToBackStack(ProductFragment.class.getSimpleName());
                ft.commit();
            } else {
                new AlertDialog.Builder(getActivity()).setTitle("user is already exist");


            }
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }

}







