/**
 * 
 */
package com.superman.gotohome.core;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.superman.gotohome.GoToHomeService;
import com.superman.gotohome.R;

/**
 * <p>Title: com.superman.gotohome.MainActivity.MainActivity.java</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2001-2013 Newland SoftWare Company</p>
 *
 * <p>Company: Newland SoftWare Company</p>
 *
 * @author Lewis.Lynn
 *
 * @version 1.0 CreateTime：2014-3-5 上午10:26:43
 */

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		
		if(!isServiceExisted(this, "com.superman.gotohome.GoToHomeService")){
			Intent service=new Intent(this, GoToHomeService.class);  
	        this.startService(service);
	        Toast.makeText(MainActivity.this, "服务已启动", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(MainActivity.this, "服务已存在", Toast.LENGTH_SHORT).show();
		}
		
		Intent i = new Intent(Intent.ACTION_MAIN);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addCategory(Intent.CATEGORY_HOME);
		startActivity(i);
		
		MainActivity.this.finish();
	}

	/**
	 * 是否包含指定服务
	 * @param context
	 * @param className
	 * @return
	 */
	 public boolean isServiceExisted(Context context, String className) {
	        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);

	        if(!(serviceList.size() > 0)) {
	            return false;
	        }

	        for(int i = 0; i < serviceList.size(); i++) {
	            RunningServiceInfo serviceInfo = serviceList.get(i);
	            ComponentName serviceName = serviceInfo.service;
	            
	            if(serviceName.getClassName().contains(className)) {
	                return true;
	            }
	        } 
	        return false;
	    }
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(MainActivity.this, "注销!", Toast.LENGTH_SHORT).show();
	}
	
}
