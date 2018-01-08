package c.a202;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContactOperations.Insert2Contacts(getApplicationContext(),
                "Unknown Number 1", "05321000000");
        if (ContactOperations.isTheNumberExistsinContacts(
                getApplicationContext(), "05321000000")) {
            Log.i(ContactOperations.TAG, "Exists");
            try {
                ContactOperations.updateContact(getApplicationContext(),"Unknown Number 1", "55555550000" );
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(ContactOperations.TAG, "Not Exists");
        }

        setContentView(R.layout.activity_main);
    }
}
