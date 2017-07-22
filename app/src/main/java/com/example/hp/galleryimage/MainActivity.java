package com.example.hp.galleryimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView; //Creating Image Object
    Button button; //Creating Button Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button); // Intializing button object

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.
                        INTERNAL_CONTENT_URI); // Reads the media image from the internal storage
                intent.setType("image/*"); // Picks the image of every type
                intent.setAction(intent.ACTION_GET_CONTENT); //Specifying the action for an intent
                startActivityForResult(intent, 1); //Starts Activity


            }
        });
    }
    @Override
    protected void onActivityResult(int request, int result, Intent data) { //Creating OnActivityResult Method
        super.onActivityResult(request, result, data); //onActivityResult Return back the result
        if (result == RESULT_OK) { // If result equals to true
                Uri imageUri = data.getData(); // Get the content for image media
                imageView = (ImageView) findViewById(R.id.imageView); //Initialising object
                Toast.makeText(getApplicationContext(),"Image has uploaded sucessfully",
                        Toast.LENGTH_SHORT).show(); //Toast Message
                imageView.setImageURI(imageUri); /**Sets a new image on the image view with the
                                                  given  resource id.
                                                 **/
        }
    }
}