package bimal.assignment.notifications;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import channel.CreateChannel;

public class MainActivity extends AppCompatActivity {

    private Button btnNot1, btnNot2;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnNot1 = findViewById(R.id.btnNot1);
        btnNot2 = findViewById(R.id.btnNot2);

        btnNot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification1();
            }
        });

        btnNot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });
    }
    private void displayNotification1()
    {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                                    .setSmallIcon(R.drawable.ic_attachment_random)
                                    .setContentTitle("First Message")
                                    .setContentText("This is first")
                                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                    .build();
        notificationManagerCompat.notify(1, notification);
    }

    private void displayNotification2()
    {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                                    .setSmallIcon(R.drawable.ic_attachment_random)
                                    .setContentTitle("Second Message")
                                    .setContentText("This is second")
                                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                    .build();
        notificationManagerCompat.notify(2, notification);
    }
}
