package shopping.microkart;

import com.firebase.client.Firebase;

public class MainActivity extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        Firebase.setAndroidContext(this);
    }
}
