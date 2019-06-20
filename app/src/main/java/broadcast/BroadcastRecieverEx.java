package broadcast;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import bimal.assignment.notifications.R;
import channel.CreateChannel;

public class BroadcastRecieverEx extends BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastRecieverEx(Context context)
    {
        this.context = context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(context);

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);



            if (noConnectivity)
            {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                displayNotification1();
            }
            else 
            {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                displayNotification2();
            }
        }
    }

    int id=1;
    private void displayNotification1()
    {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                                    .setSmallIcon(R.drawable.ic_network_wifi)
                                    .setContentTitle("No connection")
                                    .setContentText("Please connect")
                                    .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                                    .build();
        notificationManagerCompat.notify(id, notification);
        id++;
    }

    private void displayNotification2()
    {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_network_wifi)
                .setContentTitle("Connected")
                .setContentText("You have been connected")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();
        notificationManagerCompat.notify(id, notification);
        id++;
    }
}
