package com.example.task2try2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.task2try2.Package.TextCounter;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Spinner spCountingOptions;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.edUserInput =  findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);
        this.spCountingOptions = (Spinner) findViewById(R.id.spCountingOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.counting_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCountingOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        // Получаем текст из EditText
        String userInput = this.edUserInput.getText().toString().trim();  // Убираем лишние пробелы

        // Проверяем, пустая ли строка
        if (userInput.isEmpty()) {
            // Если строка пустая, показываем предупреждение
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            return;  // Прерываем выполнение метода
        }

        // Инициализируем класс TextCounter
        TextCounter tc = new TextCounter();

        // Проверяем, что выбрано в Spinner: символы или слова
        String selectedOption = this.spCountingOptions.getSelectedItem().toString();

        if (selectedOption.equals("Chars")) {
            // Считаем количество символов
            int charCount = tc.getCharsCount(userInput);
            this.tvResult.setText(String.valueOf(charCount));
        } else if (selectedOption.equals("Words")) {
            // Считаем количество слов
            int wordCount = tc.getWordsCount(userInput);
            this.tvResult.setText(String.valueOf(wordCount));
        } else {
            // Если выбран неправильный режим, показываем предупреждение
            Toast.makeText(this, "Invalid Option", Toast.LENGTH_LONG).show();
        }

    }}
