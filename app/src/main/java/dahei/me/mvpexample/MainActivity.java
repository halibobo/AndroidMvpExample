package dahei.me.mvpexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

import dahei.me.mvpexample.data.Phone;
import dahei.me.mvpexample.data.PhoneFactory;
import dahei.me.mvpexample.tasks.TaskPresenter;

public class MainActivity extends AppCompatActivity implements OperationView {

    private ListView listView;

    private Button btnCreate;

    private TaskPresenter phonePresenter;

    private ProgressDialog mLoadingDialog;
    ArrayAdapter<Phone> arrayAdapter;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phonePresenter = new PhonePresenter( this);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phonePresenter.getPhonesList());
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonePresenter.addRandomPhone();
            }
        });

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                phonePresenter.removePhone(position);
            }
        });

    }

    @Override
    public void showCreatingPhone() {
        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mLoadingDialog.setMessage("工厂正在生产手机");
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.show();
    }

    @Override
    public void showPhoneCountChange() {
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoPhone() {
        findViewById(R.id.noPhone).setVisibility(View.VISIBLE);
    }



    @Override
    public void showFactoryBusy() {
        showToast("工厂繁忙，请稍后再试！");
    }

    @Override
    public void showCreatedPhone() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
        showToast("新生产出一台手机！");
    }

    @Override
    public void hideNoPhone() {
        findViewById(R.id.noPhone).setVisibility(View.GONE);
    }

    private void showToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(this, string, Toast.LENGTH_SHORT);
        }else{
            toast.setText(string);
        }
        toast.show();
    }
}
