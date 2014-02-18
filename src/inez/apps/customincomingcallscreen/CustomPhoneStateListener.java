package inez.apps.customincomingcallscreen;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class CustomPhoneStateListener extends PhoneStateListener {

	Context context;
	
	public CustomPhoneStateListener(Context context) {
	    super();
	    this.context = context;
	}
	
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		super.onCallStateChanged(state, incomingNumber);

		Intent i;
		
	    switch (state) {
	    	case TelephonyManager.CALL_STATE_RINGING:
	            i = new Intent(context, MyService.class);
	            i.putExtra("incomingNumber", incomingNumber);
	            context.startService(i);
	            break;

	    	default:
	    		i = new Intent(context, MyService.class);
	            context.stopService(i);
	    		break;
	    }
	}
}
