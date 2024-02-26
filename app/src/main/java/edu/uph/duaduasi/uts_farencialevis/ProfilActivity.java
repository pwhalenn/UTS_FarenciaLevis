package edu.uph.duaduasi.uts_farencialevis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {
    private EditText studentID, nama, jurusan, tahunMasuk, kampus;
    private Spinner status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // Find the Spinner in your layout
        Spinner spinnerStatus = findViewById(R.id.status);

        // Retrieve the string array from resources
        String[] items = getResources().getStringArray(R.array.status_mahasiswa);

        // Create an ArrayAdapter and set it to the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);

        // Inisialisasi Views
        studentID = findViewById(R.id.studentID);
        nama = findViewById(R.id.nama);
        jurusan = findViewById(R.id.jurusan);
        tahunMasuk = findViewById(R.id.tahunMasuk);
        status = findViewById(R.id.status);
        kampus = findViewById(R.id.kampus);

        // Inisialisasi ImageButton
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });
    }
    private void showToast() {
        // Get input value
        String studentIDValue = studentID.getText().toString();
        String namaValue = nama.getText().toString();
        String jurusanValue = jurusan.getText().toString();
        String tahunMasukValue = tahunMasuk.getText().toString();
        String statusValue = status.getSelectedItem().toString(); // Get selected item from Spinner
        String kampusValue = kampus.getText().toString();

        // Create message for Toast
        String message = "StudentID: " + studentIDValue + "Nama: " + namaValue + " | Jurusan: " + jurusanValue + " | Tahun Masuk: " + tahunMasukValue + " | Status Mahasiswa: " + statusValue + " | Kampus: " + kampusValue;

        // Show the horizontal Toast
        Toast toast = Toast.makeText(ProfilActivity.this, message, Toast.LENGTH_LONG);
        View toastView = toast.getView();
        // Set layout direction to right-to-left
        toastView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        toast.show();
    }
}