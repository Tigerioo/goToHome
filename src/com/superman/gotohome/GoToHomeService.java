package com.superman.gotohome;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * <p>Title: com.superman.gotohome.service.GoToHomeService.java</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2001-2013 Newland SoftWare Company</p>
 *
 * <p>Company: Newland SoftWare Company</p>
 *
 * @author Lewis.Lynn
 *
 * @version 1.0 CreateTime：2014-3-4 下午8:29:01
 */

public class GoToHomeService extends Service{

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		int notify_id = 001;
		Intent i = new Intent(Intent.ACTION_MAIN);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addCategory(Intent.CATEGORY_HOME);
		
		PendingIntent pi = PendingIntent.getActivity(GoToHomeService.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
    	NotificationCompat.Builder mBuilder =
    		    new NotificationCompat.Builder(this)
    		    .setSmallIcon(R.drawable.ic_launcher)
    		    .setOngoing(true)
    		    .setContentTitle("Go TO HOME")
    		    .setContentText("点击回到桌面");
    	mBuilder.setContentIntent(pi);
    	
    	NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    	notificationManager.notify(notify_id, mBuilder.build());
    	
    	startActivity(i);
    	
	}
	
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
