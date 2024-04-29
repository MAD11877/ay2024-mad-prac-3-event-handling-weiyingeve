package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sg.edu.np.mad.madpractical2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(sg.edu.np.mad.madpractical2.R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(sg.edu.np.mad.madpractical2.R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        int randomNumber = getIntent().getIntExtra("random_number", 0);
        //get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        //set the TextViews with the User's name, description and default button message
        tvName.setText(user.name + " " + String.valueOf(randomNumber));
        tvDescription.setText(user.description);
        Toast toastFollow = Toast.makeText(this, "Followed", Toast.LENGTH_SHORT);
        Toast toastUnFollow = Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.followed) {
                    user.followed = false;
                    btnFollow.setText("Follow");
                    toastFollow.show();
                } else if (!user.followed) {
                    user.followed=true;
                    btnFollow.setText("Unfollow");
                    toastUnFollow.show();
                }
            }
        });
    }
}

