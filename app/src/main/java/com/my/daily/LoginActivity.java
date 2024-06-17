package com.my.daily;


import static com.my.daily.MainActivity.editing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cazaea.sweetalert.SweetAlertDialog;
import com.my.daily.Component.Prefs;
import com.my.daily.Component.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoginActivity extends AppCompatActivity {


    public static final String USER = "USER";
    private static final int SELECT_PICTURE = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 101;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String IMAGE_URI = "imageUri";
    public static String USERKEY;
    public static Prefs prefs;
    public static String imageUri;

    static {
        System.loadLibrary("native");
    }

    CardView btnSignIn;
    ImageView profile, changeprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.navbarwindows(LoginActivity.this, R.color.colorAccent);
        Uixtwo();
    }

    private void Uixtwo() {
        prefs = Prefs.with(this);
        profile = findViewById(R.id.profile);
        changeprofile = findViewById(R.id.changeprofile);
        final TextView textUsername = findViewById(R.id.textUsername);
        textUsername.setText(prefs.read(USER, ""));
        String filePath = getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/SimpanFotoku/fotosaya.jpg";
        File imageFiled = new File(filePath);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textUsername = findViewById(R.id.textUsername);
                if (!textUsername.getText().toString().isEmpty()) {
                    if (imageFiled.exists()) {
                        prefs.write(USER, textUsername.getText().toString());
                        String userKey = textUsername.getText().toString().trim();
                        USERKEY = userKey;
                        SweetAlertDialog pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                        pDialog.getProgressHelper().setBarColor(Color.parseColor("#8BC34A"));
                        pDialog.setTitleText("Tunggu Sebentar Yaa " + USERKEY + "..");
                        pDialog.setCancelable(false);
                        pDialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                pDialog.dismiss();
                            }
                        }, 3000);
                    } else {
                        new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Pasang foto profile dulu..!!")
                                .setConfirmText("Pasang Sekarang")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        checkStoragePermission();
                                        sDialog.dismiss();
                                    }
                                }).show();
                    }
                }
                if (textUsername.getText().toString().isEmpty()) {
                    textUsername.setError("Masukkan namamu terlebih dahulu!");
                }
                if (textUsername.getText().toString().isEmpty()) {
                    textUsername.setError("Masukkan namamu terlebih dahulu!");
                }
            }
        });

        TextView getKey = findViewById(R.id.GetKey);
        getKey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, InformasiActivity.class);
                startActivity(intent);
            }
        });

        if (!textUsername.getText().toString().isEmpty()) {
            btnSignIn.performClick();
        }
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkStoragePermission();
            }
        });
        changeprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkStoragePermission();
            }
        });
        if (editing) {
            changeprofile.setVisibility(View.VISIBLE);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                    profile.setImageBitmap(bitmap);
                    saveImageToStorage(selectedImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void saveImageToStorage(Uri imageUri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            if (inputStream != null) {
                File directory = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "SimpanFotoku");
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                File outputFile = new File(directory, "fotosaya.jpg");
                FileOutputStream outputStream = new FileOutputStream(outputFile);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.close();
                inputStream.close();
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(IMAGE_URI, Uri.fromFile(outputFile).toString());
                editor.apply();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadImageFromPreferences() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        imageUri = prefs.getString(IMAGE_URI, null);
        if (imageUri != null) {
            File imageFile = new File(Uri.parse(imageUri).getPath());
            if (imageFile.exists()) {
                if (!editing) {
                    changeprofile.setVisibility(View.GONE);
                }
                profile.setImageURI(Uri.parse(imageUri));
            } else {
                changeprofile.setVisibility(View.VISIBLE);
                profile.setImageDrawable(getResources().getDrawable(R.drawable.ppdef));
            }
            //imageFile.delete();
        }
    }

    private void checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_STORAGE_PERMISSION);
        } else {
            openGallery();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_STORAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
            }
        }
    }

    private void fadeInViewgone(final View view) {
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        view.setVisibility(View.GONE);
        view.startAnimation(fadeIn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadImageFromPreferences();
    }

}
