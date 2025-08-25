package project7;

import com.example.test2.Animal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    EditText input3;
    ImageView output1;
    Animal animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        output1 = findViewById(R.id.output1);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            //강아지만들기 버튼
            Dog dog1 = new Dog("바둑이", 1, "010-1111-1111");
            System.out.println("강아지가 만들어졌어요.");
            output1.setImageResource(R.drawable.standdog);

            Button button3 = findViewById(R.id.button3);
            button3.setOnClickListener(view1 -> {
                dog1.standup();
                output1.setImageResource(R.drawable.standdog);
            });

            Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(view2 -> {
                dog1.sitdown();
                output1.setImageResource(R.drawable.sitdog);
            });

            Button button5 = findViewById(R.id.button5);
            button5.setOnClickListener(view3 -> {
                dog1.run();
                output1.setImageResource(R.drawable.rundog);
            });

        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            Cat cat1 = new Cat("나나", 2, "010-2222-2222");
            System.out.println("고양이가 만들어졌어요.");
            output1.setImageResource(R.drawable.standcat);

            Button button3 = findViewById(R.id.button3);
            button3.setOnClickListener(view1 -> {
                cat1.standup();
                output1.setImageResource(R.drawable.standcat);
            });

            Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(view2 -> {
                cat1.sitdown();
                output1.setImageResource(R.drawable.sitcat);
            });

            Button button5 = findViewById(R.id.button5);
            button5.setOnClickListener(view3 -> {
                cat1.run();
                output1.setImageResource(R.drawable.runcat);
            });
        });








    }
}