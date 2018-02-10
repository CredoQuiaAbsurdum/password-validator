package yz.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validatePassword(View view){

        String password = ((EditText)findViewById(R.id.editText)).getText().toString();
        Validator V = new Validator();
        int strength = V.Validate(password);

        String message = "Weak";

        if(strength == 5) message = "Very Strong";
        else if(strength > 2) message = "Strong";

        ((TextView)findViewById(R.id.textView)).setText(message);
    }

}
