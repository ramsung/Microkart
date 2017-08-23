package shopping.microkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import shopping.microkart.Classes.ProductClass;

public class SellerDetailsActivity extends AppCompatActivity {
    private static String ProductName;
    private static String productid;
    private ArrayList<Integer> BargainPrice;
    private ArrayList<Firebase> BidReferences;
    private ProductClass Product;
    private static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_details);
        Firebase.setAndroidContext(this);
        /**ENABLING THE BACK BUTTON**/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /** GETTING THE INTENT FROM PREVIOUS ACTIVITY TO SHOW PRODUCT DETAILS**/
        Product = (ProductClass) getIntent().getSerializableExtra("IntentProduct");
        System.out.println("BBDGsavdgvsavadgsvdgsVCTAVWYT"+Product.getId()+Product.getName());
        /** INITIALISATIONS **/
        ImageView SPImage = (ImageView) findViewById(R.id.SellerProductImageView);
        TextView SPName = (TextView) findViewById(R.id.SellerProductName);
        TextView SPPrice = (TextView) findViewById(R.id.SellerProductPrice);
        TextView SPDescription = (TextView) findViewById(R.id.SellerProductDescription);

        // SETTING THE DETAILS IN THE CONTAINERS
        SPName.setText(Product.getName());
        SPPrice.setText(Integer.toString(Product.getprice()));
        SPDescription.setText(Product.getDescription());
        Picasso.with(this)
                .load(Product.getImage())
                .error(R.drawable.witty)
                .into(SPImage);
        productid = Product.getId();

    }

    /** WHEN CLICKED ON BACK BUTTON **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // BACK CLICKED. GO TO HOME.
                Intent intent = new Intent(this, SellerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //FINISH THE CURRENT ACTIVITY
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}