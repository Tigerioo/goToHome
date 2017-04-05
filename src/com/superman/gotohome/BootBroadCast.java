/**
 * 
 */
package com.superman.gotohome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * <p>Title: com.superman.gotohome.BootBroadCast.java</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2001-2013 Newland SoftWare Company</p>
 *
 * <p>Company: Newland SoftWare Company</p>
 *
 * @author Lewis.Lynn
 *
 * @version 1.0 CreateTime：2014-3-4 下午9:18:33
 */

public class BootBroadCast extends BroadcastReceiver{

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		/*  
         * 开机启动服务
         * */
         Intent service=new Intent(context, GoToHomeService.class);  
         context.startService(service);  
		
	}
	
}
